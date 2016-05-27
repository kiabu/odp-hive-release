/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.hive.service.cli.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
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
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)")
public class TUserDefinedTypeEntry implements org.apache.thrift.TBase<TUserDefinedTypeEntry, TUserDefinedTypeEntry._Fields>, java.io.Serializable, Cloneable, Comparable<TUserDefinedTypeEntry> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TUserDefinedTypeEntry");

  private static final org.apache.thrift.protocol.TField TYPE_CLASS_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("typeClassName", org.apache.thrift.protocol.TType.STRING, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TUserDefinedTypeEntryStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TUserDefinedTypeEntryTupleSchemeFactory());
  }

  private String typeClassName; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TYPE_CLASS_NAME((short)1, "typeClassName");

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
        case 1: // TYPE_CLASS_NAME
          return TYPE_CLASS_NAME;
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

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TYPE_CLASS_NAME, new org.apache.thrift.meta_data.FieldMetaData("typeClassName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TUserDefinedTypeEntry.class, metaDataMap);
  }

  public TUserDefinedTypeEntry() {
  }

  public TUserDefinedTypeEntry(
    String typeClassName)
  {
    this();
    this.typeClassName = typeClassName;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TUserDefinedTypeEntry(TUserDefinedTypeEntry other) {
    if (other.isSetTypeClassName()) {
      this.typeClassName = other.typeClassName;
    }
  }

  public TUserDefinedTypeEntry deepCopy() {
    return new TUserDefinedTypeEntry(this);
  }

  @Override
  public void clear() {
    this.typeClassName = null;
  }

  public String getTypeClassName() {
    return this.typeClassName;
  }

  public void setTypeClassName(String typeClassName) {
    this.typeClassName = typeClassName;
  }

  public void unsetTypeClassName() {
    this.typeClassName = null;
  }

  /** Returns true if field typeClassName is set (has been assigned a value) and false otherwise */
  public boolean isSetTypeClassName() {
    return this.typeClassName != null;
  }

  public void setTypeClassNameIsSet(boolean value) {
    if (!value) {
      this.typeClassName = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TYPE_CLASS_NAME:
      if (value == null) {
        unsetTypeClassName();
      } else {
        setTypeClassName((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TYPE_CLASS_NAME:
      return getTypeClassName();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TYPE_CLASS_NAME:
      return isSetTypeClassName();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TUserDefinedTypeEntry)
      return this.equals((TUserDefinedTypeEntry)that);
    return false;
  }

  public boolean equals(TUserDefinedTypeEntry that) {
    if (that == null)
      return false;

    boolean this_present_typeClassName = true && this.isSetTypeClassName();
    boolean that_present_typeClassName = true && that.isSetTypeClassName();
    if (this_present_typeClassName || that_present_typeClassName) {
      if (!(this_present_typeClassName && that_present_typeClassName))
        return false;
      if (!this.typeClassName.equals(that.typeClassName))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_typeClassName = true && (isSetTypeClassName());
    list.add(present_typeClassName);
    if (present_typeClassName)
      list.add(typeClassName);

    return list.hashCode();
  }

  @Override
  public int compareTo(TUserDefinedTypeEntry other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetTypeClassName()).compareTo(other.isSetTypeClassName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTypeClassName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.typeClassName, other.typeClassName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("TUserDefinedTypeEntry(");
    boolean first = true;

    sb.append("typeClassName:");
    if (this.typeClassName == null) {
      sb.append("null");
    } else {
      sb.append(this.typeClassName);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetTypeClassName()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'typeClassName' is unset! Struct:" + toString());
    }

    // check for sub-struct validity
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

  private static class TUserDefinedTypeEntryStandardSchemeFactory implements SchemeFactory {
    public TUserDefinedTypeEntryStandardScheme getScheme() {
      return new TUserDefinedTypeEntryStandardScheme();
    }
  }

  private static class TUserDefinedTypeEntryStandardScheme extends StandardScheme<TUserDefinedTypeEntry> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TUserDefinedTypeEntry struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TYPE_CLASS_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.typeClassName = iprot.readString();
              struct.setTypeClassNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TUserDefinedTypeEntry struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.typeClassName != null) {
        oprot.writeFieldBegin(TYPE_CLASS_NAME_FIELD_DESC);
        oprot.writeString(struct.typeClassName);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TUserDefinedTypeEntryTupleSchemeFactory implements SchemeFactory {
    public TUserDefinedTypeEntryTupleScheme getScheme() {
      return new TUserDefinedTypeEntryTupleScheme();
    }
  }

  private static class TUserDefinedTypeEntryTupleScheme extends TupleScheme<TUserDefinedTypeEntry> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TUserDefinedTypeEntry struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.typeClassName);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TUserDefinedTypeEntry struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.typeClassName = iprot.readString();
      struct.setTypeClassNameIsSet(true);
    }
  }

}

