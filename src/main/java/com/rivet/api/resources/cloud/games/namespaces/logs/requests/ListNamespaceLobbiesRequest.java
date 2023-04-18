package com.rivet.api.resources.cloud.games.namespaces.logs.requests;

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
    builder = ListNamespaceLobbiesRequest.Builder.class
)
public final class ListNamespaceLobbiesRequest {
  private final Optional<String> beforeCreateTs;

  private int _cachedHashCode;

  ListNamespaceLobbiesRequest(Optional<String> beforeCreateTs) {
    this.beforeCreateTs = beforeCreateTs;
  }

  /**
   * @return <p>lobbies created before this timestamp.</p>
   */
  @JsonProperty("before_create_ts")
  public Optional<String> getBeforeCreateTs() {
    return beforeCreateTs;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ListNamespaceLobbiesRequest && equalTo((ListNamespaceLobbiesRequest) other);
  }

  private boolean equalTo(ListNamespaceLobbiesRequest other) {
    return beforeCreateTs.equals(other.beforeCreateTs);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.beforeCreateTs);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ListNamespaceLobbiesRequest{" + "beforeCreateTs: " + beforeCreateTs + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> beforeCreateTs = Optional.empty();

    private Builder() {
    }

    public Builder from(ListNamespaceLobbiesRequest other) {
      beforeCreateTs(other.getBeforeCreateTs());
      return this;
    }

    @JsonSetter(
        value = "before_create_ts",
        nulls = Nulls.SKIP
    )
    public Builder beforeCreateTs(Optional<String> beforeCreateTs) {
      this.beforeCreateTs = beforeCreateTs;
      return this;
    }

    public Builder beforeCreateTs(String beforeCreateTs) {
      this.beforeCreateTs = Optional.of(beforeCreateTs);
      return this;
    }

    public ListNamespaceLobbiesRequest build() {
      return new ListNamespaceLobbiesRequest(beforeCreateTs);
    }
  }
}
