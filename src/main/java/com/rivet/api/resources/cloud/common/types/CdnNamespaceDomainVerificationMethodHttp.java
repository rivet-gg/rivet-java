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
    builder = CdnNamespaceDomainVerificationMethodHttp.Builder.class
)
public final class CdnNamespaceDomainVerificationMethodHttp {
  private final String cnameRecord;

  private int _cachedHashCode;

  CdnNamespaceDomainVerificationMethodHttp(String cnameRecord) {
    this.cnameRecord = cnameRecord;
  }

  @JsonProperty("cname_record")
  public String getCnameRecord() {
    return cnameRecord;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CdnNamespaceDomainVerificationMethodHttp && equalTo((CdnNamespaceDomainVerificationMethodHttp) other);
  }

  private boolean equalTo(CdnNamespaceDomainVerificationMethodHttp other) {
    return cnameRecord.equals(other.cnameRecord);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.cnameRecord);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "CdnNamespaceDomainVerificationMethodHttp{" + "cnameRecord: " + cnameRecord + "}";
  }

  public static CnameRecordStage builder() {
    return new Builder();
  }

  public interface CnameRecordStage {
    _FinalStage cnameRecord(String cnameRecord);

    Builder from(CdnNamespaceDomainVerificationMethodHttp other);
  }

  public interface _FinalStage {
    CdnNamespaceDomainVerificationMethodHttp build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements CnameRecordStage, _FinalStage {
    private String cnameRecord;

    private Builder() {
    }

    @Override
    public Builder from(CdnNamespaceDomainVerificationMethodHttp other) {
      cnameRecord(other.getCnameRecord());
      return this;
    }

    @Override
    @JsonSetter("cname_record")
    public _FinalStage cnameRecord(String cnameRecord) {
      this.cnameRecord = cnameRecord;
      return this;
    }

    @Override
    public CdnNamespaceDomainVerificationMethodHttp build() {
      return new CdnNamespaceDomainVerificationMethodHttp(cnameRecord);
    }
  }
}
