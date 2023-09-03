package com.rivet.api.resources.group.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Profile.Builder.class)
public final class Profile {
    private final UUID groupId;

    private final String displayName;

    private final Optional<String> avatarUrl;

    private final ExternalLinks external;

    private final Optional<Boolean> isDeveloper;

    private final String bio;

    private final Optional<Boolean> isCurrentIdentityMember;

    private final Publicity publicity;

    private final Optional<Integer> memberCount;

    private final List<Member> members;

    private final List<JoinRequest> joinRequests;

    private final Optional<Boolean> isCurrentIdentityRequestingJoin;

    private final UUID ownerIdentityId;

    private final Optional<UUID> threadId;

    private Profile(
            UUID groupId,
            String displayName,
            Optional<String> avatarUrl,
            ExternalLinks external,
            Optional<Boolean> isDeveloper,
            String bio,
            Optional<Boolean> isCurrentIdentityMember,
            Publicity publicity,
            Optional<Integer> memberCount,
            List<Member> members,
            List<JoinRequest> joinRequests,
            Optional<Boolean> isCurrentIdentityRequestingJoin,
            UUID ownerIdentityId,
            Optional<UUID> threadId) {
        this.groupId = groupId;
        this.displayName = displayName;
        this.avatarUrl = avatarUrl;
        this.external = external;
        this.isDeveloper = isDeveloper;
        this.bio = bio;
        this.isCurrentIdentityMember = isCurrentIdentityMember;
        this.publicity = publicity;
        this.memberCount = memberCount;
        this.members = members;
        this.joinRequests = joinRequests;
        this.isCurrentIdentityRequestingJoin = isCurrentIdentityRequestingJoin;
        this.ownerIdentityId = ownerIdentityId;
        this.threadId = threadId;
    }

    @JsonProperty("group_id")
    public UUID getGroupId() {
        return groupId;
    }

    /**
     * @return Represent a resource's readable display name.
     */
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
    public Optional<Boolean> getIsDeveloper() {
        return isDeveloper;
    }

    /**
     * @return Detailed information about a profile.
     */
    @JsonProperty("bio")
    public String getBio() {
        return bio;
    }

    /**
     * @return Whether or not the current identity is a member of this group.
     */
    @JsonProperty("is_current_identity_member")
    public Optional<Boolean> getIsCurrentIdentityMember() {
        return isCurrentIdentityMember;
    }

    @JsonProperty("publicity")
    public Publicity getPublicity() {
        return publicity;
    }

    /**
     * @return Unsigned 32 bit integer.
     */
    @JsonProperty("member_count")
    public Optional<Integer> getMemberCount() {
        return memberCount;
    }

    /**
     * @return A list of group members.
     */
    @JsonProperty("members")
    public List<Member> getMembers() {
        return members;
    }

    /**
     * @return A list of group join requests.
     */
    @JsonProperty("join_requests")
    public List<JoinRequest> getJoinRequests() {
        return joinRequests;
    }

    /**
     * @return Whether or not the current identity is currently requesting to join this group.
     */
    @JsonProperty("is_current_identity_requesting_join")
    public Optional<Boolean> getIsCurrentIdentityRequestingJoin() {
        return isCurrentIdentityRequestingJoin;
    }

    @JsonProperty("owner_identity_id")
    public UUID getOwnerIdentityId() {
        return ownerIdentityId;
    }

    @JsonProperty("thread_id")
    public Optional<UUID> getThreadId() {
        return threadId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Profile && equalTo((Profile) other);
    }

    private boolean equalTo(Profile other) {
        return groupId.equals(other.groupId)
                && displayName.equals(other.displayName)
                && avatarUrl.equals(other.avatarUrl)
                && external.equals(other.external)
                && isDeveloper.equals(other.isDeveloper)
                && bio.equals(other.bio)
                && isCurrentIdentityMember.equals(other.isCurrentIdentityMember)
                && publicity.equals(other.publicity)
                && memberCount.equals(other.memberCount)
                && members.equals(other.members)
                && joinRequests.equals(other.joinRequests)
                && isCurrentIdentityRequestingJoin.equals(other.isCurrentIdentityRequestingJoin)
                && ownerIdentityId.equals(other.ownerIdentityId)
                && threadId.equals(other.threadId);
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
                this.members,
                this.joinRequests,
                this.isCurrentIdentityRequestingJoin,
                this.ownerIdentityId,
                this.threadId);
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

