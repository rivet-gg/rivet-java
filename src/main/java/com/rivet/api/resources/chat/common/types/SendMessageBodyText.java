package com.rivet.api.resources.chat.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = SendMessageBodyText.Builder.class
)
public final class SendMessageBodyText {
  private final String body;

  private int _cachedHashCode;

  SendMessageBodyText(String body) {
    this.body = body;
  }

  @JsonProperty("body")
  public String getBody() {
    return body;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof SendMessageBodyText && equalTo((SendMessageBodyText) other);
  }

  private boolean equalTo(SendMessageBodyText other) {
    return body.equals(other.body);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.body);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "SendMessageBodyText{" + "body: " + body + "}";
  }

  public static BodyStage builder() {
    return new Builder();
  }

  public interface BodyStage {
    _FinalStage body(String body);

    Builder from(SendMessageBodyText other);
  }

  public interface _FinalStage {
    SendMessageBodyText build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements BodyStage, _FinalStage {
    private String body;

    private Builder() {
    }

    @Override
    public Builder from(SendMessageBodyText other) {
      body(other.getBody());
      return this;
    }

    @Override
    @JsonSetter("body")
    public _FinalStage body(String body) {
      this.body = body;
      return this;
    }

    @Override
    public SendMessageBodyText build() {
      return new SendMessageBodyText(body);
    }
  }
}
