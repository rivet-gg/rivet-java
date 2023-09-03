package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = LobbySummaryAnalytics.Builder.class)
public final class LobbySummaryAnalytics {
    private final UUID lobbyId;

    private final UUID lobbyGroupId;

    private final String lobbyGroupNameId;

    private final UUID regionId;

    private final OffsetDateTime createTs;

    private final boolean isReady;

    private final boolean isIdle;

    private final boolean isClosed;

    private final boolean isOutdated;

    private final int maxPlayersNormal;

    private final int maxPlayersDirect;

    private final int maxPlayersParty;

    private final int totalPlayerCount;

    private final int registeredPlayerCount;

    private LobbySummaryAnalytics(
            UUID lobbyId,
            UUID lobbyGroupId,
            String lobbyGroupNameId,
            UUID regionId,
            OffsetDateTime createTs,
            boolean isReady,
            boolean isIdle,
            boolean isClosed,
            boolean isOutdated,
            int maxPlayersNormal,
            int maxPlayersDirect,
            int maxPlayersParty,
            int totalPlayerCount,
            int registeredPlayerCount) {
        this.lobbyId = lobbyId;
        this.lobbyGroupId = lobbyGroupId;
        this.lobbyGroupNameId = lobbyGroupNameId;
        this.regionId = regionId;
        this.createTs = createTs;
        this.isReady = isReady;
        this.isIdle = isIdle;
        this.isClosed = isClosed;
        this.isOutdated = isOutdated;
        this.maxPlayersNormal = maxPlayersNormal;
        this.maxPlayersDirect = maxPlayersDirect;
        this.maxPlayersParty = maxPlayersParty;
        this.totalPlayerCount = totalPlayerCount;
        this.registeredPlayerCount = registeredPlayerCount;
    }

    @JsonProperty("lobby_id")
    public UUID getLobbyId() {
        return lobbyId;
    }

    @JsonProperty("lobby_group_id")
    public UUID getLobbyGroupId() {
        return lobbyGroupId;
    }

    /**
     * @return A human readable short identifier used to references resources. Different than a <code>rivet.common#Uuid</code> because this is intended to be human readable. Different than <code>rivet.common#DisplayName</code> because this should not include special characters and be short.
     */
    @JsonProperty("lobby_group_name_id")
    public String getLobbyGroupNameId() {
        return lobbyGroupNameId;
    }

    @JsonProperty("region_id")
    public UUID getRegionId() {
        return regionId;
    }

    /**
     * @return RFC3339 timestamp.
     */
    @JsonProperty("create_ts")
    public OffsetDateTime getCreateTs() {
        return createTs;
    }

    /**
     * @return Whether or not this lobby is ready.
     */
    @JsonProperty("is_ready")
    public boolean getIsReady() {
        return isReady;
    }

    /**
     * @return Whether or not this lobby is idle.
     */
    @JsonProperty("is_idle")
    public boolean getIsIdle() {
        return isIdle;
    }

    /**
     * @return Whether or not this lobby is in a closed state.
     */
    @JsonProperty("is_closed")
    public boolean getIsClosed() {
        return isClosed;
    }

