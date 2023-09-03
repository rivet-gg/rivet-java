package com.rivet.api.resources.cloud.games;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.Suppliers;
import com.rivet.api.resources.cloud.games.avatars.AvatarsClient;
import com.rivet.api.resources.cloud.games.builds.BuildsClient;
import com.rivet.api.resources.cloud.games.cdn.CdnClient;
import com.rivet.api.resources.cloud.games.matchmaker.MatchmakerClient;
import com.rivet.api.resources.cloud.games.namespaces.NamespacesClient;
import com.rivet.api.resources.cloud.games.tokens.TokensClient;
import com.rivet.api.resources.cloud.games.versions.VersionsClient;
import java.util.function.Supplier;

public class GamesClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<NamespacesClient> namespacesClient;

    protected final Supplier<AvatarsClient> avatarsClient;

    protected final Supplier<BuildsClient> buildsClient;

    protected final Supplier<CdnClient> cdnClient;

    protected final Supplier<com.rivet.api.resources.cloud.games.games.GamesClient> gamesClient;

    protected final Supplier<MatchmakerClient> matchmakerClient;

    protected final Supplier<TokensClient> tokensClient;

    protected final Supplier<VersionsClient> versionsClient;

    public GamesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.namespacesClient = Suppliers.memoize(() -> new NamespacesClient(clientOptions));
        this.avatarsClient = Suppliers.memoize(() -> new AvatarsClient(clientOptions));
        this.buildsClient = Suppliers.memoize(() -> new BuildsClient(clientOptions));
        this.cdnClient = Suppliers.memoize(() -> new CdnClient(clientOptions));
        this.gamesClient =
                Suppliers.memoize(() -> new com.rivet.api.resources.cloud.games.games.GamesClient(clientOptions));
        this.matchmakerClient = Suppliers.memoize(() -> new MatchmakerClient(clientOptions));
        this.tokensClient = Suppliers.memoize(() -> new TokensClient(clientOptions));
        this.versionsClient = Suppliers.memoize(() -> new VersionsClient(clientOptions));
    }

    public NamespacesClient namespaces() {
        return this.namespacesClient.get();
    }

    public AvatarsClient avatars() {
        return this.avatarsClient.get();
    }

    public BuildsClient builds() {
        return this.buildsClient.get();
    }

    public CdnClient cdn() {
        return this.cdnClient.get();
    }

    public com.rivet.api.resources.cloud.games.games.GamesClient games() {
        return this.gamesClient.get();
    }

    public MatchmakerClient matchmaker() {
        return this.matchmakerClient.get();
    }

    public TokensClient tokens() {
        return this.tokensClient.get();
    }

    public VersionsClient versions() {
        return this.versionsClient.get();
    }
}
