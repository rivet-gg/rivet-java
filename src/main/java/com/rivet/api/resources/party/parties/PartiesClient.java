package com.rivet.api.resources.party.parties;

import com.rivet.api.resources.party.parties.requests.GetInviteRequest;
import com.rivet.api.resources.party.parties.requests.GetProfileRequest;
import com.rivet.api.resources.party.parties.requests.GetSelfProfileRequest;
import com.rivet.api.resources.party.parties.requests.GetSelfSummaryRequest;
import com.rivet.api.resources.party.parties.requests.GetSummaryRequest;
import com.rivet.api.resources.party.parties.types.CreateInviteRequest;
import com.rivet.api.resources.party.parties.types.CreateInviteResponse;
import com.rivet.api.resources.party.parties.types.CreateRequest;
import com.rivet.api.resources.party.parties.types.CreateResponse;
import com.rivet.api.resources.party.parties.types.GetInviteResponse;
import com.rivet.api.resources.party.parties.types.GetProfileResponse;
import com.rivet.api.resources.party.parties.types.GetSelfProfileResponse;
import com.rivet.api.resources.party.parties.types.GetSelfSummaryResponse;
import com.rivet.api.resources.party.parties.types.GetSummaryResponse;
import com.rivet.api.resources.party.parties.types.JoinRequest;
import com.rivet.api.resources.party.parties.types.JoinResponse;
import com.rivet.api.resources.party.parties.types.SetPublicityRequest;
import java.util.UUID;

public interface PartiesClient {
  GetInviteResponse getFromInvite(GetInviteRequest request);

  CreateResponse create(CreateRequest request);

  JoinResponse join(JoinRequest request);

  CreateInviteResponse createInvite(CreateInviteRequest request);

  void revokeInvite(UUID inviteId);

  void leave();

  void kickMember(UUID identityId);

  void transferOwnership(UUID identityId);

  GetSelfProfileResponse getSelfProfile(GetSelfProfileRequest request);

  void setPublicity(SetPublicityRequest request);

  GetSelfSummaryResponse getSelfSummary(GetSelfSummaryRequest request);

  void sendJoinRequest(UUID partyId);

  GetProfileResponse getProfile(UUID partyId, GetProfileRequest request);

  GetSummaryResponse getSummary(UUID partyId, GetSummaryRequest request);
}