        Builder from(Profile other);
    }

    public interface DisplayNameStage {
        ExternalStage displayName(String displayName);
    }

    public interface ExternalStage {
        BioStage external(ExternalLinks external);
    }

    public interface BioStage {
        PublicityStage bio(String bio);
    }

    public interface PublicityStage {
        OwnerIdentityIdStage publicity(Publicity publicity);
    }

    public interface OwnerIdentityIdStage {
        _FinalStage ownerIdentityId(UUID ownerIdentityId);
    }

    public interface _FinalStage {
        Profile build();

        _FinalStage avatarUrl(Optional<String> avatarUrl);

        _FinalStage avatarUrl(String avatarUrl);

        _FinalStage isDeveloper(Optional<Boolean> isDeveloper);

        _FinalStage isDeveloper(Boolean isDeveloper);

        _FinalStage isCurrentIdentityMember(Optional<Boolean> isCurrentIdentityMember);

        _FinalStage isCurrentIdentityMember(Boolean isCurrentIdentityMember);

        _FinalStage memberCount(Optional<Integer> memberCount);

        _FinalStage memberCount(Integer memberCount);

        _FinalStage members(List<Member> members);

        _FinalStage addMembers(Member members);

        _FinalStage addAllMembers(List<Member> members);

        _FinalStage joinRequests(List<JoinRequest> joinRequests);

        _FinalStage addJoinRequests(JoinRequest joinRequests);

        _FinalStage addAllJoinRequests(List<JoinRequest> joinRequests);

        _FinalStage isCurrentIdentityRequestingJoin(Optional<Boolean> isCurrentIdentityRequestingJoin);

        _FinalStage isCurrentIdentityRequestingJoin(Boolean isCurrentIdentityRequestingJoin);

        _FinalStage threadId(Optional<UUID> threadId);

        _FinalStage threadId(UUID threadId);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements GroupIdStage,
                    DisplayNameStage,
                    ExternalStage,
                    BioStage,
                    PublicityStage,
                    OwnerIdentityIdStage,
                    _FinalStage {
        private UUID groupId;

        private String displayName;

        private ExternalLinks external;

        private String bio;

        private Publicity publicity;

        private UUID ownerIdentityId;

        private Optional<UUID> threadId = Optional.empty();

        private Optional<Boolean> isCurrentIdentityRequestingJoin = Optional.empty();

        private List<JoinRequest> joinRequests = new ArrayList<>();

        private List<Member> members = new ArrayList<>();

        private Optional<Integer> memberCount = Optional.empty();

        private Optional<Boolean> isCurrentIdentityMember = Optional.empty();

        private Optional<Boolean> isDeveloper = Optional.empty();

        private Optional<String> avatarUrl = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(Profile other) {
            groupId(other.getGroupId());
            displayName(other.getDisplayName());
            avatarUrl(other.getAvatarUrl());
            external(other.getExternal());
            isDeveloper(other.getIsDeveloper());
            bio(other.getBio());
            isCurrentIdentityMember(other.getIsCurrentIdentityMember());
            publicity(other.getPublicity());
            memberCount(other.getMemberCount());
            members(other.getMembers());
            joinRequests(other.getJoinRequests());
            isCurrentIdentityRequestingJoin(other.getIsCurrentIdentityRequestingJoin());
            ownerIdentityId(other.getOwnerIdentityId());
            threadId(other.getThreadId());
            return this;
        }

        @Override
        @JsonSetter("group_id")
        public DisplayNameStage groupId(UUID groupId) {
            this.groupId = groupId;
            return this;
        }

        /**
         * <p>Represent a resource's readable display name.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("display_name")
        public ExternalStage displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        @Override
        @JsonSetter("external")
        public BioStage external(ExternalLinks external) {
            this.external = external;
            return this;
        }

        /**
         * <p>Detailed information about a profile.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("bio")
        public PublicityStage bio(String bio) {
            this.bio = bio;
            return this;
        }

        @Override
        @JsonSetter("publicity")
        public OwnerIdentityIdStage publicity(Publicity publicity) {
            this.publicity = publicity;
            return this;
        }

        @Override
        @JsonSetter("owner_identity_id")
        public _FinalStage ownerIdentityId(UUID ownerIdentityId) {
            this.ownerIdentityId = ownerIdentityId;
            return this;
        }

        @Override
        public _FinalStage threadId(UUID threadId) {
            this.threadId = Optional.of(threadId);
            return this;
        }

        @Override
        @JsonSetter(value = "thread_id", nulls = Nulls.SKIP)
        public _FinalStage threadId(Optional<UUID> threadId) {
            this.threadId = threadId;
            return this;
        }

        /**
         * <p>Whether or not the current identity is currently requesting to join this group.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage isCurrentIdentityRequestingJoin(Boolean isCurrentIdentityRequestingJoin) {
            this.isCurrentIdentityRequestingJoin = Optional.of(isCurrentIdentityRequestingJoin);
            return this;
        }

        @Override
        @JsonSetter(value = "is_current_identity_requesting_join", nulls = Nulls.SKIP)
        public _FinalStage isCurrentIdentityRequestingJoin(Optional<Boolean> isCurrentIdentityRequestingJoin) {
            this.isCurrentIdentityRequestingJoin = isCurrentIdentityRequestingJoin;
            return this;
        }

        /**
         * <p>A list of group join requests.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllJoinRequests(List<JoinRequest> joinRequests) {
            this.joinRequests.addAll(joinRequests);
            return this;
        }

        /**
         * <p>A list of group join requests.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addJoinRequests(JoinRequest joinRequests) {
            this.joinRequests.add(joinRequests);
            return this;
        }

        @Override
        @JsonSetter(value = "join_requests", nulls = Nulls.SKIP)
        public _FinalStage joinRequests(List<JoinRequest> joinRequests) {
            this.joinRequests.clear();
            this.joinRequests.addAll(joinRequests);
            return this;
        }

        /**
         * <p>A list of group members.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllMembers(List<Member> members) {
            this.members.addAll(members);
            return this;
        }

        /**
         * <p>A list of group members.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addMembers(Member members) {
            this.members.add(members);
            return this;
        }

        @Override
        @JsonSetter(value = "members", nulls = Nulls.SKIP)
        public _FinalStage members(List<Member> members) {
            this.members.clear();
            this.members.addAll(members);
            return this;
        }

        /**
         * <p>Unsigned 32 bit integer.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage memberCount(Integer memberCount) {
            this.memberCount = Optional.of(memberCount);
            return this;
        }

        @Override
        @JsonSetter(value = "member_count", nulls = Nulls.SKIP)
        public _FinalStage memberCount(Optional<Integer> memberCount) {
            this.memberCount = memberCount;
            return this;
        }

        /**
         * <p>Whether or not the current identity is a member of this group.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage isCurrentIdentityMember(Boolean isCurrentIdentityMember) {
            this.isCurrentIdentityMember = Optional.of(isCurrentIdentityMember);
            return this;
        }

        @Override
        @JsonSetter(value = "is_current_identity_member", nulls = Nulls.SKIP)
        public _FinalStage isCurrentIdentityMember(Optional<Boolean> isCurrentIdentityMember) {
            this.isCurrentIdentityMember = isCurrentIdentityMember;
            return this;
        }

        /**
         * <p>Whether or not this group is a developer.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage isDeveloper(Boolean isDeveloper) {
            this.isDeveloper = Optional.of(isDeveloper);
            return this;
        }

        @Override
        @JsonSetter(value = "is_developer", nulls = Nulls.SKIP)
        public _FinalStage isDeveloper(Optional<Boolean> isDeveloper) {
            this.isDeveloper = isDeveloper;
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
        public Profile build() {
            return new Profile(
                    groupId,
                    displayName,
                    avatarUrl,
                    external,
                    isDeveloper,
                    bio,
                    isCurrentIdentityMember,
                    publicity,
                    memberCount,
                    members,
                    joinRequests,
                    isCurrentIdentityRequestingJoin,
                    ownerIdentityId,
                    threadId);
        }
    }
}
