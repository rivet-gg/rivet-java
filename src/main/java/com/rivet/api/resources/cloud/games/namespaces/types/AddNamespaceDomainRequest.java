package com.rivet.api.resources.cloud.games.namespaces.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AddNamespaceDomainRequest.Builder.class)
public final class AddNamespaceDomainRequest {
    private final String domain;

    private AddNamespaceDomainRequest(String domain) {
        this.domain = domain;
    }

    /**
     * @return A valid domain name (no protocol).
     */
    @JsonProperty("domain")
    public String getDomain() {
        return domain;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AddNamespaceDomainRequest && equalTo((AddNamespaceDomainRequest) other);
    }

    private boolean equalTo(AddNamespaceDomainRequest other) {
        return domain.equals(other.domain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.domain);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static DomainStage builder() {
        return new Builder();
    }

    public interface DomainStage {
        _FinalStage domain(String domain);

        Builder from(AddNamespaceDomainRequest other);
    }

    public interface _FinalStage {
        AddNamespaceDomainRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements DomainStage, _FinalStage {
        private String domain;

        private Builder() {}

        @Override
        public Builder from(AddNamespaceDomainRequest other) {
            domain(other.getDomain());
            return this;
        }

        /**
         * <p>A valid domain name (no protocol).</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("domain")
        public _FinalStage domain(String domain) {
            this.domain = domain;
            return this;
        }

        @Override
        public AddNamespaceDomainRequest build() {
            return new AddNamespaceDomainRequest(domain);
        }
    }
}
