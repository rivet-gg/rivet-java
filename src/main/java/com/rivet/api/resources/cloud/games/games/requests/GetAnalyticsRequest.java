package com.rivet.api.resources.cloud.games.games.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.cloud.common.types.AnalyticsVariantQuery;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = GetAnalyticsRequest.Builder.class
)
public final class GetAnalyticsRequest {
  private final String queryStart;

  private final String queryEnd;

  private final Optional<String> gameIds;

  private final Optional<String> namespaceIds;

  private final AnalyticsVariantQuery variants;

  private int _cachedHashCode;

  GetAnalyticsRequest(String queryStart, String queryEnd, Optional<String> gameIds,
      Optional<String> namespaceIds, AnalyticsVariantQuery variants) {
    this.queryStart = queryStart;
    this.queryEnd = queryEnd;
    this.gameIds = gameIds;
    this.namespaceIds = namespaceIds;
    this.variants = variants;
  }

  @JsonProperty("query_start")
  public String getQueryStart() {
    return queryStart;
  }

  @JsonProperty("query_end")
  public String getQueryEnd() {
    return queryEnd;
  }

  @JsonProperty("game_ids")
  public Optional<String> getGameIds() {
    return gameIds;
  }

  @JsonProperty("namespace_ids")
  public Optional<String> getNamespaceIds() {
    return namespaceIds;
  }

  @JsonProperty("variants")
  public AnalyticsVariantQuery getVariants() {
    return variants;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetAnalyticsRequest && equalTo((GetAnalyticsRequest) other);
  }

  private boolean equalTo(GetAnalyticsRequest other) {
    return queryStart.equals(other.queryStart) && queryEnd.equals(other.queryEnd) && gameIds.equals(other.gameIds) && namespaceIds.equals(other.namespaceIds) && variants.equals(other.variants);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.queryStart, this.queryEnd, this.gameIds, this.namespaceIds, this.variants);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetAnalyticsRequest{" + "queryStart: " + queryStart + ", queryEnd: " + queryEnd + ", gameIds: " + gameIds + ", namespaceIds: " + namespaceIds + ", variants: " + variants + "}";
  }

  public static QueryStartStage builder() {
    return new Builder();
  }

  public interface QueryStartStage {
    QueryEndStage queryStart(String queryStart);

    Builder from(GetAnalyticsRequest other);
  }

  public interface QueryEndStage {
    VariantsStage queryEnd(String queryEnd);
  }

  public interface VariantsStage {
    _FinalStage variants(AnalyticsVariantQuery variants);
  }

  public interface _FinalStage {
    GetAnalyticsRequest build();

    _FinalStage gameIds(Optional<String> gameIds);

    _FinalStage gameIds(String gameIds);

    _FinalStage namespaceIds(Optional<String> namespaceIds);

    _FinalStage namespaceIds(String namespaceIds);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements QueryStartStage, QueryEndStage, VariantsStage, _FinalStage {
    private String queryStart;

    private String queryEnd;

    private AnalyticsVariantQuery variants;

    private Optional<String> namespaceIds = Optional.empty();

    private Optional<String> gameIds = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(GetAnalyticsRequest other) {
      queryStart(other.getQueryStart());
      queryEnd(other.getQueryEnd());
      gameIds(other.getGameIds());
      namespaceIds(other.getNamespaceIds());
      variants(other.getVariants());
      return this;
    }

    @Override
    @JsonSetter("query_start")
    public QueryEndStage queryStart(String queryStart) {
      this.queryStart = queryStart;
      return this;
    }

    @Override
    @JsonSetter("query_end")
    public VariantsStage queryEnd(String queryEnd) {
      this.queryEnd = queryEnd;
      return this;
    }

    @Override
    @JsonSetter("variants")
    public _FinalStage variants(AnalyticsVariantQuery variants) {
      this.variants = variants;
      return this;
    }

    @Override
    public _FinalStage namespaceIds(String namespaceIds) {
      this.namespaceIds = Optional.of(namespaceIds);
      return this;
    }

    @Override
    @JsonSetter(
        value = "namespace_ids",
        nulls = Nulls.SKIP
    )
    public _FinalStage namespaceIds(Optional<String> namespaceIds) {
      this.namespaceIds = namespaceIds;
      return this;
    }

    @Override
    public _FinalStage gameIds(String gameIds) {
      this.gameIds = Optional.of(gameIds);
      return this;
    }

    @Override
    @JsonSetter(
        value = "game_ids",
        nulls = Nulls.SKIP
    )
    public _FinalStage gameIds(Optional<String> gameIds) {
      this.gameIds = gameIds;
      return this;
    }

    @Override
    public GetAnalyticsRequest build() {
      return new GetAnalyticsRequest(queryStart, queryEnd, gameIds, namespaceIds, variants);
    }
  }
}
