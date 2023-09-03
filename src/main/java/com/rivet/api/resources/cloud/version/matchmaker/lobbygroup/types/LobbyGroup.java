package com.rivet.api.resources.cloud.version.matchmaker.lobbygroup.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = LobbyGroup.Builder.class)
public final class LobbyGroup {
    private final String nameId;

    private final List<LobbyGroupRegion> regions;

    private final int maxPlayersNormal;

    private final int maxPlayersDirect;

    private final int maxPlayersParty;

    private final LobbyGroupRuntime runtime;

    private LobbyGroup(
            String nameId,
            List<LobbyGroupRegion> regions,
            int maxPlayersNormal,
            int maxPlayersDirect,
            int maxPlayersParty,
            LobbyGroupRuntime runtime) {
        this.nameId = nameId;
        this.regions = regions;
        this.maxPlayersNormal = maxPlayersNormal;
        this.maxPlayersDirect = maxPlayersDirect;
        this.maxPlayersParty = maxPlayersParty;
        this.runtime = runtime;
    }

    /**
     * @return <strong>Deprecated: use GameMode instead</strong>
     * A human readable short identifier used to references resources. Different than a <code>rivet.common#Uuid</code> because this is intended to be human readable. Different than <code>rivet.common#DisplayName</code> because this should not include special characters and be short.
     */
    @JsonProperty("name_id")
    public String getNameId() {
        return nameId;
    }

    /**
     * @return A list of game mode regions.
     */
    @JsonProperty("regions")
    public List<LobbyGroupRegion> getRegions() {
        return regions;
    }

    /**
     * @return Unsigned 32 bit integer.
     */
    @JsonProperty("max_players_normal")
    public int getMaxPlayersNormal() {
        return maxPlayersNormal;
    }

    /**
     * @return Unsigned 32 bit integer.
     */
    @JsonProperty("max_players_direct")
    public int getMaxPlayersDirect() {
        return maxPlayersDirect;
    }

    /**
     * @return Unsigned 32 bit integer.
     */
    @JsonProperty("max_players_party")
    public int getMaxPlayersParty() {
        return maxPlayersParty;
    }

    @JsonProperty("runtime")
    public LobbyGroupRuntime getRuntime() {
        return runtime;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LobbyGroup && equalTo((LobbyGroup) other);
    }

    private boolean equalTo(LobbyGroup other) {
        return nameId.equals(other.nameId)
                && regions.equals(other.regions)
                && maxPlayersNormal == other.maxPlayersNormal
                && maxPlayersDirect == other.maxPlayersDirect
                && maxPlayersParty == other.maxPlayersParty
                && runtime.equals(other.runtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.nameId,
                this.regions,
                this.maxPlayersNormal,
                this.maxPlayersDirect,
                this.maxPlayersParty,
                this.runtime);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NameIdStage builder() {
        return new Builder();
    }

    public interface NameIdStage {
        MaxPlayersNormalStage nameId(String nameId);

        Builder from(LobbyGroup other);
    }

    public interface MaxPlayersNormalStage {
        MaxPlayersDirectStage maxPlayersNormal(int maxPlayersNormal);
    }

    public interface MaxPlayersDirectStage {
        MaxPlayersPartyStage maxPlayersDirect(int maxPlayersDirect);
    }

    public interface MaxPlayersPartyStage {
        RuntimeStage maxPlayersParty(int maxPlayersParty);
    }

    public interface RuntimeStage {
        _FinalStage runtime(LobbyGroupRuntime runtime);
    }

    public interface _FinalStage {
        LobbyGroup build();

        _FinalStage regions(List<LobbyGroupRegion> regions);

        _FinalStage addRegions(LobbyGroupRegion regions);

        _FinalStage addAllRegions(List<LobbyGroupRegion> regions);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements NameIdStage,
                    MaxPlayersNormalStage,
                    MaxPlayersDirectStage,
                    MaxPlayersPartyStage,
                    RuntimeStage,
                    _FinalStage {
        private String nameId;

        private int maxPlayersNormal;

        private int maxPlayersDirect;

        private int maxPlayersParty;

        private LobbyGroupRuntime runtime;

        private List<LobbyGroupRegion> regions = new ArrayList<>();

        private Builder() {}

        @Override
        public Builder from(LobbyGroup other) {
            nameId(other.getNameId());
            regions(other.getRegions());
            maxPlayersNormal(other.getMaxPlayersNormal());
            maxPlayersDirect(other.getMaxPlayersDirect());
            maxPlayersParty(other.getMaxPlayersParty());
            runtime(other.getRuntime());
            return this;
        }

        /**
         * <p><strong>Deprecated: use GameMode instead</strong>
         * A human readable short identifier used to references resources. Different than a <code>rivet.common#Uuid</code> because this is intended to be human readable. Different than <code>rivet.common#DisplayName</code> because this should not include special characters and be short.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name_id")
        public MaxPlayersNormalStage nameId(String nameId) {
            this.nameId = nameId;
            return this;
        }

        /**
         * <p>Unsigned 32 bit integer.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("max_players_normal")
        public MaxPlayersDirectStage maxPlayersNormal(int maxPlayersNormal) {
            this.maxPlayersNormal = maxPlayersNormal;
            return this;
        }

        /**
         * <p>Unsigned 32 bit integer.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("max_players_direct")
        public MaxPlayersPartyStage maxPlayersDirect(int maxPlayersDirect) {
            this.maxPlayersDirect = maxPlayersDirect;
            return this;
        }

        /**
         * <p>Unsigned 32 bit integer.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("max_players_party")
        public RuntimeStage maxPlayersParty(int maxPlayersParty) {
            this.maxPlayersParty = maxPlayersParty;
            return this;
        }

        @Override
        @JsonSetter("runtime")
        public _FinalStage runtime(LobbyGroupRuntime runtime) {
            this.runtime = runtime;
            return this;
        }

        /**
         * <p>A list of game mode regions.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllRegions(List<LobbyGroupRegion> regions) {
            this.regions.addAll(regions);
            return this;
        }

        /**
         * <p>A list of game mode regions.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addRegions(LobbyGroupRegion regions) {
            this.regions.add(regions);
            return this;
        }

        @Override
        @JsonSetter(value = "regions", nulls = Nulls.SKIP)
        public _FinalStage regions(List<LobbyGroupRegion> regions) {
            this.regions.clear();
            this.regions.addAll(regions);
            return this;
        }

        @Override
        public LobbyGroup build() {
            return new LobbyGroup(nameId, regions, maxPlayersNormal, maxPlayersDirect, maxPlayersParty, runtime);
        }
    }
}
