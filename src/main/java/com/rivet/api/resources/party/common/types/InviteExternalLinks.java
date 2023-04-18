package com.rivet.api.resources.party.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = InviteExternalLinks.Builder.class
)
public final class InviteExternalLinks {
  private final String invite;

  private int _cachedHashCode;

  InviteExternalLinks(String invite) {
    this.invite = invite;
  }

  /**
   * @return The invite link used to join this party from an external site.
   */
  @JsonProperty("invite")
  public String getInvite() {
    return invite;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof InviteExternalLinks && equalTo((InviteExternalLinks) other);
  }

  private boolean equalTo(InviteExternalLinks other) {
    return invite.equals(other.invite);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.invite);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "InviteExternalLinks{" + "invite: " + invite + "}";
  }

  public static InviteStage builder() {
    return new Builder();
  }

  public interface InviteStage {
    _FinalStage invite(String invite);

    Builder from(InviteExternalLinks other);
  }

  public interface _FinalStage {
    InviteExternalLinks build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements InviteStage, _FinalStage {
    private String invite;

    private Builder() {
    }

    @Override
    public Builder from(InviteExternalLinks other) {
      invite(other.getInvite());
      return this;
    }

    /**
     * <p>The invite link used to join this party from an external site.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("invite")
    public _FinalStage invite(String invite) {
      this.invite = invite;
      return this;
    }

    @Override
    public InviteExternalLinks build() {
      return new InviteExternalLinks(invite);
    }
  }
}
