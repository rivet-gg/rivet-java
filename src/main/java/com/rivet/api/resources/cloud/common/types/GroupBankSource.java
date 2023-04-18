package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = GroupBankSource.Builder.class
)
public final class GroupBankSource {
  private final String accountNumber;

  private final String routingNumber;

  private int _cachedHashCode;

  GroupBankSource(String accountNumber, String routingNumber) {
    this.accountNumber = accountNumber;
    this.routingNumber = routingNumber;
  }

  /**
   * @return The bank account number of this group's bank source.
   */
  @JsonProperty("account_number")
  public String getAccountNumber() {
    return accountNumber;
  }

  /**
   * @return The bank routing number of this group's bank source.
   */
  @JsonProperty("routing_number")
  public String getRoutingNumber() {
    return routingNumber;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GroupBankSource && equalTo((GroupBankSource) other);
  }

  private boolean equalTo(GroupBankSource other) {
    return accountNumber.equals(other.accountNumber) && routingNumber.equals(other.routingNumber);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.accountNumber, this.routingNumber);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GroupBankSource{" + "accountNumber: " + accountNumber + ", routingNumber: " + routingNumber + "}";
  }

  public static AccountNumberStage builder() {
    return new Builder();
  }

  public interface AccountNumberStage {
    RoutingNumberStage accountNumber(String accountNumber);

    Builder from(GroupBankSource other);
  }

  public interface RoutingNumberStage {
    _FinalStage routingNumber(String routingNumber);
  }

  public interface _FinalStage {
    GroupBankSource build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements AccountNumberStage, RoutingNumberStage, _FinalStage {
    private String accountNumber;

    private String routingNumber;

    private Builder() {
    }

    @Override
    public Builder from(GroupBankSource other) {
      accountNumber(other.getAccountNumber());
      routingNumber(other.getRoutingNumber());
      return this;
    }

    /**
     * <p>The bank account number of this group's bank source.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("account_number")
    public RoutingNumberStage accountNumber(String accountNumber) {
      this.accountNumber = accountNumber;
      return this;
    }

    /**
     * <p>The bank routing number of this group's bank source.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("routing_number")
    public _FinalStage routingNumber(String routingNumber) {
      this.routingNumber = routingNumber;
      return this;
    }

    @Override
    public GroupBankSource build() {
      return new GroupBankSource(accountNumber, routingNumber);
    }
  }
}
