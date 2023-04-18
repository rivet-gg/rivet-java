package com.rivet.api.resources.cloud.games.namespaces.logs;

import com.rivet.api.resources.cloud.games.namespaces.logs.requests.ListNamespaceLobbiesRequest;
import com.rivet.api.resources.cloud.games.namespaces.logs.types.GetNamespaceLobbyResponse;
import com.rivet.api.resources.cloud.games.namespaces.logs.types.ListNamespaceLobbiesResponse;
import java.util.UUID;

public interface LogsClient {
  ListNamespaceLobbiesResponse listNamespaceLobbies(UUID gameId, UUID namespaceId,
      ListNamespaceLobbiesRequest request);

  GetNamespaceLobbyResponse getNamespaceLobby(UUID gameId, UUID namespaceId, UUID lobbyId);
}
