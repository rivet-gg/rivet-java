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
import java.util.UUID;

@JsonDeserialize(
    builder = Handle.Builder.class
)
public final class Handle {
  private final UUID identityId;

  private final String displayName;

  private final int accountNumber;

  private final String avatarUrl;

  private final Optional<Presence> presence;

  private final Optional<com.rivet.api.resources.party.common.types.Handle> party;

  private final boolean isRegistered;

  private final ExternalLinks external;

  private int _cachedHashCode;

  Handle(UUID identityId, String displayName, int accountNumber, String avatarUrl,
      Optional<Presence> presence,
      Optional<com.rivet.api.resources.party.common.types.Handle> party, boolean isRegistered,
      ExternalLinks external) {
    this.identityId = identityId;
    this.displayName = displayName;
    this.accountNumber = accountNumber;
    this.avatarUrl = avatarUrl;
    this.presence = presence;
    this.party = party;
    this.isRegistered = isRegistered;
    this.external = external;
  }

  @JsonProperty("identity_id")
  public UUID getIdentityId() {
    return identityId;
  }

  @JsonProperty("display_name")
  public String getDisplayName() {
    return displayName;
  }

  @JsonProperty("account_number")
  public int getAccountNumber() {
    return accountNumber;
  }

  /**
   * @return The URL of this identity's avatar image.
   */
  @JsonProperty("avatar_url")
  public String getAvatarUrl() {
    return avatarUrl;
  }

  @JsonProperty("presence")
  public Optional<Presence> getPresence() {
    return presence;
  }

  @JsonProperty("party")
  public Optional<com.rivet.api.resources.party.common.types.Handle> getParty() {
    return party;
  }

  /**
   * @return Whether or not this identity is registered with a linked account.
   */
  @JsonProperty("is_registered")
  public boolean getIsRegistered() {
    return isRegistered;
  }

  @JsonProperty("external")
  public ExternalLinks getExternal() {
    return external;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Handle && equalTo((Handle) other);
  }

  private boolean equalTo(Handle other) {
    return identityId.equals(other.identityId) && displayName.equals(other.displayName) && accountNumber == other.accountNumber && avatarUrl.equals(other.avatarUrl) && presence.equals(other.presence) && party.equals(other.party) && isRegistered == other.isRegistered && external.equals(other.external);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.identityId, this.displayName, this.accountNumber, this.avatarUrl, this.presence, this.party, this.isRegistered, this.external);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Handle{" + "identityId: " + identityId + ", displayName: " + displayName + ", accountNumber: " + accountNumber + ", avatarUrl: " + avatarUrl + ", presence: " + presence + ", party: " + party + ", isRegistered: " + isRegistered + ", external: " + external + "}";
  }

  public static IdentityIdStage builder() {
    return new Builder();
  }

  public interface IdentityIdStage {
    DisplayNameStage identityId(UUID identityId);

    Builder from(Handle other);
  }

  public interface DisplayNameStage {
    AccountNumberStage displayName(String displayName);
  }

  public interface AccountNumberStage {
    AvatarUrlStage accountNumber(int accountNumber);
  }

  public interface AvatarUrlStage {
    IsRegisteredStage avatarUrl(String avatarUrl);
  }

  public interface IsRegisteredStage {
    ExternalStage isRegistered(boolean isRegistered);
  }

  public interface ExternalStage {
    _FinalStage external(ExternalLinks external);
  }

  public interface _FinalStage {
    Handle build();

    _FinalStage presence(Optional<Presence> presence);

    _FinalStage presence(Presence presence);

    _FinalStage party(Optional<com.rivet.api.resources.party.common.types.Handle> party);

    _FinalStage party(com.rivet.api.resources.party.common.types.Handle party);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements IdentityIdStage, DisplayNameStage, AccountNumberStage, AvatarUrlStage, IsRegisteredStage, ExternalStage, _FinalStage {
    private UUID identityId;

    private String displayName;

    private int accountNumber;

    private String avatarUrl;

    private boolean isRegistered;

    private ExternalLinks external;

    private Optional<com.rivet.api.resources.party.common.types.Handle> party = Optional.empty();

    private Optional<Presence> presence = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(Handle other) {
      identityId(other.getIdentityId());
      displayName(other.getDisplayName());
      accountNumber(other.getAccountNumber());
      avatarUrl(other.getAvatarUrl());
      presence(other.getPresence());
      party(other.getParty());
      isRegistered(other.getIsRegistered());
      external(other.getExternal());
      return this;
    }

    @Override
    @JsonSetter("identity_id")
    public DisplayNameStage identityId(UUID identityId) {
      this.identityId = identityId;
      return this;
    }

    @Override
    @JsonSetter("display_name")
    public AccountNumberStage displayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    @Override
    @JsonSetter("account_number")
    public AvatarUrlStage accountNumber(int accountNumber) {
      this.accountNumber = accountNumber;
      return this;
    }

    /**
     * <p>The URL of this identity's avatar image.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("avatar_url")
    public IsRegisteredStage avatarUrl(String avatarUrl) {
      this.avatarUrl = avatarUrl;
      return this;
    }

    /**
     * <p>Whether or not this identity is registered with a linked account.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("is_registered")
    public ExternalStage isRegistered(boolean isRegistered) {
      this.isRegistered = isRegistered;
      return this;
    }

    @Override
    @JsonSetter("external")
    public _FinalStage external(ExternalLinks external) {
      this.external = external;
      return this;
    }

    @Override
    public _FinalStage party(com.rivet.api.resources.party.common.types.Handle party) {
      this.party = Optional.of(party);
      return this;
    }

    @Override
    @JsonSetter(
        value = "party",
        nulls = Nulls.SKIP
    )
    public _FinalStage party(Optional<com.rivet.api.resources.party.common.types.Handle> party) {
      this.party = party;
      return this;
    }

    @Override
    public _FinalStage presence(Presence presence) {
      this.presence = Optional.of(presence);
      return this;
    }

    @Override
    @JsonSetter(
        value = "presence",
        nulls = Nulls.SKIP
    )
    public _FinalStage presence(Optional<Presence> presence) {
      this.presence = presence;
      return this;
    }

    @Override
    public Handle build() {
      return new Handle(identityId, displayName, accountNumber, avatarUrl, presence, party, isRegistered, external);
    }
  }
}
