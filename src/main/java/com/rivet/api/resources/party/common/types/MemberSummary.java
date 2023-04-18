package com.rivet.api.resources.party.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.identity.common.types.Handle;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = MemberSummary.Builder.class
)
public final class MemberSummary {
  private final Handle identity;

  private final boolean isLeader;

  private final String joinTs;

  private final MemberState state;

  private int _cachedHashCode;

  MemberSummary(Handle identity, boolean isLeader, String joinTs, MemberState state) {
    this.identity = identity;
    this.isLeader = isLeader;
    this.joinTs = joinTs;
    this.state = state;
  }

  @JsonProperty("identity")
  public Handle getIdentity() {
    return identity;
  }

  /**
   * @return Whether or not this party member is the leader of the given party.
   */
  @JsonProperty("is_leader")
  public boolean getIsLeader() {
    return isLeader;
  }

  @JsonProperty("join_ts")
  public String getJoinTs() {
    return joinTs;
  }

  @JsonProperty("state")
  public MemberState getState() {
    return state;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof MemberSummary && equalTo((MemberSummary) other);
  }

  private boolean equalTo(MemberSummary other) {
    return identity.equals(other.identity) && isLeader == other.isLeader && joinTs.equals(other.joinTs) && state.equals(other.state);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.identity, this.isLeader, this.joinTs, this.state);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "MemberSummary{" + "identity: " + identity + ", isLeader: " + isLeader + ", joinTs: " + joinTs + ", state: " + state + "}";
  }

  public static IdentityStage builder() {
    return new Builder();
  }

  public interface IdentityStage {
    IsLeaderStage identity(Handle identity);

    Builder from(MemberSummary other);
  }

  public interface IsLeaderStage {
    JoinTsStage isLeader(boolean isLeader);
  }

  public interface JoinTsStage {
    StateStage joinTs(String joinTs);
  }

  public interface StateStage {
    _FinalStage state(MemberState state);
  }

  public interface _FinalStage {
    MemberSummary build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements IdentityStage, IsLeaderStage, JoinTsStage, StateStage, _FinalStage {
    private Handle identity;

    private boolean isLeader;

    private String joinTs;

    private MemberState state;

    private Builder() {
    }

    @Override
    public Builder from(MemberSummary other) {
      identity(other.getIdentity());
      isLeader(other.getIsLeader());
      joinTs(other.getJoinTs());
      state(other.getState());
      return this;
    }

    @Override
    @JsonSetter("identity")
    public IsLeaderStage identity(Handle identity) {
      this.identity = identity;
      return this;
    }

    /**
     * <p>Whether or not this party member is the leader of the given party.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("is_leader")
    public JoinTsStage isLeader(boolean isLeader) {
      this.isLeader = isLeader;
      return this;
    }

    @Override
    @JsonSetter("join_ts")
    public StateStage joinTs(String joinTs) {
      this.joinTs = joinTs;
      return this;
    }

    @Override
    @JsonSetter("state")
    public _FinalStage state(MemberState state) {
      this.state = state;
      return this;
    }

    @Override
    public MemberSummary build() {
      return new MemberSummary(identity, isLeader, joinTs, state);
    }
  }
}
