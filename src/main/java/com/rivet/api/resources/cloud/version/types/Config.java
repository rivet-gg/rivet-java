package com.rivet.api.resources.cloud.version.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = Config.Builder.class
)
public final class Config {
  private final Optional<com.rivet.api.resources.cloud.version.cdn.types.Config> cdn;

  private final Optional<com.rivet.api.resources.cloud.version.matchmaker.types.Config> matchmaker;

  private final Optional<com.rivet.api.resources.cloud.version.kv.types.Config> kv;

  private final Optional<com.rivet.api.resources.cloud.version.identity.pacakge.types.Config> identity;

  private int _cachedHashCode;

  Config(Optional<com.rivet.api.resources.cloud.version.cdn.types.Config> cdn,
      Optional<com.rivet.api.resources.cloud.version.matchmaker.types.Config> matchmaker,
      Optional<com.rivet.api.resources.cloud.version.kv.types.Config> kv,
      Optional<com.rivet.api.resources.cloud.version.identity.pacakge.types.Config> identity) {
    this.cdn = cdn;
    this.matchmaker = matchmaker;
    this.kv = kv;
    this.identity = identity;
  }

  @JsonProperty("cdn")
  public Optional<com.rivet.api.resources.cloud.version.cdn.types.Config> getCdn() {
    return cdn;
  }

  @JsonProperty("matchmaker")
  public Optional<com.rivet.api.resources.cloud.version.matchmaker.types.Config> getMatchmaker() {
    return matchmaker;
  }

  @JsonProperty("kv")
  public Optional<com.rivet.api.resources.cloud.version.kv.types.Config> getKv() {
    return kv;
  }

  @JsonProperty("identity")
  public Optional<com.rivet.api.resources.cloud.version.identity.pacakge.types.Config> getIdentity(
      ) {
    return identity;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Config && equalTo((Config) other);
  }

  private boolean equalTo(Config other) {
    return cdn.equals(other.cdn) && matchmaker.equals(other.matchmaker) && kv.equals(other.kv) && identity.equals(other.identity);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.cdn, this.matchmaker, this.kv, this.identity);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Config{" + "cdn: " + cdn + ", matchmaker: " + matchmaker + ", kv: " + kv + ", identity: " + identity + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<com.rivet.api.resources.cloud.version.cdn.types.Config> cdn = Optional.empty();

    private Optional<com.rivet.api.resources.cloud.version.matchmaker.types.Config> matchmaker = Optional.empty();

    private Optional<com.rivet.api.resources.cloud.version.kv.types.Config> kv = Optional.empty();

    private Optional<com.rivet.api.resources.cloud.version.identity.pacakge.types.Config> identity = Optional.empty();

    private Builder() {
    }

    public Builder from(Config other) {
      cdn(other.getCdn());
      matchmaker(other.getMatchmaker());
      kv(other.getKv());
      identity(other.getIdentity());
      return this;
    }

    @JsonSetter(
        value = "cdn",
        nulls = Nulls.SKIP
    )
    public Builder cdn(Optional<com.rivet.api.resources.cloud.version.cdn.types.Config> cdn) {
      this.cdn = cdn;
      return this;
    }

    public Builder cdn(com.rivet.api.resources.cloud.version.cdn.types.Config cdn) {
      this.cdn = Optional.of(cdn);
      return this;
    }

    @JsonSetter(
        value = "matchmaker",
        nulls = Nulls.SKIP
    )
    public Builder matchmaker(
        Optional<com.rivet.api.resources.cloud.version.matchmaker.types.Config> matchmaker) {
      this.matchmaker = matchmaker;
      return this;
    }

    public Builder matchmaker(
        com.rivet.api.resources.cloud.version.matchmaker.types.Config matchmaker) {
      this.matchmaker = Optional.of(matchmaker);
      return this;
    }

    @JsonSetter(
        value = "kv",
        nulls = Nulls.SKIP
    )
    public Builder kv(Optional<com.rivet.api.resources.cloud.version.kv.types.Config> kv) {
      this.kv = kv;
      return this;
    }

    public Builder kv(com.rivet.api.resources.cloud.version.kv.types.Config kv) {
      this.kv = Optional.of(kv);
      return this;
    }

    @JsonSetter(
        value = "identity",
        nulls = Nulls.SKIP
    )
    public Builder identity(
        Optional<com.rivet.api.resources.cloud.version.identity.pacakge.types.Config> identity) {
      this.identity = identity;
      return this;
    }

    public Builder identity(
        com.rivet.api.resources.cloud.version.identity.pacakge.types.Config identity) {
      this.identity = Optional.of(identity);
      return this;
    }

    public Config build() {
      return new Config(cdn, matchmaker, kv, identity);
    }
  }
}
