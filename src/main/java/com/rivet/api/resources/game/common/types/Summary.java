package com.rivet.api.resources.game.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.group.common.types.Handle;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Summary.Builder.class)
public final class Summary {
    private final UUID gameId;

    private final String nameId;

    private final String displayName;

    private final Optional<String> logoUrl;

    private final Optional<String> bannerUrl;

    private final String url;

    private final Handle developer;

    private final int totalPlayerCount;

    private Summary(
            UUID gameId,
            String nameId,
            String displayName,
            Optional<String> logoUrl,
            Optional<String> bannerUrl,
            String url,
            Handle developer,
            int totalPlayerCount) {
        this.gameId = gameId;
        this.nameId = nameId;
        this.displayName = displayName;
        this.logoUrl = logoUrl;
        this.bannerUrl = bannerUrl;
        this.url = url;
        this.developer = developer;
        this.totalPlayerCount = totalPlayerCount;
    }

    @JsonProperty("game_id")
    public UUID getGameId() {
        return gameId;
    }

    @JsonProperty("name_id")
    public String getNameId() {
        return nameId;
    }

    @JsonProperty("display_name")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @return The URL of this game's logo image.
     */
    @JsonProperty("logo_url")
    public Optional<String> getLogoUrl() {
        return logoUrl;
    }

    /**
     * @return The URL of this game's banner image.
     */
    @JsonProperty("banner_url")
    public Optional<String> getBannerUrl() {
        return bannerUrl;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("developer")
    public Handle getDeveloper() {
        return developer;
    }

    /**
     * @return Unsigned 32 bit integer.
     */
    @JsonProperty("total_player_count")
    public int getTotalPlayerCount() {
        return totalPlayerCount;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Summary && equalTo((Summary) other);
    }

    private boolean equalTo(Summary other) {
        return gameId.equals(other.gameId)
                && nameId.equals(other.nameId)
                && displayName.equals(other.displayName)
                && logoUrl.equals(other.logoUrl)
                && bannerUrl.equals(other.bannerUrl)
                && url.equals(other.url)
                && developer.equals(other.developer)
                && totalPlayerCount == other.totalPlayerCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.gameId,
                this.nameId,
                this.displayName,
                this.logoUrl,
                this.bannerUrl,
                this.url,
                this.developer,
                this.totalPlayerCount);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static GameIdStage builder() {
        return new Builder();
    }

    public interface GameIdStage {
        NameIdStage gameId(UUID gameId);

        Builder from(Summary other);
    }

    public interface NameIdStage {
        DisplayNameStage nameId(String nameId);
    }

    public interface DisplayNameStage {
        UrlStage displayName(String displayName);
    }

    public interface UrlStage {
        DeveloperStage url(String url);
    }

    public interface DeveloperStage {
        TotalPlayerCountStage developer(Handle developer);
    }

    public interface TotalPlayerCountStage {
        _FinalStage totalPlayerCount(int totalPlayerCount);
    }

    public interface _FinalStage {
        Summary build();

        _FinalStage logoUrl(Optional<String> logoUrl);

        _FinalStage logoUrl(String logoUrl);

        _FinalStage bannerUrl(Optional<String> bannerUrl);

        _FinalStage bannerUrl(String bannerUrl);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements GameIdStage,
                    NameIdStage,
                    DisplayNameStage,
                    UrlStage,
                    DeveloperStage,
                    TotalPlayerCountStage,
                    _FinalStage {
        private UUID gameId;

        private String nameId;

        private String displayName;

        private String url;

        private Handle developer;

        private int totalPlayerCount;

        private Optional<String> bannerUrl = Optional.empty();

        private Optional<String> logoUrl = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(Summary other) {
            gameId(other.getGameId());
            nameId(other.getNameId());
            displayName(other.getDisplayName());
            logoUrl(other.getLogoUrl());
            bannerUrl(other.getBannerUrl());
            url(other.getUrl());
            developer(other.getDeveloper());
            totalPlayerCount(other.getTotalPlayerCount());
            return this;
        }

        @Override
        @JsonSetter("game_id")
        public NameIdStage gameId(UUID gameId) {
            this.gameId = gameId;
            return this;
        }

        @Override
        @JsonSetter("name_id")
        public DisplayNameStage nameId(String nameId) {
            this.nameId = nameId;
            return this;
        }

        @Override
        @JsonSetter("display_name")
        public UrlStage displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        @Override
        @JsonSetter("url")
        public DeveloperStage url(String url) {
            this.url = url;
            return this;
        }

        @Override
        @JsonSetter("developer")
        public TotalPlayerCountStage developer(Handle developer) {
            this.developer = developer;
            return this;
        }

        /**
         * <p>Unsigned 32 bit integer.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("total_player_count")
        public _FinalStage totalPlayerCount(int totalPlayerCount) {
            this.totalPlayerCount = totalPlayerCount;
            return this;
        }

        /**
         * <p>The URL of this game's banner image.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage bannerUrl(String bannerUrl) {
            this.bannerUrl = Optional.of(bannerUrl);
            return this;
        }

        @Override
        @JsonSetter(value = "banner_url", nulls = Nulls.SKIP)
        public _FinalStage bannerUrl(Optional<String> bannerUrl) {
            this.bannerUrl = bannerUrl;
            return this;
        }

        /**
         * <p>The URL of this game's logo image.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage logoUrl(String logoUrl) {
            this.logoUrl = Optional.of(logoUrl);
            return this;
        }

        @Override
        @JsonSetter(value = "logo_url", nulls = Nulls.SKIP)
        public _FinalStage logoUrl(Optional<String> logoUrl) {
            this.logoUrl = logoUrl;
            return this;
        }

        @Override
        public Summary build() {
            return new Summary(gameId, nameId, displayName, logoUrl, bannerUrl, url, developer, totalPlayerCount);
        }
    }
}
