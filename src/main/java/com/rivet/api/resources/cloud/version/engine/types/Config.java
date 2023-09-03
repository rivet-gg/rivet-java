package com.rivet.api.resources.cloud.version.engine.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.cloud.version.engine.godot.types.GodotConfig;
import com.rivet.api.resources.cloud.version.engine.html5.types.Html5Config;
import com.rivet.api.resources.cloud.version.engine.unity.types.UnityConfig;
import com.rivet.api.resources.cloud.version.engine.unreal.types.UnrealConfig;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Config.Builder.class)
public final class Config {
    private final Optional<UnityConfig> unity;

    private final Optional<UnrealConfig> unreal;

    private final Optional<GodotConfig> godot;

    private final Optional<Html5Config> html5;

    private Config(
            Optional<UnityConfig> unity,
            Optional<UnrealConfig> unreal,
            Optional<GodotConfig> godot,
            Optional<Html5Config> html5) {
        this.unity = unity;
        this.unreal = unreal;
        this.godot = godot;
        this.html5 = html5;
    }

    @JsonProperty("unity")
    public Optional<UnityConfig> getUnity() {
        return unity;
    }

    @JsonProperty("unreal")
    public Optional<UnrealConfig> getUnreal() {
        return unreal;
    }

    @JsonProperty("godot")
    public Optional<GodotConfig> getGodot() {
        return godot;
    }

    @JsonProperty("html5")
    public Optional<Html5Config> getHtml5() {
        return html5;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Config && equalTo((Config) other);
    }

    private boolean equalTo(Config other) {
        return unity.equals(other.unity)
                && unreal.equals(other.unreal)
                && godot.equals(other.godot)
                && html5.equals(other.html5);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.unity, this.unreal, this.godot, this.html5);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<UnityConfig> unity = Optional.empty();

        private Optional<UnrealConfig> unreal = Optional.empty();

        private Optional<GodotConfig> godot = Optional.empty();

        private Optional<Html5Config> html5 = Optional.empty();

        private Builder() {}

        public Builder from(Config other) {
            unity(other.getUnity());
            unreal(other.getUnreal());
            godot(other.getGodot());
            html5(other.getHtml5());
            return this;
        }

        @JsonSetter(value = "unity", nulls = Nulls.SKIP)
        public Builder unity(Optional<UnityConfig> unity) {
            this.unity = unity;
            return this;
        }

        public Builder unity(UnityConfig unity) {
            this.unity = Optional.of(unity);
            return this;
        }

        @JsonSetter(value = "unreal", nulls = Nulls.SKIP)
        public Builder unreal(Optional<UnrealConfig> unreal) {
            this.unreal = unreal;
            return this;
        }

        public Builder unreal(UnrealConfig unreal) {
            this.unreal = Optional.of(unreal);
            return this;
        }

        @JsonSetter(value = "godot", nulls = Nulls.SKIP)
        public Builder godot(Optional<GodotConfig> godot) {
            this.godot = godot;
            return this;
        }

        public Builder godot(GodotConfig godot) {
            this.godot = Optional.of(godot);
            return this;
        }

        @JsonSetter(value = "html5", nulls = Nulls.SKIP)
        public Builder html5(Optional<Html5Config> html5) {
            this.html5 = html5;
            return this;
        }

        public Builder html5(Html5Config html5) {
            this.html5 = Optional.of(html5);
            return this;
        }

        public Config build() {
            return new Config(unity, unreal, godot, html5);
        }
    }
}
