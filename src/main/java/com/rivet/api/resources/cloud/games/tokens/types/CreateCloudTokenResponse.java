package com.rivet.api.resources.cloud.games.tokens.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CreateCloudTokenResponse.Builder.class)
public final class CreateCloudTokenResponse {
    private final String token;

    private CreateCloudTokenResponse(String token) {
        this.token = token;
    }

    /**
     * @return A JSON Web Token.
     * Slightly modified to include a description prefix and use Protobufs of
     * JSON.
     */
    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateCloudTokenResponse && equalTo((CreateCloudTokenResponse) other);
    }

    private boolean equalTo(CreateCloudTokenResponse other) {
        return token.equals(other.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.token);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TokenStage builder() {
        return new Builder();
    }

    public interface TokenStage {
        _FinalStage token(String token);

        Builder from(CreateCloudTokenResponse other);
    }

    public interface _FinalStage {
        CreateCloudTokenResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TokenStage, _FinalStage {
        private String token;

        private Builder() {}

        @Override
        public Builder from(CreateCloudTokenResponse other) {
            token(other.getToken());
            return this;
        }

        /**
         * <p>A JSON Web Token.
         * Slightly modified to include a description prefix and use Protobufs of
         * JSON.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("token")
        public _FinalStage token(String token) {
            this.token = token;
            return this;
        }

        @Override
        public CreateCloudTokenResponse build() {
            return new CreateCloudTokenResponse(token);
        }
    }
}
