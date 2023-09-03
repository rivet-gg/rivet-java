package com.rivet.api.resources.cloud.version.identity.pacakge.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Config.Builder.class)
public final class Config {
    private final Optional<List<String>> displayNames;

    private final Optional<List<UUID>> avatars;

    private final Optional<List<CustomDisplayName>> customDisplayNames;

    private final Optional<List<CustomAvatar>> customAvatars;

    private Config(
            Optional<List<String>> displayNames,
            Optional<List<UUID>> avatars,
            Optional<List<CustomDisplayName>> customDisplayNames,
            Optional<List<CustomAvatar>> customAvatars) {
        this.displayNames = displayNames;
        this.avatars = avatars;
        this.customDisplayNames = customDisplayNames;
        this.customAvatars = customAvatars;
    }

    @JsonProperty("display_names")
    public Optional<List<String>> getDisplayNames() {
        return displayNames;
    }

    @JsonProperty("avatars")
    public Optional<List<UUID>> getAvatars() {
        return avatars;
    }

    /**
     * @return <strong>Deprecated</strong>
     */
    @JsonProperty("custom_display_names")
    public Optional<List<CustomDisplayName>> getCustomDisplayNames() {
        return customDisplayNames;
    }

    /**
     * @return <strong>Deprecated</strong>
     */
    @JsonProperty("custom_avatars")
    public Optional<List<CustomAvatar>> getCustomAvatars() {
        return customAvatars;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Config && equalTo((Config) other);
    }

    private boolean equalTo(Config other) {
        return displayNames.equals(other.displayNames)
                && avatars.equals(other.avatars)
                && customDisplayNames.equals(other.customDisplayNames)
                && customAvatars.equals(other.customAvatars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.displayNames, this.avatars, this.customDisplayNames, this.customAvatars);
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
        private Optional<List<String>> displayNames = Optional.empty();

        private Optional<List<UUID>> avatars = Optional.empty();

        private Optional<List<CustomDisplayName>> customDisplayNames = Optional.empty();

        private Optional<List<CustomAvatar>> customAvatars = Optional.empty();

        private Builder() {}

        public Builder from(Config other) {
            displayNames(other.getDisplayNames());
            avatars(other.getAvatars());
            customDisplayNames(other.getCustomDisplayNames());
            customAvatars(other.getCustomAvatars());
            return this;
        }

        @JsonSetter(value = "display_names", nulls = Nulls.SKIP)
        public Builder displayNames(Optional<List<String>> displayNames) {
            this.displayNames = displayNames;
            return this;
        }

        public Builder displayNames(List<String> displayNames) {
            this.displayNames = Optional.of(displayNames);
            return this;
        }

        @JsonSetter(value = "avatars", nulls = Nulls.SKIP)
        public Builder avatars(Optional<List<UUID>> avatars) {
            this.avatars = avatars;
            return this;
        }

        public Builder avatars(List<UUID> avatars) {
            this.avatars = Optional.of(avatars);
            return this;
        }

        @JsonSetter(value = "custom_display_names", nulls = Nulls.SKIP)
        public Builder customDisplayNames(Optional<List<CustomDisplayName>> customDisplayNames) {
            this.customDisplayNames = customDisplayNames;
            return this;
        }

        public Builder customDisplayNames(List<CustomDisplayName> customDisplayNames) {
            this.customDisplayNames = Optional.of(customDisplayNames);
            return this;
        }

        @JsonSetter(value = "custom_avatars", nulls = Nulls.SKIP)
        public Builder customAvatars(Optional<List<CustomAvatar>> customAvatars) {
            this.customAvatars = customAvatars;
            return this;
        }

        public Builder customAvatars(List<CustomAvatar> customAvatars) {
            this.customAvatars = Optional.of(customAvatars);
            return this;
        }

        public Config build() {
            return new Config(displayNames, avatars, customDisplayNames, customAvatars);
        }
    }
}
