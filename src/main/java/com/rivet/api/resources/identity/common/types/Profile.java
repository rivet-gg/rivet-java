package com.rivet.api.resources.identity.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.game.common.types.StatSummary;
import com.rivet.api.resources.party.common.types.Summary;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@JsonDeserialize(
    builder = Profile.Builder.class
)
public final class Profile {
  private final UUID identityId;

  private final String displayName;

  private final int accountNumber;

  private final String avatarUrl;

  private final Optional<Presence> presence;

  private final Optional<Summary> party;

  private final boolean isRegistered;

  private final ExternalLinks external;

  private final boolean isAdmin;

  private final Optional<Boolean> isGameLinked;

  private final Optional<DevState> devState;

  private final long followerCount;

  private final long followingCount;

  private final boolean following;

  private final boolean isFollowingMe;

  private final boolean isMutualFollowing;

  private final String joinTs;

  private final String bio;

  private final List<LinkedAccount> linkedAccounts;

  private final List<Group> groups;

  private final List<StatSummary> games;

  private final Optional<Boolean> awaitingDeletion;

  private int _cachedHashCode;

  Profile(UUID identityId, String displayName, int accountNumber, String avatarUrl,
      Optional<Presence> presence, Optional<Summary> party, boolean isRegistered,
      ExternalLinks external, boolean isAdmin, Optional<Boolean> isGameLinked,
      Optional<DevState> devState, long followerCount, long followingCount, boolean following,
      boolean isFollowingMe, boolean isMutualFollowing, String joinTs, String bio,
      List<LinkedAccount> linkedAccounts, List<Group> groups, List<StatSummary> games,
      Optional<Boolean> awaitingDeletion) {
    this.identityId = identityId;
    this.displayName = displayName;
    this.accountNumber = accountNumber;
    this.avatarUrl = avatarUrl;
    this.presence = presence;
    this.party = party;
    this.isRegistered = isRegistered;
    this.external = external;
    this.isAdmin = isAdmin;
    this.isGameLinked = isGameLinked;
    this.devState = devState;
    this.followerCount = followerCount;
    this.followingCount = followingCount;
    this.following = following;
    this.isFollowingMe = isFollowingMe;
    this.isMutualFollowing = isMutualFollowing;
    this.joinTs = joinTs;
    this.bio = bio;
    this.linkedAccounts = linkedAccounts;
    this.groups = groups;
    this.games = games;
    this.awaitingDeletion = awaitingDeletion;
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

  /**
   * @return Whether or not this identity is registered with a linked account.
   */
  @JsonProperty("party")
  public Optional<Summary> getParty() {
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

  /**
   * @return Whether or not this identity is an admin.
   */
  @JsonProperty("is_admin")
  public boolean getIsAdmin() {
    return isAdmin;
  }

  /**
   * @return Whether or not this game user has been linked through the Rivet dashboard.
   */
  @JsonProperty("is_game_linked")
  public Optional<Boolean> getIsGameLinked() {
    return isGameLinked;
  }

  /**
   * @return <strong>Deprecated</strong>
   */
  @JsonProperty("dev_state")
  public Optional<DevState> getDevState() {
    return devState;
  }

  @JsonProperty("follower_count")
  public long getFollowerCount() {
    return followerCount;
  }

  @JsonProperty("following_count")
  public long getFollowingCount() {
    return followingCount;
  }

  /**
   * @return Whether or not the requestee's identity is following this identity.
   */
  @JsonProperty("following")
  public boolean getFollowing() {
    return following;
  }

  /**
   * @return Whether or not this identity is both followng and is followed by the requestee's identity.
   */
  @JsonProperty("is_following_me")
  public boolean getIsFollowingMe() {
    return isFollowingMe;
  }

  @JsonProperty("is_mutual_following")
  public boolean getIsMutualFollowing() {
    return isMutualFollowing;
  }

  @JsonProperty("join_ts")
  public String getJoinTs() {
    return joinTs;
  }

  @JsonProperty("bio")
  public String getBio() {
    return bio;
  }

  @JsonProperty("linked_accounts")
  public List<LinkedAccount> getLinkedAccounts() {
    return linkedAccounts;
  }

  @JsonProperty("groups")
  public List<Group> getGroups() {
    return groups;
  }

  @JsonProperty("games")
  public List<StatSummary> getGames() {
    return games;
  }

  /**
   * @return Whether or not this identity is awaiting account deletion. Only visible to when the requestee is
   * this identity.
   */
  @JsonProperty("awaiting_deletion")
  public Optional<Boolean> getAwaitingDeletion() {
    return awaitingDeletion;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Profile && equalTo((Profile) other);
  }

  private boolean equalTo(Profile other) {
    return identityId.equals(other.identityId) && displayName.equals(other.displayName) && accountNumber == other.accountNumber && avatarUrl.equals(other.avatarUrl) && presence.equals(other.presence) && party.equals(other.party) && isRegistered == other.isRegistered && external.equals(other.external) && isAdmin == other.isAdmin && isGameLinked.equals(other.isGameLinked) && devState.equals(other.devState) && followerCount == other.followerCount && followingCount == other.followingCount && following == other.following && isFollowingMe == other.isFollowingMe && isMutualFollowing == other.isMutualFollowing && joinTs.equals(other.joinTs) && bio.equals(other.bio) && linkedAccounts.equals(other.linkedAccounts) && groups.equals(other.groups) && games.equals(other.games) && awaitingDeletion.equals(other.awaitingDeletion);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.identityId, this.displayName, this.accountNumber, this.avatarUrl, this.presence, this.party, this.isRegistered, this.external, this.isAdmin, this.isGameLinked, this.devState, this.followerCount, this.followingCount, this.following, this.isFollowingMe, this.isMutualFollowing, this.joinTs, this.bio, this.linkedAccounts, this.groups, this.games, this.awaitingDeletion);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Profile{" + "identityId: " + identityId + ", displayName: " + displayName + ", accountNumber: " + accountNumber + ", avatarUrl: " + avatarUrl + ", presence: " + presence + ", party: " + party + ", isRegistered: " + isRegistered + ", external: " + external + ", isAdmin: " + isAdmin + ", isGameLinked: " + isGameLinked + ", devState: " + devState + ", followerCount: " + followerCount + ", followingCount: " + followingCount + ", following: " + following + ", isFollowingMe: " + isFollowingMe + ", isMutualFollowing: " + isMutualFollowing + ", joinTs: " + joinTs + ", bio: " + bio + ", linkedAccounts: " + linkedAccounts + ", groups: " + groups + ", games: " + games + ", awaitingDeletion: " + awaitingDeletion + "}";
  }

  public static IdentityIdStage builder() {
    return new Builder();
  }

  public interface IdentityIdStage {
    DisplayNameStage identityId(UUID identityId);

    Builder from(Profile other);
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
    IsAdminStage external(ExternalLinks external);
  }

  public interface IsAdminStage {
    FollowerCountStage isAdmin(boolean isAdmin);
  }

  public interface FollowerCountStage {
    FollowingCountStage followerCount(long followerCount);
  }

  public interface FollowingCountStage {
    FollowingStage followingCount(long followingCount);
  }

  public interface FollowingStage {
    IsFollowingMeStage following(boolean following);
  }

  public interface IsFollowingMeStage {
    IsMutualFollowingStage isFollowingMe(boolean isFollowingMe);
  }

  public interface IsMutualFollowingStage {
    JoinTsStage isMutualFollowing(boolean isMutualFollowing);
  }

  public interface JoinTsStage {
    BioStage joinTs(String joinTs);
  }

  public interface BioStage {
    _FinalStage bio(String bio);
  }

  public interface _FinalStage {
    Profile build();

    _FinalStage presence(Optional<Presence> presence);

    _FinalStage presence(Presence presence);

    _FinalStage party(Optional<Summary> party);

    _FinalStage party(Summary party);

    _FinalStage isGameLinked(Optional<Boolean> isGameLinked);

    _FinalStage isGameLinked(Boolean isGameLinked);

    _FinalStage devState(Optional<DevState> devState);

    _FinalStage devState(DevState devState);

    _FinalStage linkedAccounts(List<LinkedAccount> linkedAccounts);

    _FinalStage addLinkedAccounts(LinkedAccount linkedAccounts);

    _FinalStage addAllLinkedAccounts(List<LinkedAccount> linkedAccounts);

    _FinalStage groups(List<Group> groups);

    _FinalStage addGroups(Group groups);

    _FinalStage addAllGroups(List<Group> groups);

    _FinalStage games(List<StatSummary> games);

    _FinalStage addGames(StatSummary games);

    _FinalStage addAllGames(List<StatSummary> games);

    _FinalStage awaitingDeletion(Optional<Boolean> awaitingDeletion);

    _FinalStage awaitingDeletion(Boolean awaitingDeletion);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements IdentityIdStage, DisplayNameStage, AccountNumberStage, AvatarUrlStage, IsRegisteredStage, ExternalStage, IsAdminStage, FollowerCountStage, FollowingCountStage, FollowingStage, IsFollowingMeStage, IsMutualFollowingStage, JoinTsStage, BioStage, _FinalStage {
    private UUID identityId;

    private String displayName;

    private int accountNumber;

    private String avatarUrl;

    private boolean isRegistered;

    private ExternalLinks external;

    private boolean isAdmin;

    private long followerCount;

    private long followingCount;

    private boolean following;

    private boolean isFollowingMe;

    private boolean isMutualFollowing;

    private String joinTs;

    private String bio;

    private Optional<Boolean> awaitingDeletion = Optional.empty();

    private List<StatSummary> games = new ArrayList<>();

    private List<Group> groups = new ArrayList<>();

    private List<LinkedAccount> linkedAccounts = new ArrayList<>();

    private Optional<DevState> devState = Optional.empty();

    private Optional<Boolean> isGameLinked = Optional.empty();

    private Optional<Summary> party = Optional.empty();

    private Optional<Presence> presence = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(Profile other) {
      identityId(other.getIdentityId());
      displayName(other.getDisplayName());
      accountNumber(other.getAccountNumber());
      avatarUrl(other.getAvatarUrl());
      presence(other.getPresence());
      party(other.getParty());
      isRegistered(other.getIsRegistered());
      external(other.getExternal());
      isAdmin(other.getIsAdmin());
      isGameLinked(other.getIsGameLinked());
      devState(other.getDevState());
      followerCount(other.getFollowerCount());
      followingCount(other.getFollowingCount());
      following(other.getFollowing());
      isFollowingMe(other.getIsFollowingMe());
      isMutualFollowing(other.getIsMutualFollowing());
      joinTs(other.getJoinTs());
      bio(other.getBio());
      linkedAccounts(other.getLinkedAccounts());
      groups(other.getGroups());
      games(other.getGames());
      awaitingDeletion(other.getAwaitingDeletion());
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
    public IsAdminStage external(ExternalLinks external) {
      this.external = external;
      return this;
    }

    /**
     * <p>Whether or not this identity is an admin.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("is_admin")
    public FollowerCountStage isAdmin(boolean isAdmin) {
      this.isAdmin = isAdmin;
      return this;
    }

    @Override
    @JsonSetter("follower_count")
    public FollowingCountStage followerCount(long followerCount) {
      this.followerCount = followerCount;
      return this;
    }

    @Override
    @JsonSetter("following_count")
    public FollowingStage followingCount(long followingCount) {
      this.followingCount = followingCount;
      return this;
    }

    /**
     * <p>Whether or not the requestee's identity is following this identity.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("following")
    public IsFollowingMeStage following(boolean following) {
      this.following = following;
      return this;
    }

    /**
     * <p>Whether or not this identity is both followng and is followed by the requestee's identity.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("is_following_me")
    public IsMutualFollowingStage isFollowingMe(boolean isFollowingMe) {
      this.isFollowingMe = isFollowingMe;
      return this;
    }

    @Override
    @JsonSetter("is_mutual_following")
    public JoinTsStage isMutualFollowing(boolean isMutualFollowing) {
      this.isMutualFollowing = isMutualFollowing;
      return this;
    }

    @Override
    @JsonSetter("join_ts")
    public BioStage joinTs(String joinTs) {
      this.joinTs = joinTs;
      return this;
    }

    @Override
    @JsonSetter("bio")
    public _FinalStage bio(String bio) {
      this.bio = bio;
      return this;
    }

    /**
     * <p>Whether or not this identity is awaiting account deletion. Only visible to when the requestee is
     * this identity.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage awaitingDeletion(Boolean awaitingDeletion) {
      this.awaitingDeletion = Optional.of(awaitingDeletion);
      return this;
    }

    @Override
    @JsonSetter(
        value = "awaiting_deletion",
        nulls = Nulls.SKIP
    )
    public _FinalStage awaitingDeletion(Optional<Boolean> awaitingDeletion) {
      this.awaitingDeletion = awaitingDeletion;
      return this;
    }

    @Override
    public _FinalStage addAllGames(List<StatSummary> games) {
      this.games.addAll(games);
      return this;
    }

    @Override
    public _FinalStage addGames(StatSummary games) {
      this.games.add(games);
      return this;
    }

    @Override
    @JsonSetter(
        value = "games",
        nulls = Nulls.SKIP
    )
    public _FinalStage games(List<StatSummary> games) {
      this.games.clear();
      this.games.addAll(games);
      return this;
    }

    @Override
    public _FinalStage addAllGroups(List<Group> groups) {
      this.groups.addAll(groups);
      return this;
    }

    @Override
    public _FinalStage addGroups(Group groups) {
      this.groups.add(groups);
      return this;
    }

    @Override
    @JsonSetter(
        value = "groups",
        nulls = Nulls.SKIP
    )
    public _FinalStage groups(List<Group> groups) {
      this.groups.clear();
      this.groups.addAll(groups);
      return this;
    }

    @Override
    public _FinalStage addAllLinkedAccounts(List<LinkedAccount> linkedAccounts) {
      this.linkedAccounts.addAll(linkedAccounts);
      return this;
    }

    @Override
    public _FinalStage addLinkedAccounts(LinkedAccount linkedAccounts) {
      this.linkedAccounts.add(linkedAccounts);
      return this;
    }

    @Override
    @JsonSetter(
        value = "linked_accounts",
        nulls = Nulls.SKIP
    )
    public _FinalStage linkedAccounts(List<LinkedAccount> linkedAccounts) {
      this.linkedAccounts.clear();
      this.linkedAccounts.addAll(linkedAccounts);
      return this;
    }

    /**
     * <p><strong>Deprecated</strong></p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage devState(DevState devState) {
      this.devState = Optional.of(devState);
      return this;
    }

    @Override
    @JsonSetter(
        value = "dev_state",
        nulls = Nulls.SKIP
    )
    public _FinalStage devState(Optional<DevState> devState) {
      this.devState = devState;
      return this;
    }

    /**
     * <p>Whether or not this game user has been linked through the Rivet dashboard.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage isGameLinked(Boolean isGameLinked) {
      this.isGameLinked = Optional.of(isGameLinked);
      return this;
    }

    @Override
    @JsonSetter(
        value = "is_game_linked",
        nulls = Nulls.SKIP
    )
    public _FinalStage isGameLinked(Optional<Boolean> isGameLinked) {
      this.isGameLinked = isGameLinked;
      return this;
    }

    /**
     * <p>Whether or not this identity is registered with a linked account.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage party(Summary party) {
      this.party = Optional.of(party);
      return this;
    }

    @Override
    @JsonSetter(
        value = "party",
        nulls = Nulls.SKIP
    )
    public _FinalStage party(Optional<Summary> party) {
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
    public Profile build() {
      return new Profile(identityId, displayName, accountNumber, avatarUrl, presence, party, isRegistered, external, isAdmin, isGameLinked, devState, followerCount, followingCount, following, isFollowingMe, isMutualFollowing, joinTs, bio, linkedAccounts, groups, games, awaitingDeletion);
    }
  }
}
