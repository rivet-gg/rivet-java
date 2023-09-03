package com.rivet.api.resources.identity.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ExternalLinks.Builder.class)
public final class ExternalLinks {
    private final String profile;

    private final Optional<String> settings;

    private final Optional<String> chat;

    private ExternalLinks(String profile, Optional<String> settings, Optional<String> chat) {
        this.profile = profile;
        this.settings = settings;
        this.chat = chat;
    }

    /**
     * @return A link to this identity's profile page.
     */
    @JsonProperty("profile")
    public String getProfile() {
        return profile;
    }

    /**
     * @return A link to the Rivet settings page.
     */
    @JsonProperty("settings")
    public Optional<String> getSettings() {
        return settings;
    }

    /**
     * @return A link to a chat page with the given identity.
     */
    @JsonProperty("chat")
    public Optional<String> getChat() {
        return chat;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ExternalLinks && equalTo((ExternalLinks) other);
    }

    private boolean equalTo(ExternalLinks other) {
        return profile.equals(other.profile) && settings.equals(other.settings) && chat.equals(other.chat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.profile, this.settings, this.chat);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ProfileStage builder() {
        return new Builder();
    }

    public interface ProfileStage {
        _FinalStage profile(String profile);

        Builder from(ExternalLinks other);
    }

    public interface _FinalStage {
        ExternalLinks build();

        _FinalStage settings(Optional<String> settings);

        _FinalStage settings(String settings);

        _FinalStage chat(Optional<String> chat);

        _FinalStage chat(String chat);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ProfileStage, _FinalStage {
        private String profile;

        private Optional<String> chat = Optional.empty();

        private Optional<String> settings = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(ExternalLinks other) {
            profile(other.getProfile());
            settings(other.getSettings());
            chat(other.getChat());
            return this;
        }

        /**
         * <p>A link to this identity's profile page.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("profile")
        public _FinalStage profile(String profile) {
            this.profile = profile;
            return this;
        }

        /**
         * <p>A link to a chat page with the given identity.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage chat(String chat) {
            this.chat = Optional.of(chat);
            return this;
        }

        @Override
        @JsonSetter(value = "chat", nulls = Nulls.SKIP)
        public _FinalStage chat(Optional<String> chat) {
            this.chat = chat;
            return this;
        }

        /**
         * <p>A link to the Rivet settings page.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage settings(String settings) {
            this.settings = Optional.of(settings);
            return this;
        }

        @Override
        @JsonSetter(value = "settings", nulls = Nulls.SKIP)
        public _FinalStage settings(Optional<String> settings) {
            this.settings = settings;
            return this;
        }

        @Override
        public ExternalLinks build() {
            return new ExternalLinks(profile, settings, chat);
        }
    }
}
