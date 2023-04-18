package com.rivet.api.resources.matchmaker;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.Suppliers;
import com.rivet.api.resources.matchmaker.lobbies.LobbiesClient;
import com.rivet.api.resources.matchmaker.lobbies.LobbiesClientImpl;
import com.rivet.api.resources.matchmaker.players.PlayersClient;
import com.rivet.api.resources.matchmaker.players.PlayersClientImpl;
import com.rivet.api.resources.matchmaker.regions.RegionsClient;
import com.rivet.api.resources.matchmaker.regions.RegionsClientImpl;
import java.lang.Override;
import java.util.function.Supplier;

public final class MatchmakerClientImpl implements MatchmakerClient {
  private final ClientOptions clientOptions;

  private final Supplier<LobbiesClient> lobbiesClient;

  private final Supplier<PlayersClient> playersClient;

  private final Supplier<RegionsClient> regionsClient;

  public MatchmakerClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
    this.lobbiesClient = Suppliers.memoize(() -> new LobbiesClientImpl(clientOptions));
    this.playersClient = Suppliers.memoize(() -> new PlayersClientImpl(clientOptions));
    this.regionsClient = Suppliers.memoize(() -> new RegionsClientImpl(clientOptions));
  }

  @Override
  public LobbiesClient lobbies() {
    return this.lobbiesClient.get();
  }

  @Override
  public PlayersClient players() {
    return this.playersClient.get();
  }

  @Override
  public RegionsClient regions() {
    return this.regionsClient.get();
  }
}
