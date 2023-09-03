package com.rivet.api.resources.matchmaker;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.Suppliers;
import com.rivet.api.resources.matchmaker.lobbies.LobbiesClient;
import com.rivet.api.resources.matchmaker.players.PlayersClient;
import com.rivet.api.resources.matchmaker.regions.RegionsClient;
import java.util.function.Supplier;

public class MatchmakerClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<LobbiesClient> lobbiesClient;

    protected final Supplier<PlayersClient> playersClient;

    protected final Supplier<RegionsClient> regionsClient;

    public MatchmakerClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.lobbiesClient = Suppliers.memoize(() -> new LobbiesClient(clientOptions));
        this.playersClient = Suppliers.memoize(() -> new PlayersClient(clientOptions));
        this.regionsClient = Suppliers.memoize(() -> new RegionsClient(clientOptions));
    }

    public LobbiesClient lobbies() {
        return this.lobbiesClient.get();
    }

    public PlayersClient players() {
        return this.playersClient.get();
    }

    public RegionsClient regions() {
        return this.regionsClient.get();
    }
}
