package com.rivet.api.resources.group.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.identity.common.types.Handle;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = JoinRequest.Builder.class
)
public final class JoinRequest {
  private final Handle identity;

  private final String ts;

  private int _cachedHashCode;

  JoinRequest(Handle identity, String ts) {
    this.identity = identity;
    this.ts = ts;
  }

  @JsonProperty("identity")
  public Handle getIdentity() {
    return identity;
  }

  /**
   * @return RFC3339 timestamp.
   */
  @JsonProperty("ts")
  public String getTs() {
    return ts;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof JoinRequest && equalTo((JoinRequest) other);
  }

  private boolean equalTo(JoinRequest other) {
    return identity.equals(other.identity) && ts.equals(other.ts);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.identity, this.ts);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "JoinRequest{" + "identity: " + identity + ", ts: " + ts + "}";
  }

  public static IdentityStage builder() {
    return new Builder();
  }

  public interface IdentityStage {
    TsStage identity(Handle identity);

    Builder from(JoinRequest other);
  }

  public interface TsStage {
    _FinalStage ts(String ts);
  }

  public interface _FinalStage {
    JoinRequest build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements IdentityStage, TsStage, _FinalStage {
    private Handle identity;

    private String ts;

    private Builder() {
    }

    @Override
    public Builder from(JoinRequest other) {
      identity(other.getIdentity());
      ts(other.getTs());
      return this;
    }

    @Override
    @JsonSetter("identity")
    public TsStage identity(Handle identity) {
      this.identity = identity;
      return this;
    }

    /**
     * <p>RFC3339 timestamp.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("ts")
    public _FinalStage ts(String ts) {
      this.ts = ts;
      return this;
    }

    @Override
    public JoinRequest build() {
      return new JoinRequest(identity, ts);
    }
  }
}
