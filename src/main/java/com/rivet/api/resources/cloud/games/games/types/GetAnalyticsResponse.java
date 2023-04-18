package com.rivet.api.resources.cloud.games.games.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.cloud.common.types.NamespaceAnalyticsDataSet;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = GetAnalyticsResponse.Builder.class
)
public final class GetAnalyticsResponse {
  private final List<NamespaceAnalyticsDataSet> dataSets;

  private int _cachedHashCode;

  GetAnalyticsResponse(List<NamespaceAnalyticsDataSet> dataSets) {
    this.dataSets = dataSets;
  }

  @JsonProperty("data_sets")
  public List<NamespaceAnalyticsDataSet> getDataSets() {
    return dataSets;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetAnalyticsResponse && equalTo((GetAnalyticsResponse) other);
  }

  private boolean equalTo(GetAnalyticsResponse other) {
    return dataSets.equals(other.dataSets);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.dataSets);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetAnalyticsResponse{" + "dataSets: " + dataSets + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<NamespaceAnalyticsDataSet> dataSets = new ArrayList<>();

    private Builder() {
    }

    public Builder from(GetAnalyticsResponse other) {
      dataSets(other.getDataSets());
      return this;
    }

    @JsonSetter(
        value = "data_sets",
        nulls = Nulls.SKIP
    )
    public Builder dataSets(List<NamespaceAnalyticsDataSet> dataSets) {
      this.dataSets.clear();
      this.dataSets.addAll(dataSets);
      return this;
    }

    public Builder addDataSets(NamespaceAnalyticsDataSet dataSets) {
      this.dataSets.add(dataSets);
      return this;
    }

    public Builder addAllDataSets(List<NamespaceAnalyticsDataSet> dataSets) {
      this.dataSets.addAll(dataSets);
      return this;
    }

    public GetAnalyticsResponse build() {
      return new GetAnalyticsResponse(dataSets);
    }
  }
}
