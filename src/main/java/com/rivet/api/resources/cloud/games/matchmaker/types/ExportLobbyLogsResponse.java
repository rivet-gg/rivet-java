package com.rivet.api.resources.cloud.games.matchmaker.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = ExportLobbyLogsResponse.Builder.class
)
public final class ExportLobbyLogsResponse {
  private final String url;

  private int _cachedHashCode;

  ExportLobbyLogsResponse(String url) {
    this.url = url;
  }

  /**
   * @return The URL to a CSV file for the given lobby history.
   */
  @JsonProperty("url")
  public String getUrl() {
    return url;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ExportLobbyLogsResponse && equalTo((ExportLobbyLogsResponse) other);
  }

  private boolean equalTo(ExportLobbyLogsResponse other) {
    return url.equals(other.url);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.url);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ExportLobbyLogsResponse{" + "url: " + url + "}";
  }

  public static UrlStage builder() {
    return new Builder();
  }

  public interface UrlStage {
    _FinalStage url(String url);

    Builder from(ExportLobbyLogsResponse other);
  }

  public interface _FinalStage {
    ExportLobbyLogsResponse build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements UrlStage, _FinalStage {
    private String url;

    private Builder() {
    }

    @Override
    public Builder from(ExportLobbyLogsResponse other) {
      url(other.getUrl());
      return this;
    }

    /**
     * <p>The URL to a CSV file for the given lobby history.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("url")
    public _FinalStage url(String url) {
      this.url = url;
      return this;
    }

    @Override
    public ExportLobbyLogsResponse build() {
      return new ExportLobbyLogsResponse(url);
    }
  }
}
