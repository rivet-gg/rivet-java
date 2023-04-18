package com.rivet.api.resources.group;

import com.rivet.api.resources.group.invites.InvitesClient;
import com.rivet.api.resources.group.join.requests.JoinRequestsClient;
import com.rivet.api.resources.group.requests.GetBansRequest;
import com.rivet.api.resources.group.requests.GetJoinRequestsRequest;
import com.rivet.api.resources.group.requests.GetMembersRequest;
import com.rivet.api.resources.group.requests.GetProfileRequest;
import com.rivet.api.resources.group.requests.ListSuggestedRequest;
import com.rivet.api.resources.group.requests.SearchRequest;
import com.rivet.api.resources.group.types.CreateRequest;
import com.rivet.api.resources.group.types.CreateResponse;
import com.rivet.api.resources.group.types.GetBansResponse;
import com.rivet.api.resources.group.types.GetJoinRequestsResponse;
import com.rivet.api.resources.group.types.GetMembersResponse;
import com.rivet.api.resources.group.types.GetProfileResponse;
import com.rivet.api.resources.group.types.GetSummaryResponse;
import com.rivet.api.resources.group.types.ListSuggestedResponse;
import com.rivet.api.resources.group.types.PrepareAvatarUploadRequest;
import com.rivet.api.resources.group.types.PrepareAvatarUploadResponse;
import com.rivet.api.resources.group.types.SearchResponse;
import com.rivet.api.resources.group.types.TransferOwnershipRequest;
import com.rivet.api.resources.group.types.UpdateProfileRequest;
import com.rivet.api.resources.group.types.ValidateProfileRequest;
import com.rivet.api.resources.group.types.ValidateProfileResponse;
import java.util.UUID;

public interface GroupClient {
  ListSuggestedResponse listSuggested(ListSuggestedRequest request);

  CreateResponse create(CreateRequest request);

  PrepareAvatarUploadResponse prepareAvatarUpload(PrepareAvatarUploadRequest request);

  ValidateProfileResponse validateProfile(ValidateProfileRequest request);

  SearchResponse search(SearchRequest request);

  void completeAvatarUpload(UUID groupId, UUID uploadId);

  GetBansResponse getBans(UUID groupId, GetBansRequest request);

  void banIdentity(UUID groupId, UUID identityId);

  void unbanIdentity(UUID groupId, UUID identityId);

  GetJoinRequestsResponse getJoinRequests(UUID groupId, GetJoinRequestsRequest request);

  void kickMember(UUID groupId, UUID identityId);

  void leave(UUID groupId);

  GetMembersResponse getMembers(UUID groupId, GetMembersRequest request);

  GetProfileResponse getProfile(UUID groupId, GetProfileRequest request);

  void updateProfile(UUID groupId, UpdateProfileRequest request);

  GetSummaryResponse getSummary(UUID groupId);

  void transferOwnership(UUID groupId, TransferOwnershipRequest request);

  InvitesClient invites();

  JoinRequestsClient joinRequests();
}
