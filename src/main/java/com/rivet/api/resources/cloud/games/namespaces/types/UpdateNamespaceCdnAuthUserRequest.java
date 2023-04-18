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
    builder = UpdateNamespaceCdnAuthUserRequest.Builder.class
)
public final class UpdateNamespaceCdnAuthUserRequest {
  private final String user;

  private final String password;

  private int _cachedHashCode;

  UpdateNamespaceCdnAuthUserRequest(String user, String password) {
    this.user = user;
    this.password = password;
  }

  /**
   * @return A user name.
   */
  @JsonProperty("user")
  public String getUser() {
    return user;
  }

  /**
   * @return A bcrypt encrypted password. An error is returned if the given string is not properly encrypted.
   */
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof UpdateNamespaceCdnAuthUserRequest && equalTo((UpdateNamespaceCdnAuthUserRequest) other);
  }

  private boolean equalTo(UpdateNamespaceCdnAuthUserRequest other) {
    return user.equals(other.user) && password.equals(other.password);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.user, this.password);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "UpdateNamespaceCdnAuthUserRequest{" + "user: " + user + ", password: " + password + "}";
  }

  public static UserStage builder() {
    return new Builder();
  }

  public interface UserStage {
    PasswordStage user(String user);

    Builder from(UpdateNamespaceCdnAuthUserRequest other);
  }

  public interface PasswordStage {
    _FinalStage password(String password);
  }

  public interface _FinalStage {
    UpdateNamespaceCdnAuthUserRequest build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements UserStage, PasswordStage, _FinalStage {
    private String user;

    private String password;

    private Builder() {
    }

    @Override
    public Builder from(UpdateNamespaceCdnAuthUserRequest other) {
      user(other.getUser());
      password(other.getPassword());
      return this;
    }

    /**
     * <p>A user name.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("user")
    public PasswordStage user(String user) {
      this.user = user;
      return this;
    }

    /**
     * <p>A bcrypt encrypted password. An error is returned if the given string is not properly encrypted.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("password")
    public _FinalStage password(String password) {
      this.password = password;
      return this;
    }

    @Override
    public UpdateNamespaceCdnAuthUserRequest build() {
      return new UpdateNamespaceCdnAuthUserRequest(user, password);
    }
  }
}
