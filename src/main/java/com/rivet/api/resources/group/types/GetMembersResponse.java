package com.rivet.api.resources.group.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.common.types.WatchResponse;
import com.rivet.api.resources.group.common.types.Member;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = GetMembersResponse.Builder.class
)
public final class GetMembersResponse {
  private final List<Member> members;

  private final Optional<String> anchor;

  private final WatchResponse watch;

  private int _cachedHashCode;

  GetMembersResponse(List<Member> members, Optional<String> anchor, WatchResponse watch) {
    this.members = members;
    this.anchor = anchor;
    this.watch = watch;
  }

  /**
   * @return A list of group members.
   */
  @JsonProperty("members")
  public List<Member> getMembers() {
    return members;
  }

  /**
   * @return The pagination anchor.
   */
  @JsonProperty("anchor")
  public Optional<String> getAnchor() {
    return anchor;
  }

  @JsonProperty("watch")
  public WatchResponse getWatch() {
    return watch;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetMembersResponse && equalTo((GetMembersResponse) other);
  }

  private boolean equalTo(GetMembersResponse other) {
    return members.equals(other.members) && anchor.equals(other.anchor) && watch.equals(other.watch);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.members, this.anchor, this.watch);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetMembersResponse{" + "members: " + members + ", anchor: " + anchor + ", watch: " + watch + "}";
  }

  public static WatchStage builder() {
    return new Builder();
  }

  public interface WatchStage {
    _FinalStage watch(WatchResponse watch);

    Builder from(GetMembersResponse other);
  }

  public interface _FinalStage {
    GetMembersResponse build();

    _FinalStage members(List<Member> members);

    _FinalStage addMembers(Member members);

    _FinalStage addAllMembers(List<Member> members);

    _FinalStage anchor(Optional<String> anchor);

    _FinalStage anchor(String anchor);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements WatchStage, _FinalStage {
    private WatchResponse watch;

    private Optional<String> anchor = Optional.empty();

    private List<Member> members = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(GetMembersResponse other) {
      members(other.getMembers());
      anchor(other.getAnchor());
      watch(other.getWatch());
      return this;
    }

    @Override
    @JsonSetter("watch")
    public _FinalStage watch(WatchResponse watch) {
      this.watch = watch;
      return this;
    }

    /**
     * <p>The pagination anchor.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage anchor(String anchor) {
      this.anchor = Optional.of(anchor);
      return this;
    }

    @Override
    @JsonSetter(
        value = "anchor",
        nulls = Nulls.SKIP
    )
    public _FinalStage anchor(Optional<String> anchor) {
      this.anchor = anchor;
      return this;
    }

    /**
     * <p>A list of group members.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addAllMembers(List<Member> members) {
      this.members.addAll(members);
      return this;
    }

    /**
     * <p>A list of group members.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addMembers(Member members) {
      this.members.add(members);
      return this;
    }

    @Override
    @JsonSetter(
        value = "members",
        nulls = Nulls.SKIP
    )
    public _FinalStage members(List<Member> members) {
      this.members.clear();
      this.members.addAll(members);
      return this;
    }

    @Override
    public GetMembersResponse build() {
      return new GetMembersResponse(members, anchor, watch);
    }
  }
}
