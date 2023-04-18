package com.rivet.api.resources.cloud.version.matchmaker.game.mode.types;

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
    builder = GameModeRegion.Builder.class
)
public final class GameModeRegion {
  private final Optional<String> tier;

  private final Optional<GameModeIdleLobbiesConfig> idleLobbies;

  private int _cachedHashCode;

  GameModeRegion(Optional<String> tier, Optional<GameModeIdleLobbiesConfig> idleLobbies) {
    this.tier = tier;
    this.idleLobbies = idleLobbies;
  }

  @JsonProperty("tier")
  public Optional<String> getTier() {
    return tier;
  }

  @JsonProperty("idle_lobbies")
  public Optional<GameModeIdleLobbiesConfig> getIdleLobbies() {
    return idleLobbies;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GameModeRegion && equalTo((GameModeRegion) other);
  }

  private boolean equalTo(GameModeRegion other) {
    return tier.equals(other.tier) && idleLobbies.equals(other.idleLobbies);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.tier, this.idleLobbies);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GameModeRegion{" + "tier: " + tier + ", idleLobbies: " + idleLobbies + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> tier = Optional.empty();

    private Optional<GameModeIdleLobbiesConfig> idleLobbies = Optional.empty();

    private Builder() {
    }

    public Builder from(GameModeRegion other) {
      tier(other.getTier());
      idleLobbies(other.getIdleLobbies());
      return this;
    }

    @JsonSetter(
        value = "tier",
        nulls = Nulls.SKIP
    )
    public Builder tier(Optional<String> tier) {
      this.tier = tier;
      return this;
    }

    public Builder tier(String tier) {
      this.tier = Optional.of(tier);
      return this;
    }

    @JsonSetter(
        value = "idle_lobbies",
        nulls = Nulls.SKIP
    )
    public Builder idleLobbies(Optional<GameModeIdleLobbiesConfig> idleLobbies) {
      this.idleLobbies = idleLobbies;
      return this;
    }

    public Builder idleLobbies(GameModeIdleLobbiesConfig idleLobbies) {
      this.idleLobbies = Optional.of(idleLobbies);
      return this;
    }

    public GameModeRegion build() {
      return new GameModeRegion(tier, idleLobbies);
    }
  }
}
