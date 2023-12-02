package com.rivet.api.resources.group.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ExternalLinks.Builder.class)
public final class ExternalLinks {
    private final String profile;

    private ExternalLinks(String profile) {
        this.profile = profile;
    }

    /**
     * @return A link to this group's profile page.
     */
    @JsonProperty("profile")
    public String getProfile() {
        return profile;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ExternalLinks && equalTo((ExternalLinks) other);
    }

    private boolean equalTo(ExternalLinks other) {
        return profile.equals(other.profile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.profile);
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
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ProfileStage, _FinalStage {
        private String profile;

        private Builder() {}

        @Override
        public Builder from(ExternalLinks other) {
            profile(other.getProfile());
            return this;
        }

        /**
         * <p>A link to this group's profile page.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("profile")
        public _FinalStage profile(String profile) {
            this.profile = profile;
            return this;
        }

        @Override
        public ExternalLinks build() {
            return new ExternalLinks(profile);
        }
    }
}
