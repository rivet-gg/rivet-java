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
    builder = GetOperationRequest.Builder.class
)
public final class GetOperationRequest {
  private final String key;

  private final Optional<String> watchIndex;

  private final Optional<UUID> namespaceId;

  private int _cachedHashCode;

  GetOperationRequest(String key, Optional<String> watchIndex, Optional<UUID> namespaceId) {
    this.key = key;
    this.watchIndex = watchIndex;
    this.namespaceId = namespaceId;
  }

  @JsonProperty("key")
  public String getKey() {
    return key;
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
    return other instanceof GetOperationRequest && equalTo((GetOperationRequest) other);
  }

  private boolean equalTo(GetOperationRequest other) {
    return key.equals(other.key) && watchIndex.equals(other.watchIndex) && namespaceId.equals(other.namespaceId);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.key, this.watchIndex, this.namespaceId);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetOperationRequest{" + "key: " + key + ", watchIndex: " + watchIndex + ", namespaceId: " + namespaceId + "}";
  }

  public static KeyStage builder() {
    return new Builder();
  }

  public interface KeyStage {
    _FinalStage key(String key);

    Builder from(GetOperationRequest other);
  }

  public interface _FinalStage {
    GetOperationRequest build();

    _FinalStage watchIndex(Optional<String> watchIndex);

    _FinalStage watchIndex(String watchIndex);

    _FinalStage namespaceId(Optional<UUID> namespaceId);

    _FinalStage namespaceId(UUID namespaceId);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements KeyStage, _FinalStage {
    private String key;

    private Optional<UUID> namespaceId = Optional.empty();

    private Optional<String> watchIndex = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(GetOperationRequest other) {
      key(other.getKey());
      watchIndex(other.getWatchIndex());
      namespaceId(other.getNamespaceId());
      return this;
    }

    @Override
    @JsonSetter("key")
    public _FinalStage key(String key) {
      this.key = key;
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
    public GetOperationRequest build() {
      return new GetOperationRequest(key, watchIndex, namespaceId);
    }
  }
}
