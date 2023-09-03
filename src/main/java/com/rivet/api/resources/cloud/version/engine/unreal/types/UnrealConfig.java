package com.rivet.api.resources.cloud.version.engine.unreal.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UnrealConfig.Builder.class)
public final class UnrealConfig {
    private final String gameModule;

    private UnrealConfig(String gameModule) {
        this.gameModule = gameModule;
    }

    /**
     * @return Name of the Unreal module that holds the game code.
     * This is usually the value of <code>$.Modules[0].Name</code> in the file <code>MyProject.unproject</code>.
     * <em>Configures Rivet CLI behavior. Has no effect on server behavior.</em>
     */
    @JsonProperty("game_module")
    public String getGameModule() {
        return gameModule;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UnrealConfig && equalTo((UnrealConfig) other);
    }

    private boolean equalTo(UnrealConfig other) {
        return gameModule.equals(other.gameModule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.gameModule);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static GameModuleStage builder() {
        return new Builder();
    }

    public interface GameModuleStage {
        _FinalStage gameModule(String gameModule);

        Builder from(UnrealConfig other);
    }

    public interface _FinalStage {
        UnrealConfig build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements GameModuleStage, _FinalStage {
        private String gameModule;

        private Builder() {}

        @Override
        public Builder from(UnrealConfig other) {
            gameModule(other.getGameModule());
            return this;
        }

        /**
         * <p>Name of the Unreal module that holds the game code.
         * This is usually the value of <code>$.Modules[0].Name</code> in the file <code>MyProject.unproject</code>.
         * <em>Configures Rivet CLI behavior. Has no effect on server behavior.</em></p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("game_module")
        public _FinalStage gameModule(String gameModule) {
            this.gameModule = gameModule;
            return this;
        }

        @Override
        public UnrealConfig build() {
            return new UnrealConfig(gameModule);
        }
    }
}
