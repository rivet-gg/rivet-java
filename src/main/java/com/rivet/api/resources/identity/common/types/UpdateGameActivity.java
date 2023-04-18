package com.rivet.api.resources.identity.common.types;

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
    builder = UpdateGameActivity.Builder.class
)
public final class UpdateGameActivity {
  private final Optional<String> message;

  private final Object publicMetadata;

  private final Object mutualMetadata;

  private int _cachedHashCode;

  UpdateGameActivity(Optional<String> message, Object publicMetadata, Object mutualMetadata) {
    this.message = message;
    this.publicMetadata = publicMetadata;
    this.mutualMetadata = mutualMetadata;
  }

  /**
   * @return A short message about the current game activity.
   */
  @JsonProperty("message")
  public Optional<String> getMessage() {
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
    return other instanceof UpdateGameActivity && equalTo((UpdateGameActivity) other);
  }

  private boolean equalTo(UpdateGameActivity other) {
    return message.equals(other.message) && publicMetadata.equals(other.publicMetadata) && mutualMetadata.equals(other.mutualMetadata);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.message, this.publicMetadata, this.mutualMetadata);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "UpdateGameActivity{" + "message: " + message + ", publicMetadata: " + publicMetadata + ", mutualMetadata: " + mutualMetadata + "}";
  }

  public static PublicMetadataStage builder() {
    return new Builder();
  }

  public interface PublicMetadataStage {
    MutualMetadataStage publicMetadata(Object publicMetadata);

    Builder from(UpdateGameActivity other);
  }

  public interface MutualMetadataStage {
    _FinalStage mutualMetadata(Object mutualMetadata);
  }

  public interface _FinalStage {
    UpdateGameActivity build();

    _FinalStage message(Optional<String> message);

    _FinalStage message(String message);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements PublicMetadataStage, MutualMetadataStage, _FinalStage {
    private Object publicMetadata;

    private Object mutualMetadata;

    private Optional<String> message = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(UpdateGameActivity other) {
      message(other.getMessage());
      publicMetadata(other.getPublicMetadata());
      mutualMetadata(other.getMutualMetadata());
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

    /**
     * <p>A short message about the current game activity.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage message(String message) {
      this.message = Optional.of(message);
      return this;
    }

    @Override
    @JsonSetter(
        value = "message",
        nulls = Nulls.SKIP
    )
    public _FinalStage message(Optional<String> message) {
      this.message = message;
      return this;
    }

    @Override
    public UpdateGameActivity build() {
      return new UpdateGameActivity(message, publicMetadata, mutualMetadata);
    }
  }
}
