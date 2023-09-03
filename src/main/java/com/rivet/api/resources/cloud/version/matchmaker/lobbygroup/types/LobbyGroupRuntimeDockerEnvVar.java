package com.rivet.api.resources.cloud.version.matchmaker.lobbygroup.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = LobbyGroupRuntimeDockerEnvVar.Builder.class)
public final class LobbyGroupRuntimeDockerEnvVar {
    private final String key;

    private final String value;

    private LobbyGroupRuntimeDockerEnvVar(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LobbyGroupRuntimeDockerEnvVar && equalTo((LobbyGroupRuntimeDockerEnvVar) other);
    }

    private boolean equalTo(LobbyGroupRuntimeDockerEnvVar other) {
        return key.equals(other.key) && value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.key, this.value);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static KeyStage builder() {
        return new Builder();
    }

    public interface KeyStage {
        ValueStage key(String key);

        Builder from(LobbyGroupRuntimeDockerEnvVar other);
    }

    public interface ValueStage {
        _FinalStage value(String value);
    }

    public interface _FinalStage {
        LobbyGroupRuntimeDockerEnvVar build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements KeyStage, ValueStage, _FinalStage {
        private String key;

        private String value;

        private Builder() {}

        @Override
        public Builder from(LobbyGroupRuntimeDockerEnvVar other) {
            key(other.getKey());
            value(other.getValue());
            return this;
        }

        @Override
        @JsonSetter("key")
        public ValueStage key(String key) {
            this.key = key;
            return this;
        }

        @Override
        @JsonSetter("value")
        public _FinalStage value(String value) {
            this.value = value;
            return this;
        }

        @Override
        public LobbyGroupRuntimeDockerEnvVar build() {
            return new LobbyGroupRuntimeDockerEnvVar(key, value);
        }
    }
}
