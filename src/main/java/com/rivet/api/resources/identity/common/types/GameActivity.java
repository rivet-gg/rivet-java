package com.rivet.api.resources.identity.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.game.common.types.Handle;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = GameActivity.Builder.class
)
public final class GameActivity {
  private final Handle game;

  private final String message;

  private final Object publicMetadata;

  private final Object mutualMetadata;

  private int _cachedHashCode;

  GameActivity(Handle game, String message, Object publicMetadata, Object mutualMetadata) {
    this.game = game;
    this.message = message;
    this.publicMetadata = publicMetadata;
    this.mutualMetadata = mutualMetadata;
  }

  @JsonProperty("game")
  public Handle getGame() {
    return game;
  }

  /**
   * @return A short activity message about the current game activity.
   */
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  /**
   * @return JSON data seen by anyone.
   */
  @JsonProperty("public_metadata")
  public Object getPublicMetadata() {
    return publicMetadata;
  }

  /**
   * @return JSON data seen only by the given identity and their mutual followers.
   */
  @JsonProperty("mutual_metadata")
  public Object getMutualMetadata() {
    return mutualMetadata;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GameActivity && equalTo((GameActivity) other);
  }

  private boolean equalTo(GameActivity other) {
    return game.equals(other.game) && message.equals(other.message) && publicMetadata.equals(other.publicMetadata) && mutualMetadata.equals(other.mutualMetadata);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.game, this.message, this.publicMetadata, this.mutualMetadata);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GameActivity{" + "game: " + game + ", message: " + message + ", publicMetadata: " + publicMetadata + ", mutualMetadata: " + mutualMetadata + "}";
  }

  public static GameStage builder() {
    return new Builder();
  }

  public interface GameStage {
    MessageStage game(Handle game);

    Builder from(GameActivity other);
  }

  public interface MessageStage {
    PublicMetadataStage message(String message);
  }

  public interface PublicMetadataStage {
    MutualMetadataStage publicMetadata(Object publicMetadata);
  }

  public interface MutualMetadataStage {
    _FinalStage mutualMetadata(Object mutualMetadata);
  }

  public interface _FinalStage {
    GameActivity build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements GameStage, MessageStage, PublicMetadataStage, MutualMetadataStage, _FinalStage {
    private Handle game;

    private String message;

    private Object publicMetadata;

    private Object mutualMetadata;

    private Builder() {
    }

    @Override
    public Builder from(GameActivity other) {
      game(other.getGame());
      message(other.getMessage());
      publicMetadata(other.getPublicMetadata());
      mutualMetadata(other.getMutualMetadata());
      return this;
    }

    @Override
    @JsonSetter("game")
    public MessageStage game(Handle game) {
      this.game = game;
      return this;
    }

    /**
     * <p>A short activity message about the current game activity.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("message")
    public PublicMetadataStage message(String message) {
      this.message = message;
      return this;
    }

    /**
     * <p>JSON data seen by anyone.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("public_metadata")
    public MutualMetadataStage publicMetadata(Object publicMetadata) {
      this.publicMetadata = publicMetadata;
      return this;
    }

    /**
     * <p>JSON data seen only by the given identity and their mutual followers.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("mutual_metadata")
    public _FinalStage mutualMetadata(Object mutualMetadata) {
      this.mutualMetadata = mutualMetadata;
      return this;
    }

    @Override
    public GameActivity build() {
      return new GameActivity(game, message, publicMetadata, mutualMetadata);
    }
  }
}
