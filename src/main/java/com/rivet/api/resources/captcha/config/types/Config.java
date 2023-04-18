package com.rivet.api.resources.captcha.config.types;

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
  private final Optional<ConfigHcaptcha> hcaptcha;

  private final Optional<ConfigTurnstile> turnstile;

  private int _cachedHashCode;

  Config(Optional<ConfigHcaptcha> hcaptcha, Optional<ConfigTurnstile> turnstile) {
    this.hcaptcha = hcaptcha;
    this.turnstile = turnstile;
  }

  @JsonProperty("hcaptcha")
  public Optional<ConfigHcaptcha> getHcaptcha() {
    return hcaptcha;
  }

  @JsonProperty("turnstile")
  public Optional<ConfigTurnstile> getTurnstile() {
    return turnstile;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Config && equalTo((Config) other);
  }

  private boolean equalTo(Config other) {
    return hcaptcha.equals(other.hcaptcha) && turnstile.equals(other.turnstile);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.hcaptcha, this.turnstile);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Config{" + "hcaptcha: " + hcaptcha + ", turnstile: " + turnstile + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<ConfigHcaptcha> hcaptcha = Optional.empty();

    private Optional<ConfigTurnstile> turnstile = Optional.empty();

    private Builder() {
    }

    public Builder from(Config other) {
      hcaptcha(other.getHcaptcha());
      turnstile(other.getTurnstile());
      return this;
    }

    @JsonSetter(
        value = "hcaptcha",
        nulls = Nulls.SKIP
    )
    public Builder hcaptcha(Optional<ConfigHcaptcha> hcaptcha) {
      this.hcaptcha = hcaptcha;
      return this;
    }

    public Builder hcaptcha(ConfigHcaptcha hcaptcha) {
      this.hcaptcha = Optional.of(hcaptcha);
      return this;
    }

    @JsonSetter(
        value = "turnstile",
        nulls = Nulls.SKIP
    )
    public Builder turnstile(Optional<ConfigTurnstile> turnstile) {
      this.turnstile = turnstile;
      return this;
    }

    public Builder turnstile(ConfigTurnstile turnstile) {
      this.turnstile = Optional.of(turnstile);
      return this;
    }

    public Config build() {
      return new Config(hcaptcha, turnstile);
    }
  }
}
