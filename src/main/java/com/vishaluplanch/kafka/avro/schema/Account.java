/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.vishaluplanch.kafka.avro.schema;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Account extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 5807218818855161191L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Account\",\"namespace\":\"com.vishaluplanch.kafka.avro.schema\",\"fields\":[{\"name\":\"id\",\"type\":\"long\",\"default\":-1},{\"name\":\"name\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"accountStatus\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"balance\",\"type\":\"int\",\"default\":0}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Account> ENCODER =
      new BinaryMessageEncoder<Account>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Account> DECODER =
      new BinaryMessageDecoder<Account>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Account> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Account> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Account>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Account to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Account from a ByteBuffer. */
  public static Account fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public long id;
  @Deprecated public java.lang.CharSequence name;
  @Deprecated public java.lang.CharSequence accountStatus;
  @Deprecated public int balance;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Account() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param name The new value for name
   * @param accountStatus The new value for accountStatus
   * @param balance The new value for balance
   */
  public Account(java.lang.Long id, java.lang.CharSequence name, java.lang.CharSequence accountStatus, java.lang.Integer balance) {
    this.id = id;
    this.name = name;
    this.accountStatus = accountStatus;
    this.balance = balance;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return name;
    case 2: return accountStatus;
    case 3: return balance;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.Long)value$; break;
    case 1: name = (java.lang.CharSequence)value$; break;
    case 2: accountStatus = (java.lang.CharSequence)value$; break;
    case 3: balance = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.Long getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.Long value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.CharSequence getName() {
    return name;
  }

  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'accountStatus' field.
   * @return The value of the 'accountStatus' field.
   */
  public java.lang.CharSequence getAccountStatus() {
    return accountStatus;
  }

  /**
   * Sets the value of the 'accountStatus' field.
   * @param value the value to set.
   */
  public void setAccountStatus(java.lang.CharSequence value) {
    this.accountStatus = value;
  }

  /**
   * Gets the value of the 'balance' field.
   * @return The value of the 'balance' field.
   */
  public java.lang.Integer getBalance() {
    return balance;
  }

  /**
   * Sets the value of the 'balance' field.
   * @param value the value to set.
   */
  public void setBalance(java.lang.Integer value) {
    this.balance = value;
  }

  /**
   * Creates a new Account RecordBuilder.
   * @return A new Account RecordBuilder
   */
  public static com.vishaluplanch.kafka.avro.schema.Account.Builder newBuilder() {
    return new com.vishaluplanch.kafka.avro.schema.Account.Builder();
  }

  /**
   * Creates a new Account RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Account RecordBuilder
   */
  public static com.vishaluplanch.kafka.avro.schema.Account.Builder newBuilder(com.vishaluplanch.kafka.avro.schema.Account.Builder other) {
    return new com.vishaluplanch.kafka.avro.schema.Account.Builder(other);
  }

  /**
   * Creates a new Account RecordBuilder by copying an existing Account instance.
   * @param other The existing instance to copy.
   * @return A new Account RecordBuilder
   */
  public static com.vishaluplanch.kafka.avro.schema.Account.Builder newBuilder(com.vishaluplanch.kafka.avro.schema.Account other) {
    return new com.vishaluplanch.kafka.avro.schema.Account.Builder(other);
  }

  /**
   * RecordBuilder for Account instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Account>
    implements org.apache.avro.data.RecordBuilder<Account> {

    private long id;
    private java.lang.CharSequence name;
    private java.lang.CharSequence accountStatus;
    private int balance;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.vishaluplanch.kafka.avro.schema.Account.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.accountStatus)) {
        this.accountStatus = data().deepCopy(fields()[2].schema(), other.accountStatus);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.balance)) {
        this.balance = data().deepCopy(fields()[3].schema(), other.balance);
        fieldSetFlags()[3] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Account instance
     * @param other The existing instance to copy.
     */
    private Builder(com.vishaluplanch.kafka.avro.schema.Account other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.accountStatus)) {
        this.accountStatus = data().deepCopy(fields()[2].schema(), other.accountStatus);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.balance)) {
        this.balance = data().deepCopy(fields()[3].schema(), other.balance);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.Long getId() {
      return id;
    }

    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.vishaluplanch.kafka.avro.schema.Account.Builder setId(long value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.vishaluplanch.kafka.avro.schema.Account.Builder clearId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.CharSequence getName() {
      return name;
    }

    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public com.vishaluplanch.kafka.avro.schema.Account.Builder setName(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.name = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public com.vishaluplanch.kafka.avro.schema.Account.Builder clearName() {
      name = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'accountStatus' field.
      * @return The value.
      */
    public java.lang.CharSequence getAccountStatus() {
      return accountStatus;
    }

    /**
      * Sets the value of the 'accountStatus' field.
      * @param value The value of 'accountStatus'.
      * @return This builder.
      */
    public com.vishaluplanch.kafka.avro.schema.Account.Builder setAccountStatus(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.accountStatus = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'accountStatus' field has been set.
      * @return True if the 'accountStatus' field has been set, false otherwise.
      */
    public boolean hasAccountStatus() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'accountStatus' field.
      * @return This builder.
      */
    public com.vishaluplanch.kafka.avro.schema.Account.Builder clearAccountStatus() {
      accountStatus = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'balance' field.
      * @return The value.
      */
    public java.lang.Integer getBalance() {
      return balance;
    }

    /**
      * Sets the value of the 'balance' field.
      * @param value The value of 'balance'.
      * @return This builder.
      */
    public com.vishaluplanch.kafka.avro.schema.Account.Builder setBalance(int value) {
      validate(fields()[3], value);
      this.balance = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'balance' field has been set.
      * @return True if the 'balance' field has been set, false otherwise.
      */
    public boolean hasBalance() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'balance' field.
      * @return This builder.
      */
    public com.vishaluplanch.kafka.avro.schema.Account.Builder clearBalance() {
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Account build() {
      try {
        Account record = new Account();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.Long) defaultValue(fields()[0]);
        record.name = fieldSetFlags()[1] ? this.name : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.accountStatus = fieldSetFlags()[2] ? this.accountStatus : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.balance = fieldSetFlags()[3] ? this.balance : (java.lang.Integer) defaultValue(fields()[3]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Account>
    WRITER$ = (org.apache.avro.io.DatumWriter<Account>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Account>
    READER$ = (org.apache.avro.io.DatumReader<Account>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
