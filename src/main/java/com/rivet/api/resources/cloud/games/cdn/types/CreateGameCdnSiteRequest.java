package com.rivet.api.resources.cloud.games.cdn.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.upload.common.types.PrepareFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CreateGameCdnSiteRequest.Builder.class)
public final class CreateGameCdnSiteRequest {
    private final String displayName;

    private final List<PrepareFile> files;

    private CreateGameCdnSiteRequest(String displayName, List<PrepareFile> files) {
        this.displayName = displayName;
        this.files = files;
    }

    /**
     * @return Represent a resource's readable display name.
     */
    @JsonProperty("display_name")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @return A list of files preparing to upload.
     */
    @JsonProperty("files")
    public List<PrepareFile> getFiles() {
        return files;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateGameCdnSiteRequest && equalTo((CreateGameCdnSiteRequest) other);
    }

    private boolean equalTo(CreateGameCdnSiteRequest other) {
        return displayName.equals(other.displayName) && files.equals(other.files);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.displayName, this.files);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static DisplayNameStage builder() {
        return new Builder();
    }

    public interface DisplayNameStage {
        _FinalStage displayName(String displayName);

        Builder from(CreateGameCdnSiteRequest other);
    }

    public interface _FinalStage {
        CreateGameCdnSiteRequest build();

        _FinalStage files(List<PrepareFile> files);

        _FinalStage addFiles(PrepareFile files);

        _FinalStage addAllFiles(List<PrepareFile> files);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements DisplayNameStage, _FinalStage {
        private String displayName;

        private List<PrepareFile> files = new ArrayList<>();

        private Builder() {}

        @Override
        public Builder from(CreateGameCdnSiteRequest other) {
            displayName(other.getDisplayName());
            files(other.getFiles());
            return this;
        }

        /**
         * <p>Represent a resource's readable display name.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("display_name")
        public _FinalStage displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        /**
         * <p>A list of files preparing to upload.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllFiles(List<PrepareFile> files) {
            this.files.addAll(files);
            return this;
        }

        /**
         * <p>A list of files preparing to upload.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addFiles(PrepareFile files) {
            this.files.add(files);
            return this;
        }

        @Override
        @JsonSetter(value = "files", nulls = Nulls.SKIP)
        public _FinalStage files(List<PrepareFile> files) {
            this.files.clear();
            this.files.addAll(files);
            return this;
        }

        @Override
        public CreateGameCdnSiteRequest build() {
            return new CreateGameCdnSiteRequest(displayName, files);
        }
    }
}
