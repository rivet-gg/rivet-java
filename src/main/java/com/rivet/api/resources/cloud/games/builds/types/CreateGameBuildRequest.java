package com.rivet.api.resources.cloud.games.builds.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.upload.common.types.PrepareFile;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = CreateGameBuildRequest.Builder.class
)
public final class CreateGameBuildRequest {
  private final String displayName;

  private final String imageTag;

  private final PrepareFile imageFile;

  private int _cachedHashCode;

  CreateGameBuildRequest(String displayName, String imageTag, PrepareFile imageFile) {
    this.displayName = displayName;
    this.imageTag = imageTag;
    this.imageFile = imageFile;
  }

  /**
   * @return Represent a resource's readable display name.
   */
  @JsonProperty("display_name")
  public String getDisplayName() {
    return displayName;
  }

  /**
   * @return A tag given to the game build.
   */
  @JsonProperty("image_tag")
  public String getImageTag() {
    return imageTag;
  }

  @JsonProperty("image_file")
  public PrepareFile getImageFile() {
    return imageFile;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CreateGameBuildRequest && equalTo((CreateGameBuildRequest) other);
  }

  private boolean equalTo(CreateGameBuildRequest other) {
    return displayName.equals(other.displayName) && imageTag.equals(other.imageTag) && imageFile.equals(other.imageFile);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.displayName, this.imageTag, this.imageFile);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "CreateGameBuildRequest{" + "displayName: " + displayName + ", imageTag: " + imageTag + ", imageFile: " + imageFile + "}";
  }

  public static DisplayNameStage builder() {
    return new Builder();
  }

  public interface DisplayNameStage {
    ImageTagStage displayName(String displayName);

    Builder from(CreateGameBuildRequest other);
  }

  public interface ImageTagStage {
    ImageFileStage imageTag(String imageTag);
  }

  public interface ImageFileStage {
    _FinalStage imageFile(PrepareFile imageFile);
  }

  public interface _FinalStage {
    CreateGameBuildRequest build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements DisplayNameStage, ImageTagStage, ImageFileStage, _FinalStage {
    private String displayName;

    private String imageTag;

    private PrepareFile imageFile;

    private Builder() {
    }

    @Override
    public Builder from(CreateGameBuildRequest other) {
      displayName(other.getDisplayName());
      imageTag(other.getImageTag());
      imageFile(other.getImageFile());
      return this;
    }

    /**
     * <p>Represent a resource's readable display name.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("display_name")
    public ImageTagStage displayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    /**
     * <p>A tag given to the game build.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("image_tag")
    public ImageFileStage imageTag(String imageTag) {
      this.imageTag = imageTag;
      return this;
    }

    @Override
    @JsonSetter("image_file")
    public _FinalStage imageFile(PrepareFile imageFile) {
      this.imageFile = imageFile;
      return this;
    }

    @Override
    public CreateGameBuildRequest build() {
      return new CreateGameBuildRequest(displayName, imageTag, imageFile);
    }
  }
}
