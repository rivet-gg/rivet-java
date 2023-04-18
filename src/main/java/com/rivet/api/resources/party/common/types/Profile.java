package com.rivet.api.resources.party.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Integer;
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
  private final UUID partyId;

  private final String createTs;

  private final Activity activity;

  private final ExternalLinks external;

  private final Publicity publicity;

  private final Optional<Integer> partySize;

  private final List<MemberSummary> members;

  private final UUID threadId;

  private final List<Invite> invites;

  private int _cachedHashCode;

  Profile(UUID partyId, String createTs, Activity activity, ExternalLinks external,
      Publicity publicity, Optional<Integer> partySize, List<MemberSummary> members, UUID threadId,
      List<Invite> invites) {
    this.partyId = partyId;
    this.createTs = createTs;
    this.activity = activity;
    this.external = external;
    this.publicity = publicity;
    this.partySize = partySize;
    this.members = members;
    this.threadId = threadId;
    this.invites = invites;
  }

  @JsonProperty("party_id")
  public UUID getPartyId() {
    return partyId;
  }

  /**
   * @return RFC3339 timestamp.
   */
  @JsonProperty("create_ts")
  public String getCreateTs() {
    return createTs;
  }

  @JsonProperty("activity")
  public Activity getActivity() {
    return activity;
  }

  @JsonProperty("external")
  public ExternalLinks getExternal() {
    return external;
  }

  @JsonProperty("publicity")
  public Publicity getPublicity() {
    return publicity;
  }

  /**
   * @return Unsigned 32 bit integer.
   */
  @JsonProperty("party_size")
  public Optional<Integer> getPartySize() {
    return partySize;
  }

  /**
   * @return A list of party members.
   */
  @JsonProperty("members")
  public List<MemberSummary> getMembers() {
    return members;
  }

  @JsonProperty("thread_id")
  public UUID getThreadId() {
    return threadId;
  }

  /**
   * @return A list of party invites.
   */
  @JsonProperty("invites")
  public List<Invite> getInvites() {
    return invites;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Profile && equalTo((Profile) other);
  }

  private boolean equalTo(Profile other) {
    return partyId.equals(other.partyId) && createTs.equals(other.createTs) && activity.equals(other.activity) && external.equals(other.external) && publicity.equals(other.publicity) && partySize.equals(other.partySize) && members.equals(other.members) && threadId.equals(other.threadId) && invites.equals(other.invites);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.partyId, this.createTs, this.activity, this.external, this.publicity, this.partySize, this.members, this.threadId, this.invites);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Profile{" + "partyId: " + partyId + ", createTs: " + createTs + ", activity: " + activity + ", external: " + external + ", publicity: " + publicity + ", partySize: " + partySize + ", members: " + members + ", threadId: " + threadId + ", invites: " + invites + "}";
  }

  public static PartyIdStage builder() {
    return new Builder();
  }

  public interface PartyIdStage {
    CreateTsStage partyId(UUID partyId);

    Builder from(Profile other);
  }

  public interface CreateTsStage {
    ActivityStage createTs(String createTs);
  }

  public interface ActivityStage {
    ExternalStage activity(Activity activity);
  }

  public interface ExternalStage {
    PublicityStage external(ExternalLinks external);
  }

  public interface PublicityStage {
    ThreadIdStage publicity(Publicity publicity);
  }

  public interface ThreadIdStage {
    _FinalStage threadId(UUID threadId);
  }

  public interface _FinalStage {
    Profile build();

    _FinalStage partySize(Optional<Integer> partySize);

    _FinalStage partySize(Integer partySize);

    _FinalStage members(List<MemberSummary> members);

    _FinalStage addMembers(MemberSummary members);

    _FinalStage addAllMembers(List<MemberSummary> members);

    _FinalStage invites(List<Invite> invites);

    _FinalStage addInvites(Invite invites);

    _FinalStage addAllInvites(List<Invite> invites);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements PartyIdStage, CreateTsStage, ActivityStage, ExternalStage, PublicityStage, ThreadIdStage, _FinalStage {
    private UUID partyId;

    private String createTs;

    private Activity activity;

    private ExternalLinks external;

    private Publicity publicity;

    private UUID threadId;

    private List<Invite> invites = new ArrayList<>();

    private List<MemberSummary> members = new ArrayList<>();

    private Optional<Integer> partySize = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(Profile other) {
      partyId(other.getPartyId());
      createTs(other.getCreateTs());
      activity(other.getActivity());
      external(other.getExternal());
      publicity(other.getPublicity());
      partySize(other.getPartySize());
      members(other.getMembers());
      threadId(other.getThreadId());
      invites(other.getInvites());
      return this;
    }

    @Override
    @JsonSetter("party_id")
    public CreateTsStage partyId(UUID partyId) {
      this.partyId = partyId;
      return this;
    }

    /**
     * <p>RFC3339 timestamp.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("create_ts")
    public ActivityStage createTs(String createTs) {
      this.createTs = createTs;
      return this;
    }

    @Override
    @JsonSetter("activity")
    public ExternalStage activity(Activity activity) {
      this.activity = activity;
      return this;
    }

    @Override
    @JsonSetter("external")
    public PublicityStage external(ExternalLinks external) {
      this.external = external;
      return this;
    }

    @Override
    @JsonSetter("publicity")
    public ThreadIdStage publicity(Publicity publicity) {
      this.publicity = publicity;
      return this;
    }

    @Override
    @JsonSetter("thread_id")
    public _FinalStage threadId(UUID threadId) {
      this.threadId = threadId;
      return this;
    }

    /**
     * <p>A list of party invites.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addAllInvites(List<Invite> invites) {
      this.invites.addAll(invites);
      return this;
    }

    /**
     * <p>A list of party invites.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addInvites(Invite invites) {
      this.invites.add(invites);
      return this;
    }

    @Override
    @JsonSetter(
        value = "invites",
        nulls = Nulls.SKIP
    )
    public _FinalStage invites(List<Invite> invites) {
      this.invites.clear();
      this.invites.addAll(invites);
      return this;
    }

    /**
     * <p>A list of party members.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addAllMembers(List<MemberSummary> members) {
      this.members.addAll(members);
      return this;
    }

    /**
     * <p>A list of party members.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addMembers(MemberSummary members) {
      this.members.add(members);
      return this;
    }

    @Override
    @JsonSetter(
        value = "members",
        nulls = Nulls.SKIP
    )
    public _FinalStage members(List<MemberSummary> members) {
      this.members.clear();
      this.members.addAll(members);
      return this;
    }

    /**
     * <p>Unsigned 32 bit integer.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage partySize(Integer partySize) {
      this.partySize = Optional.of(partySize);
      return this;
    }

    @Override
    @JsonSetter(
        value = "party_size",
        nulls = Nulls.SKIP
    )
    public _FinalStage partySize(Optional<Integer> partySize) {
      this.partySize = partySize;
      return this;
    }

    @Override
    public Profile build() {
      return new Profile(partyId, createTs, activity, external, publicity, partySize, members, threadId, invites);
    }
  }
}
