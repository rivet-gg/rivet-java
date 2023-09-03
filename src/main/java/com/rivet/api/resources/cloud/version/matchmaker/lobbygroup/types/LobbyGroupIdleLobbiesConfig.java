package com.rivet.api.resources.cloud.version.matchmaker.lobbygroup.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = LobbyGroupIdleLobbiesConfig.Builder.class)
public final class LobbyGroupIdleLobbiesConfig {
    private final int minIdleLobbies;

    private final int maxIdleLobbies;

    private LobbyGroupIdleLobbiesConfig(int minIdleLobbies, int maxIdleLobbies) {
        this.minIdleLobbies = minIdleLobbies;
        this.maxIdleLobbies = maxIdleLobbies;
    }

    /**
     * @return Unsigned 32 bit integer.
     */
    @JsonProperty("min_idle_lobbies")
    public int getMinIdleLobbies() {
        return minIdleLobbies;
    }

    /**
     * @return Unsigned 32 bit integer.
     */
    @JsonProperty("max_idle_lobbies")
    public int getMaxIdleLobbies() {
        return maxIdleLobbies;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LobbyGroupIdleLobbiesConfig && equalTo((LobbyGroupIdleLobbiesConfig) other);
    }

    private boolean equalTo(LobbyGroupIdleLobbiesConfig other) {
        return minIdleLobbies == other.minIdleLobbies && maxIdleLobbies == other.maxIdleLobbies;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.minIdleLobbies, this.maxIdleLobbies);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static MinIdleLobbiesStage builder() {
        return new Builder();
    }

    public interface MinIdleLobbiesStage {
        MaxIdleLobbiesStage minIdleLobbies(int minIdleLobbies);

        Builder from(LobbyGroupIdleLobbiesConfig other);
    }

    public interface MaxIdleLobbiesStage {
        _FinalStage maxIdleLobbies(int maxIdleLobbies);
    }

    public interface _FinalStage {
        LobbyGroupIdleLobbiesConfig build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements MinIdleLobbiesStage, MaxIdleLobbiesStage, _FinalStage {
        private int minIdleLobbies;

        private int maxIdleLobbies;

        private Builder() {}

        @Override
        public Builder from(LobbyGroupIdleLobbiesConfig other) {
            minIdleLobbies(other.getMinIdleLobbies());
            maxIdleLobbies(other.getMaxIdleLobbies());
            return this;
        }

        /**
         * <p>Unsigned 32 bit integer.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("min_idle_lobbies")
        public MaxIdleLobbiesStage minIdleLobbies(int minIdleLobbies) {
            this.minIdleLobbies = minIdleLobbies;
            return this;
        }

        /**
         * <p>Unsigned 32 bit integer.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("max_idle_lobbies")
        public _FinalStage maxIdleLobbies(int maxIdleLobbies) {
            this.maxIdleLobbies = maxIdleLobbies;
            return this;
        }

        @Override
        public LobbyGroupIdleLobbiesConfig build() {
            return new LobbyGroupIdleLobbiesConfig(minIdleLobbies, maxIdleLobbies);
        }
    }
}
