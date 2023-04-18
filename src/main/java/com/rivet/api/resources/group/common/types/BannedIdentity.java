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
    builder = BannedIdentity.Builder.class
)
public final class BannedIdentity {
  private final Handle identity;

  private final String banTs;

  private int _cachedHashCode;

  BannedIdentity(Handle identity, String banTs) {
    this.identity = identity;
    this.banTs = banTs;
  }

  @JsonProperty("identity")
  public Handle getIdentity() {
    return identity;
  }

  /**
   * @return RFC3339 timestamp.
   */
  @JsonProperty("ban_ts")
  public String getBanTs() {
    return banTs;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof BannedIdentity && equalTo((BannedIdentity) other);
  }

  private boolean equalTo(BannedIdentity other) {
    return identity.equals(other.identity) && banTs.equals(other.banTs);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.identity, this.banTs);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "BannedIdentity{" + "identity: " + identity + ", banTs: " + banTs + "}";
  }

  public static IdentityStage builder() {
    return new Builder();
  }

  public interface IdentityStage {
    BanTsStage identity(Handle identity);

    Builder from(BannedIdentity other);
  }

  public interface BanTsStage {
    _FinalStage banTs(String banTs);
  }

  public interface _FinalStage {
    BannedIdentity build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements IdentityStage, BanTsStage, _FinalStage {
    private Handle identity;

    private String banTs;

    private Builder() {
    }

    @Override
    public Builder from(BannedIdentity other) {
      identity(other.getIdentity());
      banTs(other.getBanTs());
      return this;
    }

    @Override
    @JsonSetter("identity")
    public BanTsStage identity(Handle identity) {
      this.identity = identity;
      return this;
    }

    /**
     * <p>RFC3339 timestamp.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("ban_ts")
    public _FinalStage banTs(String banTs) {
      this.banTs = banTs;
      return this;
    }

    @Override
    public BannedIdentity build() {
      return new BannedIdentity(identity, banTs);
    }
  }
}
