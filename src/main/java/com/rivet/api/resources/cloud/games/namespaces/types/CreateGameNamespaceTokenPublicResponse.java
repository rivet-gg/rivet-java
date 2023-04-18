package com.rivet.api.resources.cloud.games.namespaces.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = CreateGameNamespaceTokenPublicResponse.Builder.class
)
public final class CreateGameNamespaceTokenPublicResponse {
  private final String token;

  private int _cachedHashCode;

  CreateGameNamespaceTokenPublicResponse(String token) {
    this.token = token;
  }

  /**
   * @return A JSON Web Token.
   * Slightly modified to include a description prefix and use Protobufs of
   * JSON.
   */
  @JsonProperty("token")
  public String getToken() {
    return token;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CreateGameNamespaceTokenPublicResponse && equalTo((CreateGameNamespaceTokenPublicResponse) other);
  }

  private boolean equalTo(CreateGameNamespaceTokenPublicResponse other) {
    return token.equals(other.token);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.token);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "CreateGameNamespaceTokenPublicResponse{" + "token: " + token + "}";
  }

  public static TokenStage builder() {
    return new Builder();
  }

  public interface TokenStage {
    _FinalStage token(String token);

    Builder from(CreateGameNamespaceTokenPublicResponse other);
  }

  public interface _FinalStage {
    CreateGameNamespaceTokenPublicResponse build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements TokenStage, _FinalStage {
    private String token;

    private Builder() {
    }

    @Override
    public Builder from(CreateGameNamespaceTokenPublicResponse other) {
      token(other.getToken());
      return this;
    }

    /**
     * <p>A JSON Web Token.
     * Slightly modified to include a description prefix and use Protobufs of
     * JSON.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("token")
    public _FinalStage token(String token) {
      this.token = token;
      return this;
    }

    @Override
    public CreateGameNamespaceTokenPublicResponse build() {
      return new CreateGameNamespaceTokenPublicResponse(token);
    }
  }
}
