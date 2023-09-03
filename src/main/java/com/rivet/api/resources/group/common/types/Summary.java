package com.rivet.api.resources.group.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Summary.Builder.class)
public final class Summary {
    private final UUID groupId;

    private final String displayName;

    private final Optional<String> avatarUrl;

    private final ExternalLinks external;

    private final boolean isDeveloper;

    private final String bio;

    private final boolean isCurrentIdentityMember;

    private final Publicity publicity;

    private final int memberCount;

    private final UUID ownerIdentityId;

    private Summary(
            UUID groupId,
            String displayName,
            Optional<String> avatarUrl,
            ExternalLinks external,
            boolean isDeveloper,
            String bio,
            boolean isCurrentIdentityMember,
            Publicity publicity,
            int memberCount,
            UUID ownerIdentityId) {
        this.groupId = groupId;
        this.displayName = displayName;
        this.avatarUrl = avatarUrl;
        this.external = external;
        this.isDeveloper = isDeveloper;
        this.bio = bio;
        this.isCurrentIdentityMember = isCurrentIdentityMember;
        this.publicity = publicity;
        this.memberCount = memberCount;
        this.ownerIdentityId = ownerIdentityId;
    }

    @JsonProperty("group_id")
    public UUID getGroupId() {
        return groupId;
    }

    @JsonProperty("display_name")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @return The URL of this group's avatar image.
     */
    @JsonProperty("avatar_url")
    public Optional<String> getAvatarUrl() {
        return avatarUrl;
    }

    @JsonProperty("external")
    public ExternalLinks getExternal() {
        return external;
    }

    /**
     * @return Whether or not this group is a developer.
     */
    @JsonProperty("is_developer")
    public boolean getIsDeveloper() {
        return isDeveloper;
    }

    @JsonProperty("bio")
    public String getBio() {
        return bio;
    }

    /**
     * @return Whether or not the current identity is a member of this group.
     */
    @JsonProperty("is_current_identity_member")
    public boolean getIsCurrentIdentityMember() {
        return isCurrentIdentityMember;
    }

    @JsonProperty("publicity")
    public Publicity getPublicity() {
        return publicity;
    }

    @JsonProperty("member_count")
    public int getMemberCount() {
        return memberCount;
    }

    @JsonProperty("owner_identity_id")
    public UUID getOwnerIdentityId() {
        return ownerIdentityId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Summary && equalTo((Summary) other);
    }

    private boolean equalTo(Summary other) {
        return groupId.equals(other.groupId)
                && displayName.equals(other.displayName)
                && avatarUrl.equals(other.avatarUrl)
                && external.equals(other.external)
                && isDeveloper == other.isDeveloper
                && bio.equals(other.bio)
                && isCurrentIdentityMember == other.isCurrentIdentityMember
                && publicity.equals(other.publicity)
                && memberCount == other.memberCount
                && ownerIdentityId.equals(other.ownerIdentityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.groupId,
                this.displayName,
                this.avatarUrl,
                this.external,
                this.isDeveloper,
                this.bio,
                this.isCurrentIdentityMember,
                this.publicity,
                this.memberCount,
                this.ownerIdentityId);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static GroupIdStage builder() {
        return new Builder();
    }

    public interface GroupIdStage {
        DisplayNameStage groupId(UUID groupId);

        Builder from(Summary other);
    }

    public interface DisplayNameStage {
        ExternalStage displayName(String displayName);
    }

    public interface ExternalStage {
        IsDeveloperStage external(ExternalLinks external);
    }

    public interface IsDeveloperStage {
        BioStage isDeveloper(boolean isDeveloper);
    }

    public interface BioStage {
        IsCurrentIdentityMemberStage bio(String bio);
    }

    public interface IsCurrentIdentityMemberStage {
        PublicityStage isCurrentIdentityMember(boolean isCurrentIdentityMember);
    }

    public interface PublicityStage {
        MemberCountStage publicity(Publicity publicity);
    }

    public interface MemberCountStage {
        OwnerIdentityIdStage memberCount(int memberCount);
    }

    public interface OwnerIdentityIdStage {
        _FinalStage ownerIdentityId(UUID ownerIdentityId);
    }

    public interface _FinalStage {
        Summary build();

        _FinalStage avatarUrl(Optional<String> avatarUrl);

        _FinalStage avatarUrl(String avatarUrl);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements GroupIdStage,
                    DisplayNameStage,
                    ExternalStage,
                    IsDeveloperStage,
                    BioStage,
                    IsCurrentIdentityMemberStage,
                    PublicityStage,
                    MemberCountStage,
                    OwnerIdentityIdStage,
                    _FinalStage {
        private UUID groupId;

        private String displayName;

        private ExternalLinks external;

        private boolean isDeveloper;

        private String bio;

        private boolean isCurrentIdentityMember;

        private Publicity publicity;

        private int memberCount;

        private UUID ownerIdentityId;

        private Optional<String> avatarUrl = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(Summary other) {
            groupId(other.getGroupId());
            displayName(other.getDisplayName());
            avatarUrl(other.getAvatarUrl());
            external(other.getExternal());
            isDeveloper(other.getIsDeveloper());
            bio(other.getBio());
            isCurrentIdentityMember(other.getIsCurrentIdentityMember());
            publicity(other.getPublicity());
            memberCount(other.getMemberCount());
            ownerIdentityId(other.getOwnerIdentityId());
            return this;
        }

        @Override
        @JsonSetter("group_id")
        public DisplayNameStage groupId(UUID groupId) {
            this.groupId = groupId;
            return this;
        }

        @Override
        @JsonSetter("display_name")
        public ExternalStage displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        @Override
        @JsonSetter("external")
        public IsDeveloperStage external(ExternalLinks external) {
            this.external = external;
            return this;
        }

        /**
         * <p>Whether or not this group is a developer.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("is_developer")
        public BioStage isDeveloper(boolean isDeveloper) {
            this.isDeveloper = isDeveloper;
            return this;
        }

        @Override
        @JsonSetter("bio")
        public IsCurrentIdentityMemberStage bio(String bio) {
            this.bio = bio;
            return this;
        }

        /**
         * <p>Whether or not the current identity is a member of this group.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("is_current_identity_member")
        public PublicityStage isCurrentIdentityMember(boolean isCurrentIdentityMember) {
            this.isCurrentIdentityMember = isCurrentIdentityMember;
            return this;
        }

        @Override
        @JsonSetter("publicity")
        public MemberCountStage publicity(Publicity publicity) {
            this.publicity = publicity;
            return this;
        }

        @Override
        @JsonSetter("member_count")
        public OwnerIdentityIdStage memberCount(int memberCount) {
            this.memberCount = memberCount;
            return this;
        }

        @Override
        @JsonSetter("owner_identity_id")
        public _FinalStage ownerIdentityId(UUID ownerIdentityId) {
            this.ownerIdentityId = ownerIdentityId;
            return this;
        }

        /**
         * <p>The URL of this group's avatar image.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage avatarUrl(String avatarUrl) {
            this.avatarUrl = Optional.of(avatarUrl);
            return this;
        }

        @Override
        @JsonSetter(value = "avatar_url", nulls = Nulls.SKIP)
        public _FinalStage avatarUrl(Optional<String> avatarUrl) {
            this.avatarUrl = avatarUrl;
            return this;
        }

        @Override
        public Summary build() {
            return new Summary(
                    groupId,
                    displayName,
                    avatarUrl,
                    external,
                    isDeveloper,
                    bio,
                    isCurrentIdentityMember,
                    publicity,
                    memberCount,
                    ownerIdentityId);
        }
    }
}
