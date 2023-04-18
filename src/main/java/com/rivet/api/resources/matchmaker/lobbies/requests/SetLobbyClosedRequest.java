package com.rivet.api.resources.matchmaker.lobbies.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = SetLobbyClosedRequest.Builder.class
)
public final class SetLobbyClosedRequest {
  private final boolean isClosed;

  private int _cachedHashCode;

  SetLobbyClosedRequest(boolean isClosed) {
    this.isClosed = isClosed;
  }

  @JsonProperty("is_closed")
  public boolean getIsClosed() {
    return isClosed;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof SetLobbyClosedRequest && equalTo((SetLobbyClosedRequest) other);
  }

  private boolean equalTo(SetLobbyClosedRequest other) {
    return isClosed == other.isClosed;
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.isClosed);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "SetLobbyClosedRequest{" + "isClosed: " + isClosed + "}";
  }

  public static IsClosedStage builder() {
    return new Builder();
  }

  public interface IsClosedStage {
    _FinalStage isClosed(boolean isClosed);

    Builder from(SetLobbyClosedRequest other);
  }

  public interface _FinalStage {
    SetLobbyClosedRequest build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements IsClosedStage, _FinalStage {
    private boolean isClosed;

    private Builder() {
    }

    @Override
    public Builder from(SetLobbyClosedRequest other) {
      isClosed(other.getIsClosed());
      return this;
    }

    @Override
    @JsonSetter("is_closed")
    public _FinalStage isClosed(boolean isClosed) {
      this.isClosed = isClosed;
      return this;
    }

    @Override
    public SetLobbyClosedRequest build() {
      return new SetLobbyClosedRequest(isClosed);
    }
  }
}
