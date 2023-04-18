package com.rivet.api.resources.party.activity;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.Suppliers;
import com.rivet.api.resources.party.activity.matchmaker.MatchmakerClient;
import com.rivet.api.resources.party.activity.matchmaker.MatchmakerClientImpl;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import java.util.function.Supplier;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class ActivityClientImpl implements ActivityClient {
  private final ClientOptions clientOptions;

  private final Supplier<MatchmakerClient> matchmakerClient;

  public ActivityClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
    this.matchmakerClient = Suppliers.memoize(() -> new MatchmakerClientImpl(clientOptions));
  }

  @Override
  public void setPartyToIdle() {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getpartyURL()).newBuilder()
      .addPathSegments("parties/self")
      .build();Request _request = new Request.Builder()
      .url(_httpUrl)
      .method("DELETE", RequestBody.create("", null))
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

  @Override
  public MatchmakerClient matchmaker() {
    return this.matchmakerClient.get();
  }
}
