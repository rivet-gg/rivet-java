package com.rivet.api.resources.common.types;

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
@JsonDeserialize(builder = ErrorBody.Builder.class)
public final class ErrorBody {
    private final String code;

    private final String message;

    private final Optional<String> documentation;

    private final Optional<Object> metadata;

    private ErrorBody(String code, String message, Optional<String> documentation, Optional<Object> metadata) {
        this.code = code;
        this.message = message;
        this.documentation = documentation;
        this.metadata = metadata;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("documentation")
    public Optional<String> getDocumentation() {
        return documentation;
    }

    @JsonProperty("metadata")
    public Optional<Object> getMetadata() {
        return metadata;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ErrorBody && equalTo((ErrorBody) other);
    }

    private boolean equalTo(ErrorBody other) {
        return code.equals(other.code)
                && message.equals(other.message)
                && documentation.equals(other.documentation)
                && metadata.equals(other.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.code, this.message, this.documentation, this.metadata);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static CodeStage builder() {
        return new Builder();
    }

    public interface CodeStage {
        MessageStage code(String code);

        Builder from(ErrorBody other);
    }

    public interface MessageStage {
        _FinalStage message(String message);
    }

    public interface _FinalStage {
        ErrorBody build();

        _FinalStage documentation(Optional<String> documentation);

        _FinalStage documentation(String documentation);

        _FinalStage metadata(Optional<Object> metadata);

        _FinalStage metadata(Object metadata);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements CodeStage, MessageStage, _FinalStage {
        private String code;

        private String message;

        private Optional<Object> metadata = Optional.empty();

        private Optional<String> documentation = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(ErrorBody other) {
            code(other.getCode());
            message(other.getMessage());
            documentation(other.getDocumentation());
            metadata(other.getMetadata());
            return this;
        }

        @Override
        @JsonSetter("code")
        public MessageStage code(String code) {
            this.code = code;
            return this;
        }

        @Override
        @JsonSetter("message")
        public _FinalStage message(String message) {
            this.message = message;
            return this;
        }

        @Override
        public _FinalStage metadata(Object metadata) {
            this.metadata = Optional.of(metadata);
            return this;
        }

        @Override
        @JsonSetter(value = "metadata", nulls = Nulls.SKIP)
        public _FinalStage metadata(Optional<Object> metadata) {
            this.metadata = metadata;
            return this;
        }

        @Override
        public _FinalStage documentation(String documentation) {
            this.documentation = Optional.of(documentation);
            return this;
        }

        @Override
        @JsonSetter(value = "documentation", nulls = Nulls.SKIP)
        public _FinalStage documentation(Optional<String> documentation) {
            this.documentation = documentation;
            return this;
        }

        @Override
        public ErrorBody build() {
            return new ErrorBody(code, message, documentation, metadata);
        }
    }
}
