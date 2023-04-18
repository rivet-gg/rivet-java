package com.rivet.api.resources.party.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@JsonDeserialize(
    builder = Summary.Builder.class
)
public final class Summary {
  private final UUID partyId;

  private final String createTs;

  private final Activity activity;

  private final ExternalLinks external;

  private final Publicity publicity;

  private final int partySize;

  private final List<MemberSummary> members;

  private final UUID threadId;

  private int _cachedHashCode;

  Summary(UUID partyId, String createTs, Activity activity, ExternalLinks external,
      Publicity publicity, int partySize, List<MemberSummary> members, UUID threadId) {
    this.partyId = partyId;
    this.createTs = createTs;
    this.activity = activity;
    this.external = external;
    this.publicity = publicity;
    this.partySize = partySize;
    this.members = members;
    this.threadId = threadId;
  }

  @JsonProperty("party_id")
  public UUID getPartyId() {
    return partyId;
  }

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

  @JsonProperty("party_size")
  public int getPartySize() {
    return partySize;
  }

  @JsonProperty("members")
  public List<MemberSummary> getMembers() {
    return members;
  }

  @JsonProperty("thread_id")
  public UUID getThreadId() {
    return threadId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Summary && equalTo((Summary) other);
  }

  private boolean equalTo(Summary other) {
    return partyId.equals(other.partyId) && createTs.equals(other.createTs) && activity.equals(other.activity) && external.equals(other.external) && publicity.equals(other.publicity) && partySize == other.partySize && members.equals(other.members) && threadId.equals(other.threadId);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.partyId, this.createTs, this.activity, this.external, this.publicity, this.partySize, this.members, this.threadId);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Summary{" + "partyId: " + partyId + ", createTs: " + createTs + ", activity: " + activity + ", external: " + external + ", publicity: " + publicity + ", partySize: " + partySize + ", members: " + members + ", threadId: " + threadId + "}";
  }

  public static PartyIdStage builder() {
    return new Builder();
  }

  public interface PartyIdStage {
    CreateTsStage partyId(UUID partyId);

    Builder from(Summary other);
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
    PartySizeStage publicity(Publicity publicity);
  }

  public interface PartySizeStage {
    ThreadIdStage partySize(int partySize);
  }

  public interface ThreadIdStage {
    _FinalStage threadId(UUID threadId);
  }

  public interface _FinalStage {
    Summary build();

    _FinalStage members(List<MemberSummary> members);

    _FinalStage addMembers(MemberSummary members);

    _FinalStage addAllMembers(List<MemberSummary> members);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements PartyIdStage, CreateTsStage, ActivityStage, ExternalStage, PublicityStage, PartySizeStage, ThreadIdStage, _FinalStage {
    private UUID partyId;

    private String createTs;

    private Activity activity;

    private ExternalLinks external;

    private Publicity publicity;

    private int partySize;

    private UUID threadId;

    private List<MemberSummary> members = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(Summary other) {
      partyId(other.getPartyId());
      createTs(other.getCreateTs());
      activity(other.getActivity());
      external(other.getExternal());
      publicity(other.getPublicity());
      partySize(other.getPartySize());
      members(other.getMembers());
      threadId(other.getThreadId());
      return this;
    }

    @Override
    @JsonSetter("party_id")
    public CreateTsStage partyId(UUID partyId) {
      this.partyId = partyId;
      return this;
    }

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
    public PartySizeStage publicity(Publicity publicity) {
      this.publicity = publicity;
      return this;
    }

    @Override
    @JsonSetter("party_size")
    public ThreadIdStage partySize(int partySize) {
      this.partySize = partySize;
      return this;
    }

    @Override
    @JsonSetter("thread_id")
    public _FinalStage threadId(UUID threadId) {
      this.threadId = threadId;
      return this;
    }

    @Override
    public _FinalStage addAllMembers(List<MemberSummary> members) {
      this.members.addAll(members);
      return this;
    }

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

    @Override
    public Summary build() {
      return new Summary(partyId, createTs, activity, external, publicity, partySize, members, threadId);
    }
  }
}
