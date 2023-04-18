package com.rivet.api.resources.identity.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = GlobalEventNotification.Builder.class
)
public final class GlobalEventNotification {
  private final String title;

  private final String description;

  private final String thumbnailUrl;

  private final String url;

  private int _cachedHashCode;

  GlobalEventNotification(String title, String description, String thumbnailUrl, String url) {
    this.title = title;
    this.description = description;
    this.thumbnailUrl = thumbnailUrl;
    this.url = url;
  }

  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  /**
   * @return URL to an image thumbnail that should be shown for this notification.
   */
  @JsonProperty("thumbnail_url")
  public String getThumbnailUrl() {
    return thumbnailUrl;
  }

  /**
   * @return Rivet Hub URL that holds the relevant context for this notification.
   */
  @JsonProperty("url")
  public String getUrl() {
    return url;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GlobalEventNotification && equalTo((GlobalEventNotification) other);
  }

  private boolean equalTo(GlobalEventNotification other) {
    return title.equals(other.title) && description.equals(other.description) && thumbnailUrl.equals(other.thumbnailUrl) && url.equals(other.url);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.title, this.description, this.thumbnailUrl, this.url);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GlobalEventNotification{" + "title: " + title + ", description: " + description + ", thumbnailUrl: " + thumbnailUrl + ", url: " + url + "}";
  }

  public static TitleStage builder() {
    return new Builder();
  }

  public interface TitleStage {
    DescriptionStage title(String title);

    Builder from(GlobalEventNotification other);
  }

  public interface DescriptionStage {
    ThumbnailUrlStage description(String description);
  }

  public interface ThumbnailUrlStage {
    UrlStage thumbnailUrl(String thumbnailUrl);
  }

  public interface UrlStage {
    _FinalStage url(String url);
  }

  public interface _FinalStage {
    GlobalEventNotification build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements TitleStage, DescriptionStage, ThumbnailUrlStage, UrlStage, _FinalStage {
    private String title;

    private String description;

    private String thumbnailUrl;

    private String url;

    private Builder() {
    }

    @Override
    public Builder from(GlobalEventNotification other) {
      title(other.getTitle());
      description(other.getDescription());
      thumbnailUrl(other.getThumbnailUrl());
      url(other.getUrl());
      return this;
    }

    @Override
    @JsonSetter("title")
    public DescriptionStage title(String title) {
      this.title = title;
      return this;
    }

    @Override
    @JsonSetter("description")
    public ThumbnailUrlStage description(String description) {
      this.description = description;
      return this;
    }

    /**
     * <p>URL to an image thumbnail that should be shown for this notification.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("thumbnail_url")
    public UrlStage thumbnailUrl(String thumbnailUrl) {
      this.thumbnailUrl = thumbnailUrl;
      return this;
    }

    /**
     * <p>Rivet Hub URL that holds the relevant context for this notification.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("url")
    public _FinalStage url(String url) {
      this.url = url;
      return this;
    }

    @Override
    public GlobalEventNotification build() {
      return new GlobalEventNotification(title, description, thumbnailUrl, url);
    }
  }
}
