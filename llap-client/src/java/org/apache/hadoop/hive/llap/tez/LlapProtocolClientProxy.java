/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.hadoop.hive.llap.tez;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.net.SocketFactory;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.conf.HiveConf.ConfVars;
import org.apache.hadoop.hive.llap.AsyncPbRpcProxy;
import org.apache.hadoop.hive.llap.LlapNodeId;
import org.apache.hadoop.hive.llap.daemon.rpc.LlapDaemonProtocolProtos.QueryCompleteRequestProto;
import org.apache.hadoop.hive.llap.daemon.rpc.LlapDaemonProtocolProtos.QueryCompleteResponseProto;
import org.apache.hadoop.hive.llap.daemon.rpc.LlapDaemonProtocolProtos.SourceStateUpdatedRequestProto;
import org.apache.hadoop.hive.llap.daemon.rpc.LlapDaemonProtocolProtos.SourceStateUpdatedResponseProto;
import org.apache.hadoop.hive.llap.daemon.rpc.LlapDaemonProtocolProtos.SubmitWorkRequestProto;
import org.apache.hadoop.hive.llap.daemon.rpc.LlapDaemonProtocolProtos.SubmitWorkResponseProto;
import org.apache.hadoop.hive.llap.daemon.rpc.LlapDaemonProtocolProtos.TerminateFragmentRequestProto;
import org.apache.hadoop.hive.llap.daemon.rpc.LlapDaemonProtocolProtos.TerminateFragmentResponseProto;
import org.apache.hadoop.hive.llap.daemon.rpc.LlapDaemonProtocolProtos.UpdateFragmentRequestProto;
import org.apache.hadoop.hive.llap.daemon.rpc.LlapDaemonProtocolProtos.UpdateFragmentResponseProto;
import org.apache.hadoop.hive.llap.impl.LlapProtocolClientImpl;
import org.apache.hadoop.hive.llap.protocol.LlapProtocolBlockingPB;
import org.apache.hadoop.hive.llap.security.LlapTokenIdentifier;
import org.apache.hadoop.io.retry.RetryPolicy;
import org.apache.hadoop.security.UserGroupInformation;
import org.apache.hadoop.security.token.Token;

