package com.rivet.api.resources.cloud.games.matchmaker.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = DeleteMatchmakerLobbyResponse.Builder.class
)
public final class DeleteMatchmakerLobbyResponse {
  private final Optional<Boolean> didRemove;

  private int _cachedHashCode;

  DeleteMatchmakerLobbyResponse(Optional<Boolean> didRemove) {
    this.didRemove = didRemove;
  }

  /**
   * @return Whether or not the lobby was successfully stopped.
   */
  @JsonProperty("did_remove")
  public Optional<Boolean> getDidRemove() {
    return didRemove;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof DeleteMatchmakerLobbyResponse && equalTo((DeleteMatchmakerLobbyResponse) other);
  }

  private boolean equalTo(DeleteMatchmakerLobbyResponse other) {
    return didRemove.equals(other.didRemove);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.didRemove);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "DeleteMatchmakerLobbyResponse{" + "didRemove: " + didRemove + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<Boolean> didRemove = Optional.empty();

    private Builder() {
    }

    public Builder from(DeleteMatchmakerLobbyResponse other) {
      didRemove(other.getDidRemove());
      return this;
    }

    @JsonSetter(
        value = "did_remove",
        nulls = Nulls.SKIP
    )
    public Builder didRemove(Optional<Boolean> didRemove) {
      this.didRemove = didRemove;
      return this;
    }

    public Builder didRemove(Boolean didRemove) {
      this.didRemove = Optional.of(didRemove);
      return this;
    }

    public DeleteMatchmakerLobbyResponse build() {
      return new DeleteMatchmakerLobbyResponse(didRemove);
    }
  }
}
