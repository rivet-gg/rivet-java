package com.rivet.api.resources.cloud.groups;

import com.rivet.api.resources.cloud.groups.requests.GetBillingRequest;
import com.rivet.api.resources.cloud.groups.requests.GetInvoicesListRequest;
import com.rivet.api.resources.cloud.groups.requests.GetPaymentsListRequest;
import com.rivet.api.resources.cloud.groups.requests.GetTransfersListRequest;
import com.rivet.api.resources.cloud.groups.types.GetBillingResponse;
import com.rivet.api.resources.cloud.groups.types.GetInvoicesListResponse;
import com.rivet.api.resources.cloud.groups.types.GetPaymentsListResponse;
import com.rivet.api.resources.cloud.groups.types.GetTransfersListResponse;
import com.rivet.api.resources.cloud.groups.types.GroupBillingCheckoutRequest;
import com.rivet.api.resources.cloud.groups.types.GroupBillingCheckoutResponse;
import com.rivet.api.resources.cloud.groups.types.ValidateGroupRequest;
import com.rivet.api.resources.cloud.groups.types.ValidateGroupResponse;
import java.util.UUID;

public interface GroupsClient {
  ValidateGroupResponse validate(ValidateGroupRequest request);

  GetBillingResponse getBilling(UUID groupId, GetBillingRequest request);

  GetInvoicesListResponse getInvoicesList(UUID groupId, GetInvoicesListRequest request);

  GetPaymentsListResponse getPaymentsList(UUID groupId, GetPaymentsListRequest request);

  GetTransfersListResponse getTransfersList(UUID groupId, GetTransfersListRequest request);

  GroupBillingCheckoutResponse billingCheckout(UUID groupId, GroupBillingCheckoutRequest request);

  void convertGroup(UUID groupId);
}