public class LlapProtocolClientProxy
  extends AsyncPbRpcProxy<LlapProtocolBlockingPB, LlapTokenIdentifier> {

  public LlapProtocolClientProxy(
      int numThreads, Configuration conf, Token<LlapTokenIdentifier> llapToken) {
    super(LlapProtocolClientProxy.class.getSimpleName(), numThreads, conf, llapToken,
        HiveConf.getTimeVar(conf, ConfVars.LLAP_TASK_COMMUNICATOR_CONNECTION_TIMEOUT_MS,
            TimeUnit.MILLISECONDS),
        HiveConf.getTimeVar(conf, ConfVars.LLAP_TASK_COMMUNICATOR_CONNECTION_SLEEP_BETWEEN_RETRIES_MS,
            TimeUnit.MILLISECONDS), -1);
  }

  public void sendSubmitWork(SubmitWorkRequestProto request, String host, int port,
                         final ExecuteRequestCallback<SubmitWorkResponseProto> callback) {
    LlapNodeId nodeId = LlapNodeId.getInstance(host, port);
    queueRequest(new SubmitWorkCallable(nodeId, request, callback));
  }

  public void sendSourceStateUpdate(final SourceStateUpdatedRequestProto request, final LlapNodeId nodeId,
                                    final ExecuteRequestCallback<SourceStateUpdatedResponseProto> callback) {
    queueRequest(new SendSourceStateUpdateCallable(nodeId, request, callback));
  }

  public void sendQueryComplete(final QueryCompleteRequestProto request, final String host,
                                final int port,
                                final ExecuteRequestCallback<QueryCompleteResponseProto> callback) {
    LlapNodeId nodeId = LlapNodeId.getInstance(host, port);
    queueRequest(new SendQueryCompleteCallable(nodeId, request, callback));
  }


  public void sendUpdateFragment(final UpdateFragmentRequestProto request, final String host,
      final int port, final ExecuteRequestCallback<UpdateFragmentResponseProto> callback) {
    LlapNodeId nodeId = LlapNodeId.getInstance(host, port);
    queueRequest(new SendUpdateFragmentCallable(nodeId, request, callback));
  }

  public void sendTerminateFragment(final TerminateFragmentRequestProto request, final String host,
                                    final int port,
                                    final ExecuteRequestCallback<TerminateFragmentResponseProto> callback) {
    LlapNodeId nodeId = LlapNodeId.getInstance(host, port);
    queueRequest(new SendTerminateFragmentCallable(nodeId, request, callback));
  }

  private class SubmitWorkCallable extends CallableRequest<SubmitWorkRequestProto, SubmitWorkResponseProto> {

    protected SubmitWorkCallable(LlapNodeId nodeId,
                          SubmitWorkRequestProto submitWorkRequestProto,
                                 ExecuteRequestCallback<SubmitWorkResponseProto> callback) {
      super(nodeId, submitWorkRequestProto, callback);
    }

    @Override
    public SubmitWorkResponseProto call() throws Exception {
      return getProxy(nodeId).submitWork(null, request);
    }
  }

  private class SendSourceStateUpdateCallable
      extends CallableRequest<SourceStateUpdatedRequestProto, SourceStateUpdatedResponseProto> {

    public SendSourceStateUpdateCallable(LlapNodeId nodeId,
                                         SourceStateUpdatedRequestProto request,
                                         ExecuteRequestCallback<SourceStateUpdatedResponseProto> callback) {
      super(nodeId, request, callback);
    }

    @Override
    public SourceStateUpdatedResponseProto call() throws Exception {
      return getProxy(nodeId).sourceStateUpdated(null, request);
    }
  }

  private class SendQueryCompleteCallable
      extends CallableRequest<QueryCompleteRequestProto, QueryCompleteResponseProto> {

    protected SendQueryCompleteCallable(LlapNodeId nodeId,
                                        QueryCompleteRequestProto queryCompleteRequestProto,
                                        ExecuteRequestCallback<QueryCompleteResponseProto> callback) {
      super(nodeId, queryCompleteRequestProto, callback);
    }

    @Override
    public QueryCompleteResponseProto call() throws Exception {
      return getProxy(nodeId).queryComplete(null, request);
    }
  }

  private class SendTerminateFragmentCallable
      extends CallableRequest<TerminateFragmentRequestProto, TerminateFragmentResponseProto> {

    protected SendTerminateFragmentCallable(LlapNodeId nodeId,
                                            TerminateFragmentRequestProto terminateFragmentRequestProto,
                                            ExecuteRequestCallback<TerminateFragmentResponseProto> callback) {
      super(nodeId, terminateFragmentRequestProto, callback);
    }

    @Override
    public TerminateFragmentResponseProto call() throws Exception {
      return getProxy(nodeId).terminateFragment(null, request);
    }
  }

  private class SendUpdateFragmentCallable
      extends CallableRequest<UpdateFragmentRequestProto, UpdateFragmentResponseProto> {

    protected SendUpdateFragmentCallable(LlapNodeId nodeId,
        UpdateFragmentRequestProto terminateFragmentRequestProto,
        ExecuteRequestCallback<UpdateFragmentResponseProto> callback) {
      super(nodeId, terminateFragmentRequestProto, callback);
    }

    @Override
    public UpdateFragmentResponseProto call() throws Exception {
      return getProxy(nodeId).updateFragment(null, request);
    }
  }

  @Override
  protected LlapProtocolBlockingPB createProtocolImpl(Configuration config, String hostname, int port,
      UserGroupInformation ugi, RetryPolicy retryPolicy, SocketFactory socketFactory) {
    return new LlapProtocolClientImpl(config, hostname, port, ugi, retryPolicy, socketFactory);
  }

  @Override
  protected String getTokenUser(Token<LlapTokenIdentifier> token) {
    if (token == null) return null;
    try {
      return token.decodeIdentifier().getOwner().toString();
    } catch (IOException e) {
      throw new RuntimeException("Cannot determine the user from token " + token, e);
    }
  }

  @Override
  protected void shutdownProtocolImpl(LlapProtocolBlockingPB client) {
    // Nothing to do.
  }
}
