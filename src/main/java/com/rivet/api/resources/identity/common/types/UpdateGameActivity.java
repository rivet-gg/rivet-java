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
@JsonDeserialize(builder = UpdateGameActivity.Builder.class)
public final class UpdateGameActivity {
    private final Optional<String> message;

    private final Optional<Object> publicMetadata;

    private final Optional<Object> mutualMetadata;

    private UpdateGameActivity(
            Optional<String> message, Optional<Object> publicMetadata, Optional<Object> mutualMetadata) {
        this.message = message;
        this.publicMetadata = publicMetadata;
        this.mutualMetadata = mutualMetadata;
    }

    /**
     * @return A short message about the current game activity.
     */
    @JsonProperty("message")
    public Optional<String> getMessage() {
        return message;
    }

    /**
     * @return JSON data seen by anyone.
     */
    @JsonProperty("public_metadata")
    public Optional<Object> getPublicMetadata() {
        return publicMetadata;
    }

    /**
     * @return JSON data seen only by the given identity and their mutual followers.
     */
    @JsonProperty("mutual_metadata")
    public Optional<Object> getMutualMetadata() {
        return mutualMetadata;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdateGameActivity && equalTo((UpdateGameActivity) other);
    }

    private boolean equalTo(UpdateGameActivity other) {
        return message.equals(other.message)
                && publicMetadata.equals(other.publicMetadata)
                && mutualMetadata.equals(other.mutualMetadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.message, this.publicMetadata, this.mutualMetadata);
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
        private Optional<String> message = Optional.empty();

        private Optional<Object> publicMetadata = Optional.empty();

        private Optional<Object> mutualMetadata = Optional.empty();

        private Builder() {}

        public Builder from(UpdateGameActivity other) {
            message(other.getMessage());
            publicMetadata(other.getPublicMetadata());
            mutualMetadata(other.getMutualMetadata());
            return this;
        }

        @JsonSetter(value = "message", nulls = Nulls.SKIP)
        public Builder message(Optional<String> message) {
            this.message = message;
            return this;
        }

        public Builder message(String message) {
            this.message = Optional.of(message);
            return this;
        }

        @JsonSetter(value = "public_metadata", nulls = Nulls.SKIP)
        public Builder publicMetadata(Optional<Object> publicMetadata) {
            this.publicMetadata = publicMetadata;
            return this;
        }

        public Builder publicMetadata(Object publicMetadata) {
            this.publicMetadata = Optional.of(publicMetadata);
            return this;
        }

        @JsonSetter(value = "mutual_metadata", nulls = Nulls.SKIP)
        public Builder mutualMetadata(Optional<Object> mutualMetadata) {
            this.mutualMetadata = mutualMetadata;
            return this;
        }

        public Builder mutualMetadata(Object mutualMetadata) {
            this.mutualMetadata = Optional.of(mutualMetadata);
            return this;
        }

        public UpdateGameActivity build() {
            return new UpdateGameActivity(message, publicMetadata, mutualMetadata);
        }
    }
}
