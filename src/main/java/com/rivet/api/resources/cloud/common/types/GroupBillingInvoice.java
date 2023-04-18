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
    builder = GroupBillingInvoice.Builder.class
)
public final class GroupBillingInvoice {
  private final String csvUrl;

  private final String pdfUrl;

  private final String periodStartTs;

  private final String periodEndTs;

  private int _cachedHashCode;

  GroupBillingInvoice(String csvUrl, String pdfUrl, String periodStartTs, String periodEndTs) {
    this.csvUrl = csvUrl;
    this.pdfUrl = pdfUrl;
    this.periodStartTs = periodStartTs;
    this.periodEndTs = periodEndTs;
  }

  /**
   * @return A URL to this invoice's CSV breakdown.
   */
  @JsonProperty("csv_url")
  public String getCsvUrl() {
    return csvUrl;
  }

  /**
   * @return A URL to this invoice's PDF document.
   */
  @JsonProperty("pdf_url")
  public String getPdfUrl() {
    return pdfUrl;
  }

  /**
   * @return RFC3339 timestamp.
   */
  @JsonProperty("period_start_ts")
  public String getPeriodStartTs() {
    return periodStartTs;
  }

  /**
   * @return RFC3339 timestamp.
   */
  @JsonProperty("period_end_ts")
  public String getPeriodEndTs() {
    return periodEndTs;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GroupBillingInvoice && equalTo((GroupBillingInvoice) other);
  }

  private boolean equalTo(GroupBillingInvoice other) {
    return csvUrl.equals(other.csvUrl) && pdfUrl.equals(other.pdfUrl) && periodStartTs.equals(other.periodStartTs) && periodEndTs.equals(other.periodEndTs);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.csvUrl, this.pdfUrl, this.periodStartTs, this.periodEndTs);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GroupBillingInvoice{" + "csvUrl: " + csvUrl + ", pdfUrl: " + pdfUrl + ", periodStartTs: " + periodStartTs + ", periodEndTs: " + periodEndTs + "}";
  }

  public static CsvUrlStage builder() {
    return new Builder();
  }

  public interface CsvUrlStage {
    PdfUrlStage csvUrl(String csvUrl);

    Builder from(GroupBillingInvoice other);
  }

  public interface PdfUrlStage {
    PeriodStartTsStage pdfUrl(String pdfUrl);
  }

  public interface PeriodStartTsStage {
    PeriodEndTsStage periodStartTs(String periodStartTs);
  }

  public interface PeriodEndTsStage {
    _FinalStage periodEndTs(String periodEndTs);
  }

  public interface _FinalStage {
    GroupBillingInvoice build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements CsvUrlStage, PdfUrlStage, PeriodStartTsStage, PeriodEndTsStage, _FinalStage {
    private String csvUrl;

    private String pdfUrl;

    private String periodStartTs;

    private String periodEndTs;

    private Builder() {
    }

    @Override
    public Builder from(GroupBillingInvoice other) {
      csvUrl(other.getCsvUrl());
      pdfUrl(other.getPdfUrl());
      periodStartTs(other.getPeriodStartTs());
      periodEndTs(other.getPeriodEndTs());
      return this;
    }

    /**
     * <p>A URL to this invoice's CSV breakdown.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("csv_url")
    public PdfUrlStage csvUrl(String csvUrl) {
      this.csvUrl = csvUrl;
      return this;
    }

    /**
     * <p>A URL to this invoice's PDF document.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("pdf_url")
    public PeriodStartTsStage pdfUrl(String pdfUrl) {
      this.pdfUrl = pdfUrl;
      return this;
    }

    /**
     * <p>RFC3339 timestamp.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("period_start_ts")
    public PeriodEndTsStage periodStartTs(String periodStartTs) {
      this.periodStartTs = periodStartTs;
      return this;
    }

    /**
     * <p>RFC3339 timestamp.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("period_end_ts")
    public _FinalStage periodEndTs(String periodEndTs) {
      this.periodEndTs = periodEndTs;
      return this;
    }

    @Override
    public GroupBillingInvoice build() {
      return new GroupBillingInvoice(csvUrl, pdfUrl, periodStartTs, periodEndTs);
    }
  }
}
