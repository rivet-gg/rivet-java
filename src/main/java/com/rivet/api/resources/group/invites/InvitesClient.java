package com.rivet.api.resources.group.invites;

import com.rivet.api.resources.group.invites.types.ConsumeInviteResponse;
import com.rivet.api.resources.group.invites.types.CreateInviteRequest;
import com.rivet.api.resources.group.invites.types.CreateInviteResponse;
import com.rivet.api.resources.group.invites.types.GetInviteResponse;
import java.lang.String;
import java.util.UUID;

public interface InvitesClient {
  GetInviteResponse getInvite(String groupInviteCode);

  ConsumeInviteResponse consumeInvite(String groupInviteCode);

  CreateInviteResponse createInvite(UUID groupId, CreateInviteRequest request);
}
