package com.rivet.api.resources.cloud.games.avatars;

import com.rivet.api.resources.cloud.games.avatars.types.ListGameCustomAvatarsResponse;
import com.rivet.api.resources.cloud.games.avatars.types.PrepareCustomAvatarUploadRequest;
import com.rivet.api.resources.cloud.games.avatars.types.PrepareCustomAvatarUploadResponse;
import java.util.UUID;

public interface AvatarsClient {
  ListGameCustomAvatarsResponse listGameCustomAvatars(UUID gameId);

  PrepareCustomAvatarUploadResponse prepareCustomAvatarUpload(UUID gameId,
      PrepareCustomAvatarUploadRequest request);

  void completeCustomAvatarUpload(UUID gameId, UUID uploadId);
}
