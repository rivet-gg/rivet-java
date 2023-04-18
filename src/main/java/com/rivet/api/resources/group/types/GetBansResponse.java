package com.rivet.api.resources.group.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.common.types.WatchResponse;
import com.rivet.api.resources.group.common.types.BannedIdentity;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = GetBansResponse.Builder.class
)
public final class GetBansResponse {
  private final List<BannedIdentity> bannedIdentities;

  private final Optional<String> anchor;

  private final WatchResponse watch;

  private int _cachedHashCode;

  GetBansResponse(List<BannedIdentity> bannedIdentities, Optional<String> anchor,
      WatchResponse watch) {
    this.bannedIdentities = bannedIdentities;
    this.anchor = anchor;
    this.watch = watch;
  }

  /**
   * @return A list of banned group members.
   */
  @JsonProperty("banned_identities")
  public List<BannedIdentity> getBannedIdentities() {
    return bannedIdentities;
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
    return other instanceof GetBansResponse && equalTo((GetBansResponse) other);
  }

  private boolean equalTo(GetBansResponse other) {
    return bannedIdentities.equals(other.bannedIdentities) && anchor.equals(other.anchor) && watch.equals(other.watch);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.bannedIdentities, this.anchor, this.watch);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetBansResponse{" + "bannedIdentities: " + bannedIdentities + ", anchor: " + anchor + ", watch: " + watch + "}";
  }

  public static WatchStage builder() {
    return new Builder();
  }

  public interface WatchStage {
    _FinalStage watch(WatchResponse watch);

    Builder from(GetBansResponse other);
  }

  public interface _FinalStage {
    GetBansResponse build();

    _FinalStage bannedIdentities(List<BannedIdentity> bannedIdentities);

    _FinalStage addBannedIdentities(BannedIdentity bannedIdentities);

    _FinalStage addAllBannedIdentities(List<BannedIdentity> bannedIdentities);

    _FinalStage anchor(Optional<String> anchor);

    _FinalStage anchor(String anchor);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements WatchStage, _FinalStage {
    private WatchResponse watch;

    private Optional<String> anchor = Optional.empty();

    private List<BannedIdentity> bannedIdentities = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(GetBansResponse other) {
      bannedIdentities(other.getBannedIdentities());
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
     * <p>A list of banned group members.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addAllBannedIdentities(List<BannedIdentity> bannedIdentities) {
      this.bannedIdentities.addAll(bannedIdentities);
      return this;
    }

    /**
     * <p>A list of banned group members.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addBannedIdentities(BannedIdentity bannedIdentities) {
      this.bannedIdentities.add(bannedIdentities);
      return this;
    }

    @Override
    @JsonSetter(
        value = "banned_identities",
        nulls = Nulls.SKIP
    )
    public _FinalStage bannedIdentities(List<BannedIdentity> bannedIdentities) {
      this.bannedIdentities.clear();
      this.bannedIdentities.addAll(bannedIdentities);
      return this;
    }

    @Override
    public GetBansResponse build() {
      return new GetBansResponse(bannedIdentities, anchor, watch);
    }
  }
}
