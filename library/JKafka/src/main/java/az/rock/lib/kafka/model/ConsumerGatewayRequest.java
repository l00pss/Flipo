/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package az.rock.lib.kafka.model;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class ConsumerGatewayRequest extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -4052147208030485426L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ConsumerGatewayRequest\",\"namespace\":\"az.rock.lib.kafka.model\",\"fields\":[{\"name\":\"uuid\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"time\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"ipAddress\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"userPrivateKey\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"userUUID\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<ConsumerGatewayRequest> ENCODER =
      new BinaryMessageEncoder<ConsumerGatewayRequest>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<ConsumerGatewayRequest> DECODER =
      new BinaryMessageDecoder<ConsumerGatewayRequest>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<ConsumerGatewayRequest> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<ConsumerGatewayRequest> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<ConsumerGatewayRequest> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<ConsumerGatewayRequest>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this ConsumerGatewayRequest to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a ConsumerGatewayRequest from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a ConsumerGatewayRequest instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static ConsumerGatewayRequest fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.String uuid;
  private java.lang.String time;
  private java.lang.String ipAddress;
  private java.lang.String userPrivateKey;
  private java.lang.String userUUID;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ConsumerGatewayRequest() {}

  /**
   * All-args constructor.
   * @param uuid The new value for uuid
   * @param time The new value for time
   * @param ipAddress The new value for ipAddress
   * @param userPrivateKey The new value for userPrivateKey
   * @param userUUID The new value for userUUID
   */
  public ConsumerGatewayRequest(java.lang.String uuid, java.lang.String time, java.lang.String ipAddress, java.lang.String userPrivateKey, java.lang.String userUUID) {
    this.uuid = uuid;
    this.time = time;
    this.ipAddress = ipAddress;
    this.userPrivateKey = userPrivateKey;
    this.userUUID = userUUID;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return uuid;
    case 1: return time;
    case 2: return ipAddress;
    case 3: return userPrivateKey;
    case 4: return userUUID;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      null,
      null,
      null,
      null,
      null,
      null
  };

  @Override
  public org.apache.avro.Conversion<?> getConversion(int field) {
    return conversions[field];
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: uuid = value$ != null ? value$.toString() : null; break;
    case 1: time = value$ != null ? value$.toString() : null; break;
    case 2: ipAddress = value$ != null ? value$.toString() : null; break;
    case 3: userPrivateKey = value$ != null ? value$.toString() : null; break;
    case 4: userUUID = value$ != null ? value$.toString() : null; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'uuid' field.
   * @return The value of the 'uuid' field.
   */
  public java.lang.String getUuid() {
    return uuid;
  }


  /**
   * Sets the value of the 'uuid' field.
   * @param value the value to set.
   */
  public void setUuid(java.lang.String value) {
    this.uuid = value;
  }

  /**
   * Gets the value of the 'time' field.
   * @return The value of the 'time' field.
   */
  public java.lang.String getTime() {
    return time;
  }


  /**
   * Sets the value of the 'time' field.
   * @param value the value to set.
   */
  public void setTime(java.lang.String value) {
    this.time = value;
  }

  /**
   * Gets the value of the 'ipAddress' field.
   * @return The value of the 'ipAddress' field.
   */
  public java.lang.String getIpAddress() {
    return ipAddress;
  }


  /**
   * Sets the value of the 'ipAddress' field.
   * @param value the value to set.
   */
  public void setIpAddress(java.lang.String value) {
    this.ipAddress = value;
  }

  /**
   * Gets the value of the 'userPrivateKey' field.
   * @return The value of the 'userPrivateKey' field.
   */
  public java.lang.String getUserPrivateKey() {
    return userPrivateKey;
  }


  /**
   * Sets the value of the 'userPrivateKey' field.
   * @param value the value to set.
   */
  public void setUserPrivateKey(java.lang.String value) {
    this.userPrivateKey = value;
  }

  /**
   * Gets the value of the 'userUUID' field.
   * @return The value of the 'userUUID' field.
   */
  public java.lang.String getUserUUID() {
    return userUUID;
  }


  /**
   * Sets the value of the 'userUUID' field.
   * @param value the value to set.
   */
  public void setUserUUID(java.lang.String value) {
    this.userUUID = value;
  }

  /**
   * Creates a new ConsumerGatewayRequest RecordBuilder.
   * @return A new ConsumerGatewayRequest RecordBuilder
   */
  public static az.rock.lib.kafka.model.ConsumerGatewayRequest.Builder newBuilder() {
    return new az.rock.lib.kafka.model.ConsumerGatewayRequest.Builder();
  }

  /**
   * Creates a new ConsumerGatewayRequest RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ConsumerGatewayRequest RecordBuilder
   */
  public static az.rock.lib.kafka.model.ConsumerGatewayRequest.Builder newBuilder(az.rock.lib.kafka.model.ConsumerGatewayRequest.Builder other) {
    if (other == null) {
      return new az.rock.lib.kafka.model.ConsumerGatewayRequest.Builder();
    } else {
      return new az.rock.lib.kafka.model.ConsumerGatewayRequest.Builder(other);
    }
  }

  /**
   * Creates a new ConsumerGatewayRequest RecordBuilder by copying an existing ConsumerGatewayRequest instance.
   * @param other The existing instance to copy.
   * @return A new ConsumerGatewayRequest RecordBuilder
   */
  public static az.rock.lib.kafka.model.ConsumerGatewayRequest.Builder newBuilder(az.rock.lib.kafka.model.ConsumerGatewayRequest other) {
    if (other == null) {
      return new az.rock.lib.kafka.model.ConsumerGatewayRequest.Builder();
    } else {
      return new az.rock.lib.kafka.model.ConsumerGatewayRequest.Builder(other);
    }
  }

  /**
   * RecordBuilder for ConsumerGatewayRequest instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ConsumerGatewayRequest>
    implements org.apache.avro.data.RecordBuilder<ConsumerGatewayRequest> {

    private java.lang.String uuid;
    private java.lang.String time;
    private java.lang.String ipAddress;
    private java.lang.String userPrivateKey;
    private java.lang.String userUUID;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(az.rock.lib.kafka.model.ConsumerGatewayRequest.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.uuid)) {
        this.uuid = data().deepCopy(fields()[0].schema(), other.uuid);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.time)) {
        this.time = data().deepCopy(fields()[1].schema(), other.time);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.ipAddress)) {
        this.ipAddress = data().deepCopy(fields()[2].schema(), other.ipAddress);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.userPrivateKey)) {
        this.userPrivateKey = data().deepCopy(fields()[3].schema(), other.userPrivateKey);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.userUUID)) {
        this.userUUID = data().deepCopy(fields()[4].schema(), other.userUUID);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing ConsumerGatewayRequest instance
     * @param other The existing instance to copy.
     */
    private Builder(az.rock.lib.kafka.model.ConsumerGatewayRequest other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.uuid)) {
        this.uuid = data().deepCopy(fields()[0].schema(), other.uuid);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.time)) {
        this.time = data().deepCopy(fields()[1].schema(), other.time);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.ipAddress)) {
        this.ipAddress = data().deepCopy(fields()[2].schema(), other.ipAddress);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.userPrivateKey)) {
        this.userPrivateKey = data().deepCopy(fields()[3].schema(), other.userPrivateKey);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.userUUID)) {
        this.userUUID = data().deepCopy(fields()[4].schema(), other.userUUID);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'uuid' field.
      * @return The value.
      */
    public java.lang.String getUuid() {
      return uuid;
    }


    /**
      * Sets the value of the 'uuid' field.
      * @param value The value of 'uuid'.
      * @return This builder.
      */
    public az.rock.lib.kafka.model.ConsumerGatewayRequest.Builder setUuid(java.lang.String value) {
      validate(fields()[0], value);
      this.uuid = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'uuid' field has been set.
      * @return True if the 'uuid' field has been set, false otherwise.
      */
    public boolean hasUuid() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'uuid' field.
      * @return This builder.
      */
    public az.rock.lib.kafka.model.ConsumerGatewayRequest.Builder clearUuid() {
      uuid = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'time' field.
      * @return The value.
      */
    public java.lang.String getTime() {
      return time;
    }


    /**
      * Sets the value of the 'time' field.
      * @param value The value of 'time'.
      * @return This builder.
      */
    public az.rock.lib.kafka.model.ConsumerGatewayRequest.Builder setTime(java.lang.String value) {
      validate(fields()[1], value);
      this.time = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'time' field has been set.
      * @return True if the 'time' field has been set, false otherwise.
      */
    public boolean hasTime() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'time' field.
      * @return This builder.
      */
    public az.rock.lib.kafka.model.ConsumerGatewayRequest.Builder clearTime() {
      time = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'ipAddress' field.
      * @return The value.
      */
    public java.lang.String getIpAddress() {
      return ipAddress;
    }


    /**
      * Sets the value of the 'ipAddress' field.
      * @param value The value of 'ipAddress'.
      * @return This builder.
      */
    public az.rock.lib.kafka.model.ConsumerGatewayRequest.Builder setIpAddress(java.lang.String value) {
      validate(fields()[2], value);
      this.ipAddress = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'ipAddress' field has been set.
      * @return True if the 'ipAddress' field has been set, false otherwise.
      */
    public boolean hasIpAddress() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'ipAddress' field.
      * @return This builder.
      */
    public az.rock.lib.kafka.model.ConsumerGatewayRequest.Builder clearIpAddress() {
      ipAddress = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'userPrivateKey' field.
      * @return The value.
      */
    public java.lang.String getUserPrivateKey() {
      return userPrivateKey;
    }


    /**
      * Sets the value of the 'userPrivateKey' field.
      * @param value The value of 'userPrivateKey'.
      * @return This builder.
      */
    public az.rock.lib.kafka.model.ConsumerGatewayRequest.Builder setUserPrivateKey(java.lang.String value) {
      validate(fields()[3], value);
      this.userPrivateKey = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'userPrivateKey' field has been set.
      * @return True if the 'userPrivateKey' field has been set, false otherwise.
      */
    public boolean hasUserPrivateKey() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'userPrivateKey' field.
      * @return This builder.
      */
    public az.rock.lib.kafka.model.ConsumerGatewayRequest.Builder clearUserPrivateKey() {
      userPrivateKey = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'userUUID' field.
      * @return The value.
      */
    public java.lang.String getUserUUID() {
      return userUUID;
    }


    /**
      * Sets the value of the 'userUUID' field.
      * @param value The value of 'userUUID'.
      * @return This builder.
      */
    public az.rock.lib.kafka.model.ConsumerGatewayRequest.Builder setUserUUID(java.lang.String value) {
      validate(fields()[4], value);
      this.userUUID = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'userUUID' field has been set.
      * @return True if the 'userUUID' field has been set, false otherwise.
      */
    public boolean hasUserUUID() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'userUUID' field.
      * @return This builder.
      */
    public az.rock.lib.kafka.model.ConsumerGatewayRequest.Builder clearUserUUID() {
      userUUID = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ConsumerGatewayRequest build() {
      try {
        ConsumerGatewayRequest record = new ConsumerGatewayRequest();
        record.uuid = fieldSetFlags()[0] ? this.uuid : (java.lang.String) defaultValue(fields()[0]);
        record.time = fieldSetFlags()[1] ? this.time : (java.lang.String) defaultValue(fields()[1]);
        record.ipAddress = fieldSetFlags()[2] ? this.ipAddress : (java.lang.String) defaultValue(fields()[2]);
        record.userPrivateKey = fieldSetFlags()[3] ? this.userPrivateKey : (java.lang.String) defaultValue(fields()[3]);
        record.userUUID = fieldSetFlags()[4] ? this.userUUID : (java.lang.String) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<ConsumerGatewayRequest>
    WRITER$ = (org.apache.avro.io.DatumWriter<ConsumerGatewayRequest>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<ConsumerGatewayRequest>
    READER$ = (org.apache.avro.io.DatumReader<ConsumerGatewayRequest>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










