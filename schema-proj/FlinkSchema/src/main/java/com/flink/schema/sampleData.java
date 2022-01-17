/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.flink.schema;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class sampleData extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 6324207351522225709L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"sampleData\",\"namespace\":\"com.flink.schema\",\"fields\":[{\"name\":\"parameter\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<sampleData> ENCODER =
      new BinaryMessageEncoder<sampleData>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<sampleData> DECODER =
      new BinaryMessageDecoder<sampleData>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<sampleData> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<sampleData> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<sampleData> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<sampleData>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this sampleData to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a sampleData from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a sampleData instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static sampleData fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public int parameter;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public sampleData() {}

  /**
   * All-args constructor.
   * @param parameter The new value for parameter
   */
  public sampleData(java.lang.Integer parameter) {
    this.parameter = parameter;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return parameter;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: parameter = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'parameter' field.
   * @return The value of the 'parameter' field.
   */
  public int getParameter() {
    return parameter;
  }


  /**
   * Sets the value of the 'parameter' field.
   * @param value the value to set.
   */
  public void setParameter(int value) {
    this.parameter = value;
  }

  /**
   * Creates a new sampleData RecordBuilder.
   * @return A new sampleData RecordBuilder
   */
  public static com.flink.schema.sampleData.Builder newBuilder() {
    return new com.flink.schema.sampleData.Builder();
  }

  /**
   * Creates a new sampleData RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new sampleData RecordBuilder
   */
  public static com.flink.schema.sampleData.Builder newBuilder(com.flink.schema.sampleData.Builder other) {
    if (other == null) {
      return new com.flink.schema.sampleData.Builder();
    } else {
      return new com.flink.schema.sampleData.Builder(other);
    }
  }

  /**
   * Creates a new sampleData RecordBuilder by copying an existing sampleData instance.
   * @param other The existing instance to copy.
   * @return A new sampleData RecordBuilder
   */
  public static com.flink.schema.sampleData.Builder newBuilder(com.flink.schema.sampleData other) {
    if (other == null) {
      return new com.flink.schema.sampleData.Builder();
    } else {
      return new com.flink.schema.sampleData.Builder(other);
    }
  }

  /**
   * RecordBuilder for sampleData instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<sampleData>
    implements org.apache.avro.data.RecordBuilder<sampleData> {

    private int parameter;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.flink.schema.sampleData.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.parameter)) {
        this.parameter = data().deepCopy(fields()[0].schema(), other.parameter);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
    }

    /**
     * Creates a Builder by copying an existing sampleData instance
     * @param other The existing instance to copy.
     */
    private Builder(com.flink.schema.sampleData other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.parameter)) {
        this.parameter = data().deepCopy(fields()[0].schema(), other.parameter);
        fieldSetFlags()[0] = true;
      }
    }

    /**
      * Gets the value of the 'parameter' field.
      * @return The value.
      */
    public int getParameter() {
      return parameter;
    }


    /**
      * Sets the value of the 'parameter' field.
      * @param value The value of 'parameter'.
      * @return This builder.
      */
    public com.flink.schema.sampleData.Builder setParameter(int value) {
      validate(fields()[0], value);
      this.parameter = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'parameter' field has been set.
      * @return True if the 'parameter' field has been set, false otherwise.
      */
    public boolean hasParameter() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'parameter' field.
      * @return This builder.
      */
    public com.flink.schema.sampleData.Builder clearParameter() {
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public sampleData build() {
      try {
        sampleData record = new sampleData();
        record.parameter = fieldSetFlags()[0] ? this.parameter : (java.lang.Integer) defaultValue(fields()[0]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<sampleData>
    WRITER$ = (org.apache.avro.io.DatumWriter<sampleData>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<sampleData>
    READER$ = (org.apache.avro.io.DatumReader<sampleData>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeInt(this.parameter);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.parameter = in.readInt();

    } else {
      for (int i = 0; i < 1; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.parameter = in.readInt();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










