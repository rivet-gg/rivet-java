package com.rivet.api.resources.kv.requests;

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
import java.util.UUID;

@JsonDeserialize(
    builder = GetBatchRequest.Builder.class
)
public final class GetBatchRequest {
  private final String keys;

  private final Optional<String> watchIndex;

  private final Optional<UUID> namespaceId;

  private int _cachedHashCode;

  GetBatchRequest(String keys, Optional<String> watchIndex, Optional<UUID> namespaceId) {
    this.keys = keys;
    this.watchIndex = watchIndex;
    this.namespaceId = namespaceId;
  }

  @JsonProperty("keys")
  public String getKeys() {
    return keys;
  }

  /**
   * @return A query parameter denoting the requests watch index.
   */
  @JsonProperty("watch_index")
  public Optional<String> getWatchIndex() {
    return watchIndex;
  }

  @JsonProperty("namespace_id")
  public Optional<UUID> getNamespaceId() {
    return namespaceId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetBatchRequest && equalTo((GetBatchRequest) other);
  }

  private boolean equalTo(GetBatchRequest other) {
    return keys.equals(other.keys) && watchIndex.equals(other.watchIndex) && namespaceId.equals(other.namespaceId);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.keys, this.watchIndex, this.namespaceId);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetBatchRequest{" + "keys: " + keys + ", watchIndex: " + watchIndex + ", namespaceId: " + namespaceId + "}";
  }

  public static KeysStage builder() {
    return new Builder();
  }

  public interface KeysStage {
    _FinalStage keys(String keys);

    Builder from(GetBatchRequest other);
  }

  public interface _FinalStage {
    GetBatchRequest build();

    _FinalStage watchIndex(Optional<String> watchIndex);

    _FinalStage watchIndex(String watchIndex);

    _FinalStage namespaceId(Optional<UUID> namespaceId);

    _FinalStage namespaceId(UUID namespaceId);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements KeysStage, _FinalStage {
    private String keys;

    private Optional<UUID> namespaceId = Optional.empty();

    private Optional<String> watchIndex = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(GetBatchRequest other) {
      keys(other.getKeys());
      watchIndex(other.getWatchIndex());
      namespaceId(other.getNamespaceId());
      return this;
    }

    @Override
    @JsonSetter("keys")
    public _FinalStage keys(String keys) {
      this.keys = keys;
      return this;
    }

    @Override
    public _FinalStage namespaceId(UUID namespaceId) {
      this.namespaceId = Optional.of(namespaceId);
      return this;
    }

    @Override
    @JsonSetter(
        value = "namespace_id",
        nulls = Nulls.SKIP
    )
    public _FinalStage namespaceId(Optional<UUID> namespaceId) {
      this.namespaceId = namespaceId;
      return this;
    }

    /**
     * <p>A query parameter denoting the requests watch index.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage watchIndex(String watchIndex) {
      this.watchIndex = Optional.of(watchIndex);
      return this;
    }

    @Override
    @JsonSetter(
        value = "watch_index",
        nulls = Nulls.SKIP
    )
    public _FinalStage watchIndex(Optional<String> watchIndex) {
      this.watchIndex = watchIndex;
      return this;
    }

    @Override
    public GetBatchRequest build() {
      return new GetBatchRequest(keys, watchIndex, namespaceId);
    }
  }
}