    /**
     * @return Whether or not this lobby is outdated.
     */
    @JsonProperty("is_outdated")
    public boolean getIsOutdated() {
        return isOutdated;
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

    /**
     * @return Unsigned 32 bit integer.
     */
    @JsonProperty("total_player_count")
    public int getTotalPlayerCount() {
        return totalPlayerCount;
    }

    /**
     * @return Unsigned 32 bit integer.
     */
    @JsonProperty("registered_player_count")
    public int getRegisteredPlayerCount() {
        return registeredPlayerCount;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LobbySummaryAnalytics && equalTo((LobbySummaryAnalytics) other);
    }

    private boolean equalTo(LobbySummaryAnalytics other) {
        return lobbyId.equals(other.lobbyId)
                && lobbyGroupId.equals(other.lobbyGroupId)
                && lobbyGroupNameId.equals(other.lobbyGroupNameId)
                && regionId.equals(other.regionId)
                && createTs.equals(other.createTs)
                && isReady == other.isReady
                && isIdle == other.isIdle
                && isClosed == other.isClosed
                && isOutdated == other.isOutdated
                && maxPlayersNormal == other.maxPlayersNormal
                && maxPlayersDirect == other.maxPlayersDirect
                && maxPlayersParty == other.maxPlayersParty
                && totalPlayerCount == other.totalPlayerCount
                && registeredPlayerCount == other.registeredPlayerCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.lobbyId,
                this.lobbyGroupId,
                this.lobbyGroupNameId,
                this.regionId,
                this.createTs,
                this.isReady,
                this.isIdle,
                this.isClosed,
                this.isOutdated,
                this.maxPlayersNormal,
                this.maxPlayersDirect,
                this.maxPlayersParty,
                this.totalPlayerCount,
                this.registeredPlayerCount);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static LobbyIdStage builder() {
        return new Builder();
    }

    public interface LobbyIdStage {
        LobbyGroupIdStage lobbyId(UUID lobbyId);

        Builder from(LobbySummaryAnalytics other);
    }

    public interface LobbyGroupIdStage {
        LobbyGroupNameIdStage lobbyGroupId(UUID lobbyGroupId);
    }

    public interface LobbyGroupNameIdStage {
        RegionIdStage lobbyGroupNameId(String lobbyGroupNameId);
    }

    public interface RegionIdStage {
        CreateTsStage regionId(UUID regionId);
    }

    public interface CreateTsStage {
        IsReadyStage createTs(OffsetDateTime createTs);
    }

    public interface IsReadyStage {
        IsIdleStage isReady(boolean isReady);
    }

    public interface IsIdleStage {
        IsClosedStage isIdle(boolean isIdle);
    }

    public interface IsClosedStage {
        IsOutdatedStage isClosed(boolean isClosed);
    }

    public interface IsOutdatedStage {
        MaxPlayersNormalStage isOutdated(boolean isOutdated);
    }

    public interface MaxPlayersNormalStage {
        MaxPlayersDirectStage maxPlayersNormal(int maxPlayersNormal);
    }

    public interface MaxPlayersDirectStage {
        MaxPlayersPartyStage maxPlayersDirect(int maxPlayersDirect);
    }

    public interface MaxPlayersPartyStage {
        TotalPlayerCountStage maxPlayersParty(int maxPlayersParty);
    }

    public interface TotalPlayerCountStage {
        RegisteredPlayerCountStage totalPlayerCount(int totalPlayerCount);
    }

    public interface RegisteredPlayerCountStage {
        _FinalStage registeredPlayerCount(int registeredPlayerCount);
    }

    public interface _FinalStage {
        LobbySummaryAnalytics build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements LobbyIdStage,
                    LobbyGroupIdStage,
                    LobbyGroupNameIdStage,
                    RegionIdStage,
                    CreateTsStage,
                    IsReadyStage,
                    IsIdleStage,
                    IsClosedStage,
                    IsOutdatedStage,
                    MaxPlayersNormalStage,
                    MaxPlayersDirectStage,
                    MaxPlayersPartyStage,
                    TotalPlayerCountStage,
                    RegisteredPlayerCountStage,
                    _FinalStage {
        private UUID lobbyId;

        private UUID lobbyGroupId;

        private String lobbyGroupNameId;

        private UUID regionId;

        private OffsetDateTime createTs;

        private boolean isReady;

        private boolean isIdle;

        private boolean isClosed;

        private boolean isOutdated;

        private int maxPlayersNormal;

        private int maxPlayersDirect;

        private int maxPlayersParty;

        private int totalPlayerCount;

        private int registeredPlayerCount;

        private Builder() {}

        @Override
        public Builder from(LobbySummaryAnalytics other) {
            lobbyId(other.getLobbyId());
            lobbyGroupId(other.getLobbyGroupId());
            lobbyGroupNameId(other.getLobbyGroupNameId());
            regionId(other.getRegionId());
            createTs(other.getCreateTs());
            isReady(other.getIsReady());
            isIdle(other.getIsIdle());
            isClosed(other.getIsClosed());
            isOutdated(other.getIsOutdated());
            maxPlayersNormal(other.getMaxPlayersNormal());
            maxPlayersDirect(other.getMaxPlayersDirect());
            maxPlayersParty(other.getMaxPlayersParty());
            totalPlayerCount(other.getTotalPlayerCount());
            registeredPlayerCount(other.getRegisteredPlayerCount());
            return this;
        }

        @Override
        @JsonSetter("lobby_id")
        public LobbyGroupIdStage lobbyId(UUID lobbyId) {
            this.lobbyId = lobbyId;
            return this;
        }

        @Override
        @JsonSetter("lobby_group_id")
        public LobbyGroupNameIdStage lobbyGroupId(UUID lobbyGroupId) {
            this.lobbyGroupId = lobbyGroupId;
            return this;
        }

        /**
         * <p>A human readable short identifier used to references resources. Different than a <code>rivet.common#Uuid</code> because this is intended to be human readable. Different than <code>rivet.common#DisplayName</code> because this should not include special characters and be short.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("lobby_group_name_id")
        public RegionIdStage lobbyGroupNameId(String lobbyGroupNameId) {
            this.lobbyGroupNameId = lobbyGroupNameId;
            return this;
        }

        @Override
        @JsonSetter("region_id")
        public CreateTsStage regionId(UUID regionId) {
            this.regionId = regionId;
            return this;
        }

        /**
         * <p>RFC3339 timestamp.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("create_ts")
        public IsReadyStage createTs(OffsetDateTime createTs) {
            this.createTs = createTs;
            return this;
        }

        /**
         * <p>Whether or not this lobby is ready.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("is_ready")
        public IsIdleStage isReady(boolean isReady) {
            this.isReady = isReady;
            return this;
        }

        /**
         * <p>Whether or not this lobby is idle.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("is_idle")
        public IsClosedStage isIdle(boolean isIdle) {
            this.isIdle = isIdle;
            return this;
        }

        /**
         * <p>Whether or not this lobby is in a closed state.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("is_closed")
        public IsOutdatedStage isClosed(boolean isClosed) {
            this.isClosed = isClosed;
            return this;
        }

        /**
         * <p>Whether or not this lobby is outdated.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("is_outdated")
        public MaxPlayersNormalStage isOutdated(boolean isOutdated) {
            this.isOutdated = isOutdated;
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
        public TotalPlayerCountStage maxPlayersParty(int maxPlayersParty) {
            this.maxPlayersParty = maxPlayersParty;
            return this;
        }

        /**
         * <p>Unsigned 32 bit integer.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("total_player_count")
        public RegisteredPlayerCountStage totalPlayerCount(int totalPlayerCount) {
            this.totalPlayerCount = totalPlayerCount;
            return this;
        }

        /**
         * <p>Unsigned 32 bit integer.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("registered_player_count")
        public _FinalStage registeredPlayerCount(int registeredPlayerCount) {
            this.registeredPlayerCount = registeredPlayerCount;
            return this;
        }

        @Override
        public LobbySummaryAnalytics build() {
            return new LobbySummaryAnalytics(
                    lobbyId,
                    lobbyGroupId,
                    lobbyGroupNameId,
                    regionId,
                    createTs,
                    isReady,
                    isIdle,
                    isClosed,
                    isOutdated,
                    maxPlayersNormal,
                    maxPlayersDirect,
                    maxPlayersParty,
                    totalPlayerCount,
                    registeredPlayerCount);
        }
    }
}
