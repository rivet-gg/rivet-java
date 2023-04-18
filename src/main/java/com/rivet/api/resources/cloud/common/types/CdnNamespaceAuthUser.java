package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = CdnNamespaceAuthUser.Builder.class
)
public final class CdnNamespaceAuthUser {
  private final String user;

  private int _cachedHashCode;

  CdnNamespaceAuthUser(String user) {
    this.user = user;
  }

  /**
   * @return A user name.
   */
  @JsonProperty("user")
  public String getUser() {
    return user;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CdnNamespaceAuthUser && equalTo((CdnNamespaceAuthUser) other);
  }

  private boolean equalTo(CdnNamespaceAuthUser other) {
    return user.equals(other.user);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.user);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "CdnNamespaceAuthUser{" + "user: " + user + "}";
  }

  public static UserStage builder() {
    return new Builder();
  }

  public interface UserStage {
    _FinalStage user(String user);

    Builder from(CdnNamespaceAuthUser other);
  }

  public interface _FinalStage {
    CdnNamespaceAuthUser build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements UserStage, _FinalStage {
    private String user;

    private Builder() {
    }

    @Override
    public Builder from(CdnNamespaceAuthUser other) {
      user(other.getUser());
      return this;
    }

    /**
     * <p>A user name.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("user")
    public _FinalStage user(String user) {
      this.user = user;
      return this;
    }

    @Override
    public CdnNamespaceAuthUser build() {
      return new CdnNamespaceAuthUser(user);
    }
  }
}
