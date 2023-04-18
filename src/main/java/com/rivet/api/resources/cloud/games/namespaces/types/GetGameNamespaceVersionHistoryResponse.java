package com.rivet.api.resources.cloud.games.namespaces.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.cloud.common.types.NamespaceVersion;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = GetGameNamespaceVersionHistoryResponse.Builder.class
)
public final class GetGameNamespaceVersionHistoryResponse {
  private final List<NamespaceVersion> versions;

  private int _cachedHashCode;

  GetGameNamespaceVersionHistoryResponse(List<NamespaceVersion> versions) {
    this.versions = versions;
  }

  /**
   * @return A list of previously deployed namespace versions.
   */
  @JsonProperty("versions")
  public List<NamespaceVersion> getVersions() {
    return versions;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetGameNamespaceVersionHistoryResponse && equalTo((GetGameNamespaceVersionHistoryResponse) other);
  }

  private boolean equalTo(GetGameNamespaceVersionHistoryResponse other) {
    return versions.equals(other.versions);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.versions);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetGameNamespaceVersionHistoryResponse{" + "versions: " + versions + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<NamespaceVersion> versions = new ArrayList<>();

    private Builder() {
    }

    public Builder from(GetGameNamespaceVersionHistoryResponse other) {
      versions(other.getVersions());
      return this;
    }

    @JsonSetter(
        value = "versions",
        nulls = Nulls.SKIP
    )
    public Builder versions(List<NamespaceVersion> versions) {
      this.versions.clear();
      this.versions.addAll(versions);
      return this;
    }

    public Builder addVersions(NamespaceVersion versions) {
      this.versions.add(versions);
      return this;
    }

    public Builder addAllVersions(List<NamespaceVersion> versions) {
      this.versions.addAll(versions);
      return this;
    }

    public GetGameNamespaceVersionHistoryResponse build() {
      return new GetGameNamespaceVersionHistoryResponse(versions);
    }
  }
}
