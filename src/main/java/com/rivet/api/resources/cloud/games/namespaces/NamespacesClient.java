package com.rivet.api.resources.cloud.games.namespaces;

import com.rivet.api.resources.cloud.games.namespaces.analytics.AnalyticsClient;
import com.rivet.api.resources.cloud.games.namespaces.logs.LogsClient;
import com.rivet.api.resources.cloud.games.namespaces.requests.GetGameNamespaceVersionHistoryRequest;
import com.rivet.api.resources.cloud.games.namespaces.types.AddNamespaceDomainRequest;
import com.rivet.api.resources.cloud.games.namespaces.types.CreateGameNamespaceRequest;
import com.rivet.api.resources.cloud.games.namespaces.types.CreateGameNamespaceResponse;
import com.rivet.api.resources.cloud.games.namespaces.types.CreateGameNamespaceTokenDevelopmentRequest;
import com.rivet.api.resources.cloud.games.namespaces.types.CreateGameNamespaceTokenDevelopmentResponse;
import com.rivet.api.resources.cloud.games.namespaces.types.CreateGameNamespaceTokenPublicResponse;
import com.rivet.api.resources.cloud.games.namespaces.types.GetGameNamespaceByIdResponse;
import com.rivet.api.resources.cloud.games.namespaces.types.GetGameNamespaceVersionHistoryResponse;
import com.rivet.api.resources.cloud.games.namespaces.types.SetNamespaceCdnAuthTypeRequest;
import com.rivet.api.resources.cloud.games.namespaces.types.ToggleNamespaceDomainPublicAuthRequest;
import com.rivet.api.resources.cloud.games.namespaces.types.UpdateGameNamespaceMatchmakerConfigRequest;
import com.rivet.api.resources.cloud.games.namespaces.types.UpdateGameNamespaceVersionRequest;
import com.rivet.api.resources.cloud.games.namespaces.types.UpdateNamespaceCdnAuthUserRequest;
import com.rivet.api.resources.cloud.games.namespaces.types.ValidateGameNamespaceMatchmakerConfigRequest;
import com.rivet.api.resources.cloud.games.namespaces.types.ValidateGameNamespaceMatchmakerConfigResponse;
import com.rivet.api.resources.cloud.games.namespaces.types.ValidateGameNamespaceRequest;
import com.rivet.api.resources.cloud.games.namespaces.types.ValidateGameNamespaceResponse;
import com.rivet.api.resources.cloud.games.namespaces.types.ValidateGameNamespaceTokenDevelopmentRequest;
import com.rivet.api.resources.cloud.games.namespaces.types.ValidateGameNamespaceTokenDevelopmentResponse;
import java.lang.String;
import java.util.UUID;

public interface NamespacesClient {
  CreateGameNamespaceResponse createGameNamespace(UUID gameId, CreateGameNamespaceRequest request);

  ValidateGameNamespaceResponse validateGameNamespace(UUID gameId,
      ValidateGameNamespaceRequest request);

  GetGameNamespaceByIdResponse getGameNamespaceById(UUID gameId, UUID namespaceId);

  void updateNamespaceCdnAuthUser(UUID gameId, UUID namespaceId,
      UpdateNamespaceCdnAuthUserRequest request);

  void removeNamespaceCdnAuthUser(UUID gameId, UUID namespaceId, String user);

  void setNamespaceCdnAuthType(UUID gameId, UUID namespaceId,
      SetNamespaceCdnAuthTypeRequest request);

  void toggleNamespaceDomainPublicAuth(UUID gameId, UUID namespaceId,
      ToggleNamespaceDomainPublicAuthRequest request);

  void addNamespaceDomain(UUID gameId, UUID namespaceId, AddNamespaceDomainRequest request);

  void removeNamespaceDomain(UUID gameId, UUID namespaceId, String domain);

  void updateGameNamespaceMatchmakerConfig(UUID gameId, UUID namespaceId,
      UpdateGameNamespaceMatchmakerConfigRequest request);

  GetGameNamespaceVersionHistoryResponse getGameNamespaceVersionHistoryList(String gameId,
      String namespaceId, GetGameNamespaceVersionHistoryRequest request);

  ValidateGameNamespaceMatchmakerConfigResponse validateGameNamespaceMatchmakerConfig(UUID gameId,
      UUID namespaceId, ValidateGameNamespaceMatchmakerConfigRequest request);

  CreateGameNamespaceTokenDevelopmentResponse createGameNamespaceTokenDevelopment(UUID gameId,
      UUID namespaceId, CreateGameNamespaceTokenDevelopmentRequest request);

  ValidateGameNamespaceTokenDevelopmentResponse validateGameNamespaceTokenDevelopment(UUID gameId,
      UUID namespaceId, ValidateGameNamespaceTokenDevelopmentRequest request);

  CreateGameNamespaceTokenPublicResponse createGameNamespaceTokenPublic(UUID gameId,
      UUID namespaceId);

  void updateGameNamespaceVersion(UUID gameId, UUID namespaceId,
      UpdateGameNamespaceVersionRequest request);

  AnalyticsClient analytics();

  LogsClient logs();
}
