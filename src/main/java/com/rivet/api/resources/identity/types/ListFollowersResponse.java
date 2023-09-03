package com.rivet.api.resources.identity.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.common.types.WatchResponse;
import com.rivet.api.resources.identity.common.types.Handle;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ListFollowersResponse.Builder.class)
public final class ListFollowersResponse {
    private final List<Handle> identities;

    private final Optional<String> anchor;

    private final WatchResponse watch;

    private ListFollowersResponse(List<Handle> identities, Optional<String> anchor, WatchResponse watch) {
        this.identities = identities;
        this.anchor = anchor;
        this.watch = watch;
    }

    @JsonProperty("identities")
    public List<Handle> getIdentities() {
        return identities;
    }

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
        return other instanceof ListFollowersResponse && equalTo((ListFollowersResponse) other);
    }

    private boolean equalTo(ListFollowersResponse other) {
        return identities.equals(other.identities) && anchor.equals(other.anchor) && watch.equals(other.watch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.identities, this.anchor, this.watch);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static WatchStage builder() {
        return new Builder();
    }

    public interface WatchStage {
        _FinalStage watch(WatchResponse watch);

        Builder from(ListFollowersResponse other);
    }

    public interface _FinalStage {
        ListFollowersResponse build();

        _FinalStage identities(List<Handle> identities);

        _FinalStage addIdentities(Handle identities);

        _FinalStage addAllIdentities(List<Handle> identities);

        _FinalStage anchor(Optional<String> anchor);

        _FinalStage anchor(String anchor);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements WatchStage, _FinalStage {
        private WatchResponse watch;

        private Optional<String> anchor = Optional.empty();

        private List<Handle> identities = new ArrayList<>();

        private Builder() {}

        @Override
        public Builder from(ListFollowersResponse other) {
            identities(other.getIdentities());
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

        @Override
        public _FinalStage anchor(String anchor) {
            this.anchor = Optional.of(anchor);
            return this;
        }

        @Override
        @JsonSetter(value = "anchor", nulls = Nulls.SKIP)
        public _FinalStage anchor(Optional<String> anchor) {
            this.anchor = anchor;
            return this;
        }

        @Override
        public _FinalStage addAllIdentities(List<Handle> identities) {
            this.identities.addAll(identities);
            return this;
        }

        @Override
        public _FinalStage addIdentities(Handle identities) {
            this.identities.add(identities);
            return this;
        }

        @Override
        @JsonSetter(value = "identities", nulls = Nulls.SKIP)
        public _FinalStage identities(List<Handle> identities) {
            this.identities.clear();
            this.identities.addAll(identities);
            return this;
        }

        @Override
        public ListFollowersResponse build() {
            return new ListFollowersResponse(identities, anchor, watch);
        }
    }
}
