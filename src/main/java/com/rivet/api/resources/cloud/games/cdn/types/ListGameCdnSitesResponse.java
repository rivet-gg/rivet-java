package com.rivet.api.resources.cloud.games.cdn.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.cloud.common.types.CdnSiteSummary;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ListGameCdnSitesResponse.Builder.class)
public final class ListGameCdnSitesResponse {
    private final List<CdnSiteSummary> sites;

    private ListGameCdnSitesResponse(List<CdnSiteSummary> sites) {
        this.sites = sites;
    }

    /**
     * @return A list of CDN site summaries.
     */
    @JsonProperty("sites")
    public List<CdnSiteSummary> getSites() {
        return sites;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ListGameCdnSitesResponse && equalTo((ListGameCdnSitesResponse) other);
    }

    private boolean equalTo(ListGameCdnSitesResponse other) {
        return sites.equals(other.sites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.sites);
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
        private List<CdnSiteSummary> sites = new ArrayList<>();

        private Builder() {}

        public Builder from(ListGameCdnSitesResponse other) {
            sites(other.getSites());
            return this;
        }

        @JsonSetter(value = "sites", nulls = Nulls.SKIP)
        public Builder sites(List<CdnSiteSummary> sites) {
            this.sites.clear();
            this.sites.addAll(sites);
            return this;
        }

        public Builder addSites(CdnSiteSummary sites) {
            this.sites.add(sites);
            return this;
        }

        public Builder addAllSites(List<CdnSiteSummary> sites) {
            this.sites.addAll(sites);
            return this;
        }

        public ListGameCdnSitesResponse build() {
            return new ListGameCdnSitesResponse(sites);
        }
    }
}
