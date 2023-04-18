package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = CdnNamespaceDomain.Builder.class
)
public final class CdnNamespaceDomain {
  private final String domain;

  private final String createTs;

  private final CdnNamespaceDomainVerificationStatus verificationStatus;

  private final CdnNamespaceDomainVerificationMethod verificationMethod;

  private final List<String> verificationErrors;

  private int _cachedHashCode;

  CdnNamespaceDomain(String domain, String createTs,
      CdnNamespaceDomainVerificationStatus verificationStatus,
      CdnNamespaceDomainVerificationMethod verificationMethod, List<String> verificationErrors) {
    this.domain = domain;
    this.createTs = createTs;
    this.verificationStatus = verificationStatus;
    this.verificationMethod = verificationMethod;
    this.verificationErrors = verificationErrors;
  }

  /**
   * @return A valid domain name (no protocol).
   */
  @JsonProperty("domain")
  public String getDomain() {
    return domain;
  }

  /**
   * @return RFC3339 timestamp.
   */
  @JsonProperty("create_ts")
  public String getCreateTs() {
    return createTs;
  }

  @JsonProperty("verification_status")
  public CdnNamespaceDomainVerificationStatus getVerificationStatus() {
    return verificationStatus;
  }

  @JsonProperty("verification_method")
  public CdnNamespaceDomainVerificationMethod getVerificationMethod() {
    return verificationMethod;
  }

  @JsonProperty("verification_errors")
  public List<String> getVerificationErrors() {
    return verificationErrors;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CdnNamespaceDomain && equalTo((CdnNamespaceDomain) other);
  }

  private boolean equalTo(CdnNamespaceDomain other) {
    return domain.equals(other.domain) && createTs.equals(other.createTs) && verificationStatus.equals(other.verificationStatus) && verificationMethod.equals(other.verificationMethod) && verificationErrors.equals(other.verificationErrors);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.domain, this.createTs, this.verificationStatus, this.verificationMethod, this.verificationErrors);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "CdnNamespaceDomain{" + "domain: " + domain + ", createTs: " + createTs + ", verificationStatus: " + verificationStatus + ", verificationMethod: " + verificationMethod + ", verificationErrors: " + verificationErrors + "}";
  }

  public static DomainStage builder() {
    return new Builder();
  }

  public interface DomainStage {
    CreateTsStage domain(String domain);

    Builder from(CdnNamespaceDomain other);
  }

  public interface CreateTsStage {
    VerificationStatusStage createTs(String createTs);
  }

  public interface VerificationStatusStage {
    VerificationMethodStage verificationStatus(
        CdnNamespaceDomainVerificationStatus verificationStatus);
  }

  public interface VerificationMethodStage {
    _FinalStage verificationMethod(CdnNamespaceDomainVerificationMethod verificationMethod);
  }

  public interface _FinalStage {
    CdnNamespaceDomain build();

    _FinalStage verificationErrors(List<String> verificationErrors);

    _FinalStage addVerificationErrors(String verificationErrors);

    _FinalStage addAllVerificationErrors(List<String> verificationErrors);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements DomainStage, CreateTsStage, VerificationStatusStage, VerificationMethodStage, _FinalStage {
    private String domain;

    private String createTs;

    private CdnNamespaceDomainVerificationStatus verificationStatus;

    private CdnNamespaceDomainVerificationMethod verificationMethod;

    private List<String> verificationErrors = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(CdnNamespaceDomain other) {
      domain(other.getDomain());
      createTs(other.getCreateTs());
      verificationStatus(other.getVerificationStatus());
      verificationMethod(other.getVerificationMethod());
      verificationErrors(other.getVerificationErrors());
      return this;
    }

    /**
     * <p>A valid domain name (no protocol).</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("domain")
    public CreateTsStage domain(String domain) {
      this.domain = domain;
      return this;
    }

    /**
     * <p>RFC3339 timestamp.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("create_ts")
    public VerificationStatusStage createTs(String createTs) {
      this.createTs = createTs;
      return this;
    }

    @Override
    @JsonSetter("verification_status")
    public VerificationMethodStage verificationStatus(
        CdnNamespaceDomainVerificationStatus verificationStatus) {
      this.verificationStatus = verificationStatus;
      return this;
    }

    @Override
    @JsonSetter("verification_method")
    public _FinalStage verificationMethod(CdnNamespaceDomainVerificationMethod verificationMethod) {
      this.verificationMethod = verificationMethod;
      return this;
    }

    @Override
    public _FinalStage addAllVerificationErrors(List<String> verificationErrors) {
      this.verificationErrors.addAll(verificationErrors);
      return this;
    }

    @Override
    public _FinalStage addVerificationErrors(String verificationErrors) {
      this.verificationErrors.add(verificationErrors);
      return this;
    }

    @Override
    @JsonSetter(
        value = "verification_errors",
        nulls = Nulls.SKIP
    )
    public _FinalStage verificationErrors(List<String> verificationErrors) {
      this.verificationErrors.clear();
      this.verificationErrors.addAll(verificationErrors);
      return this;
    }

    @Override
    public CdnNamespaceDomain build() {
      return new CdnNamespaceDomain(domain, createTs, verificationStatus, verificationMethod, verificationErrors);
    }
  }
}
