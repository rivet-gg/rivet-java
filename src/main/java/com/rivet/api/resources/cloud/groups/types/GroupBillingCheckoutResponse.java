package com.rivet.api.resources.cloud.groups.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = GroupBillingCheckoutResponse.Builder.class
)
public final class GroupBillingCheckoutResponse {
  private final String url;

  private int _cachedHashCode;

  GroupBillingCheckoutResponse(String url) {
    this.url = url;
  }

  /**
   * @return The URL of the checkout session.
   */
  @JsonProperty("url")
  public String getUrl() {
    return url;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GroupBillingCheckoutResponse && equalTo((GroupBillingCheckoutResponse) other);
  }

  private boolean equalTo(GroupBillingCheckoutResponse other) {
    return url.equals(other.url);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.url);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GroupBillingCheckoutResponse{" + "url: " + url + "}";
  }

  public static UrlStage builder() {
    return new Builder();
  }

  public interface UrlStage {
    _FinalStage url(String url);

    Builder from(GroupBillingCheckoutResponse other);
  }

  public interface _FinalStage {
    GroupBillingCheckoutResponse build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements UrlStage, _FinalStage {
    private String url;

    private Builder() {
    }

    @Override
    public Builder from(GroupBillingCheckoutResponse other) {
      url(other.getUrl());
      return this;
    }

    /**
     * <p>The URL of the checkout session.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("url")
    public _FinalStage url(String url) {
      this.url = url;
      return this;
    }

    @Override
    public GroupBillingCheckoutResponse build() {
      return new GroupBillingCheckoutResponse(url);
    }
  }
}
