package com.rivet.api.resources.identity;

import com.rivet.api.resources.identity.events.EventsClient;
import com.rivet.api.resources.identity.links.LinksClient;
import com.rivet.api.resources.identity.requests.GetHandlesRequest;
import com.rivet.api.resources.identity.requests.GetProfileRequest;
import com.rivet.api.resources.identity.requests.GetSelfProfileRequest;
import com.rivet.api.resources.identity.requests.GetSummariesRequest;
import com.rivet.api.resources.identity.requests.ListFollowersRequest;
import com.rivet.api.resources.identity.requests.ListFollowingRequest;
import com.rivet.api.resources.identity.requests.ListFriendsRequest;
import com.rivet.api.resources.identity.requests.ListMutualFriendsRequest;
import com.rivet.api.resources.identity.requests.ListRecentFollowersRequest;
import com.rivet.api.resources.identity.requests.PrepareAvatarUploadRequest;
import com.rivet.api.resources.identity.requests.ReportRequest;
import com.rivet.api.resources.identity.requests.SearchRequest;
import com.rivet.api.resources.identity.requests.SetGameActivityRequest;
import com.rivet.api.resources.identity.requests.SetupRequest;
import com.rivet.api.resources.identity.requests.SignupForBetaRequest;
import com.rivet.api.resources.identity.requests.UpdateProfileRequest;
import com.rivet.api.resources.identity.requests.UpdateStatusRequest;
import com.rivet.api.resources.identity.requests.ValidateProfileRequest;
import com.rivet.api.resources.identity.types.GetHandlesResponse;
import com.rivet.api.resources.identity.types.GetProfileResponse;
import com.rivet.api.resources.identity.types.GetSummariesResponse;
import com.rivet.api.resources.identity.types.ListFollowersResponse;
import com.rivet.api.resources.identity.types.ListFollowingResponse;
import com.rivet.api.resources.identity.types.ListFriendsResponse;
import com.rivet.api.resources.identity.types.ListMutualFriendsResponse;
import com.rivet.api.resources.identity.types.ListRecentFollowersResponse;
import com.rivet.api.resources.identity.types.PrepareAvatarUploadResponse;
import com.rivet.api.resources.identity.types.SearchResponse;
import com.rivet.api.resources.identity.types.SetupResponse;
import java.util.UUID;

public interface IdentityClient {
  SetupResponse setup(SetupRequest request);

  GetProfileResponse getProfile(UUID identityId, GetProfileRequest request);

  GetProfileResponse getSelfProfile(GetSelfProfileRequest request);

  GetHandlesResponse getHandles(GetHandlesRequest request);

  GetSummariesResponse getSummaries(GetSummariesRequest request);

  void updateProfile(UpdateProfileRequest request);

  void validateProfile(ValidateProfileRequest request);

  SearchResponse search(SearchRequest request);

  void setGameActivity(SetGameActivityRequest request);

  void removeGameActivity();

  void updateStatus(UpdateStatusRequest request);

  void follow(UUID identityId);

  void unfollow(UUID identityId);

  PrepareAvatarUploadResponse prepareAvatarUpload(PrepareAvatarUploadRequest request);

  void completeAvatarUpload(UUID uploadId);

  void signupForBeta(SignupForBetaRequest request);

  void report(UUID identityId, ReportRequest request);

  ListFollowersResponse listFollowers(UUID identityId, ListFollowersRequest request);

  ListFollowingResponse listFollowing(UUID identityId, ListFollowingRequest request);

  ListFriendsResponse listFriends(ListFriendsRequest request);

  ListMutualFriendsResponse listMutualFriends(UUID identityId, ListMutualFriendsRequest request);

  ListRecentFollowersResponse listRecentFollowers(ListRecentFollowersRequest request);

  void ignoreRecentFollower(UUID identityId);

  void markDeletion();

  void unmarkDeletion();

  EventsClient events();

  LinksClient links();
}
