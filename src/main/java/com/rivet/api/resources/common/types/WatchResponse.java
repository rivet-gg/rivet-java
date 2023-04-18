package com.rivet.api.resources.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = WatchResponse.Builder.class
)
public final class WatchResponse {
  private final String index;

  private int _cachedHashCode;

  WatchResponse(String index) {
    this.index = index;
  }

  /**
   * @return Index indicating the version of the data responded.
   * Pass this to <code>WatchQuery</code> to block and wait for the next response.
   */
  @JsonProperty("index")
  public String getIndex() {
    return index;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof WatchResponse && equalTo((WatchResponse) other);
  }

  private boolean equalTo(WatchResponse other) {
    return index.equals(other.index);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.index);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "WatchResponse{" + "index: " + index + "}";
  }

  public static IndexStage builder() {
    return new Builder();
  }

  public interface IndexStage {
    _FinalStage index(String index);

    Builder from(WatchResponse other);
  }

  public interface _FinalStage {
    WatchResponse build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements IndexStage, _FinalStage {
    private String index;

    private Builder() {
    }

    @Override
    public Builder from(WatchResponse other) {
      index(other.getIndex());
      return this;
    }

    /**
     * <p>Index indicating the version of the data responded.
     * Pass this to <code>WatchQuery</code> to block and wait for the next response.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("index")
    public _FinalStage index(String index) {
      this.index = index;
      return this;
    }

    @Override
    public WatchResponse build() {
      return new WatchResponse(index);
    }
  }
}
