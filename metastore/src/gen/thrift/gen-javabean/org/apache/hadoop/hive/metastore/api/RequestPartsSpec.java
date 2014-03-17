/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.hadoop.hive.metastore.api;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestPartsSpec extends org.apache.thrift.TUnion<RequestPartsSpec, RequestPartsSpec._Fields> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("RequestPartsSpec");
  private static final org.apache.thrift.protocol.TField NAMES_FIELD_DESC = new org.apache.thrift.protocol.TField("names", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField EXPRS_FIELD_DESC = new org.apache.thrift.protocol.TField("exprs", org.apache.thrift.protocol.TType.LIST, (short)2);

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NAMES((short)1, "names"),
    EXPRS((short)2, "exprs");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // NAMES
          return NAMES;
        case 2: // EXPRS
          return EXPRS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NAMES, new org.apache.thrift.meta_data.FieldMetaData("names", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.EXPRS, new org.apache.thrift.meta_data.FieldMetaData("exprs", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, DropPartitionsExpr.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(RequestPartsSpec.class, metaDataMap);
  }

  public RequestPartsSpec() {
    super();
  }

  public RequestPartsSpec(_Fields setField, Object value) {
    super(setField, value);
  }

  public RequestPartsSpec(RequestPartsSpec other) {
    super(other);
  }
  public RequestPartsSpec deepCopy() {
    return new RequestPartsSpec(this);
  }

  public static RequestPartsSpec names(List<String> value) {
    RequestPartsSpec x = new RequestPartsSpec();
    x.setNames(value);
    return x;
  }

  public static RequestPartsSpec exprs(List<DropPartitionsExpr> value) {
    RequestPartsSpec x = new RequestPartsSpec();
    x.setExprs(value);
    return x;
  }


  @Override
  protected void checkType(_Fields setField, Object value) throws ClassCastException {
    switch (setField) {
      case NAMES:
        if (value instanceof List) {
          break;
        }
        throw new ClassCastException("Was expecting value of type List<String> for field 'names', but got " + value.getClass().getSimpleName());
      case EXPRS:
        if (value instanceof List) {
          break;
        }
        throw new ClassCastException("Was expecting value of type List<DropPartitionsExpr> for field 'exprs', but got " + value.getClass().getSimpleName());
      default:
        throw new IllegalArgumentException("Unknown field id " + setField);
    }
  }

  @Override
  protected Object standardSchemeReadValue(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TField field) throws org.apache.thrift.TException {
    _Fields setField = _Fields.findByThriftId(field.id);
    if (setField != null) {
      switch (setField) {
        case NAMES:
          if (field.type == NAMES_FIELD_DESC.type) {
            List<String> names;
            {
              org.apache.thrift.protocol.TList _list346 = iprot.readListBegin();
              names = new ArrayList<String>(_list346.size);
              for (int _i347 = 0; _i347 < _list346.size; ++_i347)
              {
                String _elem348; // required
                _elem348 = iprot.readString();
                names.add(_elem348);
              }
              iprot.readListEnd();
            }
            return names;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case EXPRS:
          if (field.type == EXPRS_FIELD_DESC.type) {
            List<DropPartitionsExpr> exprs;
            {
              org.apache.thrift.protocol.TList _list349 = iprot.readListBegin();
              exprs = new ArrayList<DropPartitionsExpr>(_list349.size);
              for (int _i350 = 0; _i350 < _list349.size; ++_i350)
              {
                DropPartitionsExpr _elem351; // required
                _elem351 = new DropPartitionsExpr();
                _elem351.read(iprot);
                exprs.add(_elem351);
              }
              iprot.readListEnd();
            }
            return exprs;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        default:
          throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
      }
    } else {
      return null;
    }
  }

  @Override
  protected void standardSchemeWriteValue(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    switch (setField_) {
      case NAMES:
        List<String> names = (List<String>)value_;
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, names.size()));
          for (String _iter352 : names)
          {
            oprot.writeString(_iter352);
          }
          oprot.writeListEnd();
        }
        return;
      case EXPRS:
        List<DropPartitionsExpr> exprs = (List<DropPartitionsExpr>)value_;
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, exprs.size()));
          for (DropPartitionsExpr _iter353 : exprs)
          {
            _iter353.write(oprot);
          }
          oprot.writeListEnd();
        }
        return;
      default:
        throw new IllegalStateException("Cannot write union with unknown field " + setField_);
    }
  }

  @Override
  protected Object tupleSchemeReadValue(org.apache.thrift.protocol.TProtocol iprot, short fieldID) throws org.apache.thrift.TException {
    _Fields setField = _Fields.findByThriftId(fieldID);
    if (setField != null) {
      switch (setField) {
        case NAMES:
          List<String> names;
          {
            org.apache.thrift.protocol.TList _list354 = iprot.readListBegin();
            names = new ArrayList<String>(_list354.size);
            for (int _i355 = 0; _i355 < _list354.size; ++_i355)
            {
              String _elem356; // required
              _elem356 = iprot.readString();
              names.add(_elem356);
            }
            iprot.readListEnd();
          }
          return names;
        case EXPRS:
          List<DropPartitionsExpr> exprs;
          {
            org.apache.thrift.protocol.TList _list357 = iprot.readListBegin();
            exprs = new ArrayList<DropPartitionsExpr>(_list357.size);
            for (int _i358 = 0; _i358 < _list357.size; ++_i358)
            {
              DropPartitionsExpr _elem359; // required
              _elem359 = new DropPartitionsExpr();
              _elem359.read(iprot);
              exprs.add(_elem359);
            }
            iprot.readListEnd();
          }
          return exprs;
        default:
          throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
      }
    } else {
      throw new TProtocolException("Couldn't find a field with field id " + fieldID);
    }
  }

  @Override
  protected void tupleSchemeWriteValue(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    switch (setField_) {
      case NAMES:
        List<String> names = (List<String>)value_;
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, names.size()));
          for (String _iter360 : names)
          {
            oprot.writeString(_iter360);
          }
          oprot.writeListEnd();
        }
        return;
      case EXPRS:
        List<DropPartitionsExpr> exprs = (List<DropPartitionsExpr>)value_;
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, exprs.size()));
          for (DropPartitionsExpr _iter361 : exprs)
          {
            _iter361.write(oprot);
          }
          oprot.writeListEnd();
        }
        return;
      default:
        throw new IllegalStateException("Cannot write union with unknown field " + setField_);
    }
  }

  @Override
  protected org.apache.thrift.protocol.TField getFieldDesc(_Fields setField) {
    switch (setField) {
      case NAMES:
        return NAMES_FIELD_DESC;
      case EXPRS:
        return EXPRS_FIELD_DESC;
      default:
        throw new IllegalArgumentException("Unknown field id " + setField);
    }
  }

  @Override
  protected org.apache.thrift.protocol.TStruct getStructDesc() {
    return STRUCT_DESC;
  }

  @Override
  protected _Fields enumForId(short id) {
    return _Fields.findByThriftIdOrThrow(id);
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }


  public List<String> getNames() {
    if (getSetField() == _Fields.NAMES) {
      return (List<String>)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'names' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setNames(List<String> value) {
    if (value == null) throw new NullPointerException();
    setField_ = _Fields.NAMES;
    value_ = value;
  }

  public List<DropPartitionsExpr> getExprs() {
    if (getSetField() == _Fields.EXPRS) {
      return (List<DropPartitionsExpr>)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'exprs' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setExprs(List<DropPartitionsExpr> value) {
    if (value == null) throw new NullPointerException();
    setField_ = _Fields.EXPRS;
    value_ = value;
  }

  public boolean isSetNames() {
    return setField_ == _Fields.NAMES;
  }


  public boolean isSetExprs() {
    return setField_ == _Fields.EXPRS;
  }


  public boolean equals(Object other) {
    if (other instanceof RequestPartsSpec) {
      return equals((RequestPartsSpec)other);
    } else {
      return false;
    }
  }

  public boolean equals(RequestPartsSpec other) {
    return other != null && getSetField() == other.getSetField() && getFieldValue().equals(other.getFieldValue());
  }

  @Override
  public int compareTo(RequestPartsSpec other) {
    int lastComparison = org.apache.thrift.TBaseHelper.compareTo(getSetField(), other.getSetField());
    if (lastComparison == 0) {
      return org.apache.thrift.TBaseHelper.compareTo(getFieldValue(), other.getFieldValue());
    }
    return lastComparison;
  }


  @Override
  public int hashCode() {
    HashCodeBuilder hcb = new HashCodeBuilder();
    hcb.append(this.getClass().getName());
    org.apache.thrift.TFieldIdEnum setField = getSetField();
    if (setField != null) {
      hcb.append(setField.getThriftFieldId());
      Object value = getFieldValue();
      if (value instanceof org.apache.thrift.TEnum) {
        hcb.append(((org.apache.thrift.TEnum)getFieldValue()).getValue());
      } else {
        hcb.append(value);
      }
    }
    return hcb.toHashCode();
  }
  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }


  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }


}
