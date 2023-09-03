package com.rivet.api.resources.kv.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.kv.common.types.PutEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = PutBatchRequest.Builder.class)
public final class PutBatchRequest {
    private final Optional<UUID> namespaceId;

    private final List<PutEntry> entries;

    private PutBatchRequest(Optional<UUID> namespaceId, List<PutEntry> entries) {
        this.namespaceId = namespaceId;
        this.entries = entries;
    }

    @JsonProperty("namespace_id")
    public Optional<UUID> getNamespaceId() {
        return namespaceId;
    }

    @JsonProperty("entries")
    public List<PutEntry> getEntries() {
        return entries;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PutBatchRequest && equalTo((PutBatchRequest) other);
    }

    private boolean equalTo(PutBatchRequest other) {
        return namespaceId.equals(other.namespaceId) && entries.equals(other.entries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.namespaceId, this.entries);
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
        private Optional<UUID> namespaceId = Optional.empty();

        private List<PutEntry> entries = new ArrayList<>();

        private Builder() {}

        public Builder from(PutBatchRequest other) {
            namespaceId(other.getNamespaceId());
            entries(other.getEntries());
            return this;
        }

        @JsonSetter(value = "namespace_id", nulls = Nulls.SKIP)
        public Builder namespaceId(Optional<UUID> namespaceId) {
            this.namespaceId = namespaceId;
            return this;
        }

        public Builder namespaceId(UUID namespaceId) {
            this.namespaceId = Optional.of(namespaceId);
            return this;
        }

        @JsonSetter(value = "entries", nulls = Nulls.SKIP)
        public Builder entries(List<PutEntry> entries) {
            this.entries.clear();
            this.entries.addAll(entries);
            return this;
        }

        public Builder addEntries(PutEntry entries) {
            this.entries.add(entries);
            return this;
        }

        public Builder addAllEntries(List<PutEntry> entries) {
            this.entries.addAll(entries);
            return this;
        }

        public PutBatchRequest build() {
            return new PutBatchRequest(namespaceId, entries);
        }
    }
}
