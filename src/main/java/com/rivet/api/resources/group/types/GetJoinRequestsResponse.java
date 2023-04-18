package com.rivet.api.resources.group.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.common.types.WatchResponse;
import com.rivet.api.resources.group.common.types.JoinRequest;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = GetJoinRequestsResponse.Builder.class
)
public final class GetJoinRequestsResponse {
  private final List<JoinRequest> joinRequests;

  private final Optional<String> anchor;

  private final WatchResponse watch;

  private int _cachedHashCode;

  GetJoinRequestsResponse(List<JoinRequest> joinRequests, Optional<String> anchor,
      WatchResponse watch) {
    this.joinRequests = joinRequests;
    this.anchor = anchor;
    this.watch = watch;
  }

  /**
   * @return A list of group join requests.
   */
  @JsonProperty("join_requests")
  public List<JoinRequest> getJoinRequests() {
    return joinRequests;
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
    return other instanceof GetJoinRequestsResponse && equalTo((GetJoinRequestsResponse) other);
  }

  private boolean equalTo(GetJoinRequestsResponse other) {
    return joinRequests.equals(other.joinRequests) && anchor.equals(other.anchor) && watch.equals(other.watch);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.joinRequests, this.anchor, this.watch);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetJoinRequestsResponse{" + "joinRequests: " + joinRequests + ", anchor: " + anchor + ", watch: " + watch + "}";
  }

  public static WatchStage builder() {
    return new Builder();
  }

  public interface WatchStage {
    _FinalStage watch(WatchResponse watch);

    Builder from(GetJoinRequestsResponse other);
  }

  public interface _FinalStage {
    GetJoinRequestsResponse build();

    _FinalStage joinRequests(List<JoinRequest> joinRequests);

    _FinalStage addJoinRequests(JoinRequest joinRequests);

    _FinalStage addAllJoinRequests(List<JoinRequest> joinRequests);

    _FinalStage anchor(Optional<String> anchor);

    _FinalStage anchor(String anchor);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements WatchStage, _FinalStage {
    private WatchResponse watch;

    private Optional<String> anchor = Optional.empty();

    private List<JoinRequest> joinRequests = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(GetJoinRequestsResponse other) {
      joinRequests(other.getJoinRequests());
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
     * <p>A list of group join requests.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addAllJoinRequests(List<JoinRequest> joinRequests) {
      this.joinRequests.addAll(joinRequests);
      return this;
    }

    /**
     * <p>A list of group join requests.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addJoinRequests(JoinRequest joinRequests) {
      this.joinRequests.add(joinRequests);
      return this;
    }

    @Override
    @JsonSetter(
        value = "join_requests",
        nulls = Nulls.SKIP
    )
    public _FinalStage joinRequests(List<JoinRequest> joinRequests) {
      this.joinRequests.clear();
      this.joinRequests.addAll(joinRequests);
      return this;
    }

    @Override
    public GetJoinRequestsResponse build() {
      return new GetJoinRequestsResponse(joinRequests, anchor, watch);
    }
  }
}
