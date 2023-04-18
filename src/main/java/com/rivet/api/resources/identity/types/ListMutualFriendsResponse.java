package com.rivet.api.resources.identity.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.identity.common.types.Handle;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = ListMutualFriendsResponse.Builder.class
)
public final class ListMutualFriendsResponse {
  private final List<Handle> identities;

  private final Optional<String> anchor;

  private int _cachedHashCode;

  ListMutualFriendsResponse(List<Handle> identities, Optional<String> anchor) {
    this.identities = identities;
    this.anchor = anchor;
  }

  @JsonProperty("identities")
  public List<Handle> getIdentities() {
    return identities;
  }

  @JsonProperty("anchor")
  public Optional<String> getAnchor() {
    return anchor;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ListMutualFriendsResponse && equalTo((ListMutualFriendsResponse) other);
  }

  private boolean equalTo(ListMutualFriendsResponse other) {
    return identities.equals(other.identities) && anchor.equals(other.anchor);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.identities, this.anchor);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ListMutualFriendsResponse{" + "identities: " + identities + ", anchor: " + anchor + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<Handle> identities = new ArrayList<>();

    private Optional<String> anchor = Optional.empty();

    private Builder() {
    }

    public Builder from(ListMutualFriendsResponse other) {
      identities(other.getIdentities());
      anchor(other.getAnchor());
      return this;
    }

    @JsonSetter(
        value = "identities",
        nulls = Nulls.SKIP
    )
    public Builder identities(List<Handle> identities) {
      this.identities.clear();
      this.identities.addAll(identities);
      return this;
    }

    public Builder addIdentities(Handle identities) {
      this.identities.add(identities);
      return this;
    }

    public Builder addAllIdentities(List<Handle> identities) {
      this.identities.addAll(identities);
      return this;
    }

    @JsonSetter(
        value = "anchor",
        nulls = Nulls.SKIP
    )
    public Builder anchor(Optional<String> anchor) {
      this.anchor = anchor;
      return this;
    }

    public Builder anchor(String anchor) {
      this.anchor = Optional.of(anchor);
      return this;
    }

    public ListMutualFriendsResponse build() {
      return new ListMutualFriendsResponse(identities, anchor);
    }
  }
}
