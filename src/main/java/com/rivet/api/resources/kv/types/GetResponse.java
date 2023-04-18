package com.rivet.api.resources.kv.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.common.types.WatchResponse;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = GetResponse.Builder.class
)
public final class GetResponse {
  private final Object value;

  private final Optional<Boolean> deleted;

  private final WatchResponse watch;

  private int _cachedHashCode;

  GetResponse(Object value, Optional<Boolean> deleted, WatchResponse watch) {
    this.value = value;
    this.deleted = deleted;
    this.watch = watch;
  }

  @JsonProperty("value")
  public Object getValue() {
    return value;
  }

  /**
   * @return Whether or not the entry has been deleted. Only set when watching this endpoint.
   */
  @JsonProperty("deleted")
  public Optional<Boolean> getDeleted() {
    return deleted;
  }

  @JsonProperty("watch")
  public WatchResponse getWatch() {
    return watch;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetResponse && equalTo((GetResponse) other);
  }

  private boolean equalTo(GetResponse other) {
    return value.equals(other.value) && deleted.equals(other.deleted) && watch.equals(other.watch);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.value, this.deleted, this.watch);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetResponse{" + "value: " + value + ", deleted: " + deleted + ", watch: " + watch + "}";
  }

  public static ValueStage builder() {
    return new Builder();
  }

  public interface ValueStage {
    WatchStage value(Object value);

    Builder from(GetResponse other);
  }

  public interface WatchStage {
    _FinalStage watch(WatchResponse watch);
  }

  public interface _FinalStage {
    GetResponse build();

    _FinalStage deleted(Optional<Boolean> deleted);

    _FinalStage deleted(Boolean deleted);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements ValueStage, WatchStage, _FinalStage {
    private Object value;

    private WatchResponse watch;

    private Optional<Boolean> deleted = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(GetResponse other) {
      value(other.getValue());
      deleted(other.getDeleted());
      watch(other.getWatch());
      return this;
    }

    @Override
    @JsonSetter("value")
    public WatchStage value(Object value) {
      this.value = value;
      return this;
    }

    @Override
    @JsonSetter("watch")
    public _FinalStage watch(WatchResponse watch) {
      this.watch = watch;
      return this;
    }

    /**
     * <p>Whether or not the entry has been deleted. Only set when watching this endpoint.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage deleted(Boolean deleted) {
      this.deleted = Optional.of(deleted);
      return this;
    }

    @Override
    @JsonSetter(
        value = "deleted",
        nulls = Nulls.SKIP
    )
    public _FinalStage deleted(Optional<Boolean> deleted) {
      this.deleted = deleted;
      return this;
    }

    @Override
    public GetResponse build() {
      return new GetResponse(value, deleted, watch);
    }
  }
}
