package com.rivet.api.resources.cloud.groups;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.ObjectMappers;
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
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import java.util.UUID;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class GroupsClientImpl implements GroupsClient {
  private final ClientOptions clientOptions;

  public GroupsClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  @Override
  public ValidateGroupResponse validate(ValidateGroupRequest request) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
      .addPathSegments("groups")
      .build();
    RequestBody _requestBody;
    try {
      _requestBody = RequestBody.create(ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
    }
    catch(Exception e) {
      throw new RuntimeException(e);
    }
    Request _request = new Request.Builder()
      .url(_httpUrl)
      .method("POST", _requestBody)
      .headers(Headers.of(clientOptions.headers()))
      .build();
    try {
      Response _response = clientOptions.httpClient().newCall(_request).execute();
      if (_response.isSuccessful()) {
        return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ValidateGroupResponse.class);
      }
      throw new RuntimeException();
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public GetBillingResponse getBilling(UUID groupId, GetBillingRequest request) {
    HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
      .addPathSegments("groups")
      .addPathSegment(groupId.toString())
      .addPathSegments("billing")
      ;if (request.getQueryStart().isPresent()) {
        _httpUrlBuilder.addQueryParameter("query_start", request.getQueryStart().get());
      }
      if (request.getQueryEnd().isPresent()) {
        _httpUrlBuilder.addQueryParameter("query_end", request.getQueryEnd().get());
      }
      HttpUrl _httpUrl = _httpUrlBuilder.build();
      RequestBody _requestBody = RequestBody.create("", null);
      Request.Builder _requestBuilder = new Request.Builder()
        .url(_httpUrl)
        .method("GET", _requestBody)
        .headers(Headers.of(clientOptions.headers()));
      Request _request = _requestBuilder.build();
      try {
        Response _response = clientOptions.httpClient().newCall(_request).execute();
        if (_response.isSuccessful()) {
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetBillingResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public GetInvoicesListResponse getInvoicesList(UUID groupId, GetInvoicesListRequest request) {
      HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
        .addPathSegments("groups")
        .addPathSegment(groupId.toString())
        .addPathSegments("billing/invoices")
        ;if (request.getAnchor().isPresent()) {
          _httpUrlBuilder.addQueryParameter("anchor", request.getAnchor().get());
        }
        if (request.getLimit().isPresent()) {
          _httpUrlBuilder.addQueryParameter("limit", request.getLimit().get().toString());
        }
        HttpUrl _httpUrl = _httpUrlBuilder.build();
        RequestBody _requestBody = RequestBody.create("", null);
        Request.Builder _requestBuilder = new Request.Builder()
          .url(_httpUrl)
          .method("GET", _requestBody)
          .headers(Headers.of(clientOptions.headers()));
        Request _request = _requestBuilder.build();
        try {
          Response _response = clientOptions.httpClient().newCall(_request).execute();
          if (_response.isSuccessful()) {
            return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetInvoicesListResponse.class);
          }
          throw new RuntimeException();
        }
        catch (Exception e) {
          throw new RuntimeException(e);
        }
      }

      @Override
      public GetPaymentsListResponse getPaymentsList(UUID groupId, GetPaymentsListRequest request) {
        HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
          .addPathSegments("groups")
          .addPathSegment(groupId.toString())
          .addPathSegments("billing/payments")
          ;if (request.getStartPaymentId().isPresent()) {
            _httpUrlBuilder.addQueryParameter("start_payment_id", request.getStartPaymentId().get());
          }
          HttpUrl _httpUrl = _httpUrlBuilder.build();
          RequestBody _requestBody = RequestBody.create("", null);
          Request.Builder _requestBuilder = new Request.Builder()
            .url(_httpUrl)
            .method("GET", _requestBody)
            .headers(Headers.of(clientOptions.headers()));
          Request _request = _requestBuilder.build();
          try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
              return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetPaymentsListResponse.class);
            }
            throw new RuntimeException();
          }
          catch (Exception e) {
            throw new RuntimeException(e);
          }
        }

        @Override
        public GetTransfersListResponse getTransfersList(UUID groupId,
            GetTransfersListRequest request) {
          HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
            .addPathSegments("groups")
            .addPathSegment(groupId.toString())
            .addPathSegments("billing/transfers")
            ;if (request.getStartTransferId().isPresent()) {
              _httpUrlBuilder.addQueryParameter("start_transfer_id", request.getStartTransferId().get());
            }
            HttpUrl _httpUrl = _httpUrlBuilder.build();
            RequestBody _requestBody = RequestBody.create("", null);
            Request.Builder _requestBuilder = new Request.Builder()
              .url(_httpUrl)
              .method("GET", _requestBody)
              .headers(Headers.of(clientOptions.headers()));
            Request _request = _requestBuilder.build();
            try {
              Response _response = clientOptions.httpClient().newCall(_request).execute();
              if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GetTransfersListResponse.class);
              }
              throw new RuntimeException();
            }
            catch (Exception e) {
              throw new RuntimeException(e);
            }
          }

          @Override
          public GroupBillingCheckoutResponse billingCheckout(UUID groupId,
              GroupBillingCheckoutRequest request) {
            HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
              .addPathSegments("groups")
              .addPathSegment(groupId.toString())
              .addPathSegments("checkout")
              .build();
            RequestBody _requestBody;
            try {
              _requestBody = RequestBody.create(ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
            }
            catch(Exception e) {
              throw new RuntimeException(e);
            }
            Request _request = new Request.Builder()
              .url(_httpUrl)
              .method("POST", _requestBody)
              .headers(Headers.of(clientOptions.headers()))
              .build();
            try {
              Response _response = clientOptions.httpClient().newCall(_request).execute();
              if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), GroupBillingCheckoutResponse.class);
              }
              throw new RuntimeException();
            }
            catch (Exception e) {
              throw new RuntimeException(e);
            }
          }

          @Override
          public void convertGroup(UUID groupId) {
            HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getcloudURL()).newBuilder()
              .addPathSegments("groups")
              .addPathSegment(groupId.toString())
              .addPathSegments("convert")
              .build();Request _request = new Request.Builder()
              .url(_httpUrl)
              .method("POST", RequestBody.create("", null))
              .headers(Headers.of(clientOptions.headers()))
              .build();
            try {
              Response _response = clientOptions.httpClient().newCall(_request).execute();
              if (_response.isSuccessful()) {
                return;
              }
              throw new RuntimeException();
            }
            catch (Exception e) {
              throw new RuntimeException(e);
            }
          }
        }
