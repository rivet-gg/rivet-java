package com.rivet.api.resources.cloud.version.matchmaker.common.types;

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
    builder = Captcha.Builder.class
)
public final class Captcha {
  private final int requestsBeforeReverify;

  private final long verificationTtl;

  private final Optional<CaptchaHcaptcha> hcaptcha;

  private int _cachedHashCode;

  Captcha(int requestsBeforeReverify, long verificationTtl, Optional<CaptchaHcaptcha> hcaptcha) {
    this.requestsBeforeReverify = requestsBeforeReverify;
    this.verificationTtl = verificationTtl;
    this.hcaptcha = hcaptcha;
  }

  /**
   * @return Denotes how many requests a connection can make before it is required to reverify a captcha.
   */
  @JsonProperty("requests_before_reverify")
  public int getRequestsBeforeReverify() {
    return requestsBeforeReverify;
  }

  /**
   * @return Denotes how long a connection can continue to reconnect without having to reverify a captcha (in milliseconds).
   */
  @JsonProperty("verification_ttl")
  public long getVerificationTtl() {
    return verificationTtl;
  }

  @JsonProperty("hcaptcha")
  public Optional<CaptchaHcaptcha> getHcaptcha() {
    return hcaptcha;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Captcha && equalTo((Captcha) other);
  }

  private boolean equalTo(Captcha other) {
    return requestsBeforeReverify == other.requestsBeforeReverify && verificationTtl == other.verificationTtl && hcaptcha.equals(other.hcaptcha);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.requestsBeforeReverify, this.verificationTtl, this.hcaptcha);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Captcha{" + "requestsBeforeReverify: " + requestsBeforeReverify + ", verificationTtl: " + verificationTtl + ", hcaptcha: " + hcaptcha + "}";
  }

  public static RequestsBeforeReverifyStage builder() {
    return new Builder();
  }

  public interface RequestsBeforeReverifyStage {
    VerificationTtlStage requestsBeforeReverify(int requestsBeforeReverify);

    Builder from(Captcha other);
  }

  public interface VerificationTtlStage {
    _FinalStage verificationTtl(long verificationTtl);
  }

  public interface _FinalStage {
    Captcha build();

    _FinalStage hcaptcha(Optional<CaptchaHcaptcha> hcaptcha);

    _FinalStage hcaptcha(CaptchaHcaptcha hcaptcha);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements RequestsBeforeReverifyStage, VerificationTtlStage, _FinalStage {
    private int requestsBeforeReverify;

    private long verificationTtl;

    private Optional<CaptchaHcaptcha> hcaptcha = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(Captcha other) {
      requestsBeforeReverify(other.getRequestsBeforeReverify());
      verificationTtl(other.getVerificationTtl());
      hcaptcha(other.getHcaptcha());
      return this;
    }

    /**
     * <p>Denotes how many requests a connection can make before it is required to reverify a captcha.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("requests_before_reverify")
    public VerificationTtlStage requestsBeforeReverify(int requestsBeforeReverify) {
      this.requestsBeforeReverify = requestsBeforeReverify;
      return this;
    }

    /**
     * <p>Denotes how long a connection can continue to reconnect without having to reverify a captcha (in milliseconds).</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("verification_ttl")
    public _FinalStage verificationTtl(long verificationTtl) {
      this.verificationTtl = verificationTtl;
      return this;
    }

    @Override
    public _FinalStage hcaptcha(CaptchaHcaptcha hcaptcha) {
      this.hcaptcha = Optional.of(hcaptcha);
      return this;
    }

    @Override
    @JsonSetter(
        value = "hcaptcha",
        nulls = Nulls.SKIP
    )
    public _FinalStage hcaptcha(Optional<CaptchaHcaptcha> hcaptcha) {
      this.hcaptcha = hcaptcha;
      return this;
    }

    @Override
    public Captcha build() {
      return new Captcha(requestsBeforeReverify, verificationTtl, hcaptcha);
    }
  }
}
