package com.rivet.api.resources.chat;

import com.rivet.api.resources.chat.identity.IdentityClient;
import com.rivet.api.resources.chat.requests.GetThreadHistoryRequest;
import com.rivet.api.resources.chat.requests.WatchThreadRequest;
import com.rivet.api.resources.chat.types.GetThreadHistoryResponse;
import com.rivet.api.resources.chat.types.GetThreadTopicResponse;
import com.rivet.api.resources.chat.types.SendMessageRequest;
import com.rivet.api.resources.chat.types.SendMessageResponse;
import com.rivet.api.resources.chat.types.SetThreadReadRequest;
import com.rivet.api.resources.chat.types.SetTypingStatusRequest;
import com.rivet.api.resources.chat.types.WatchThreadResponse;
import java.util.UUID;

public interface ChatClient {
  SendMessageResponse sendMessage(SendMessageRequest request);

  GetThreadHistoryResponse getThreadHistory(UUID threadId, GetThreadHistoryRequest request);

  WatchThreadResponse watchThread(UUID threadId, WatchThreadRequest request);

  void setThreadRead(UUID threadId, SetThreadReadRequest request);

  GetThreadTopicResponse getThreadTopic(UUID threadId);

  void setTypingStatus(UUID threadId, SetTypingStatusRequest request);

  IdentityClient identity();
}
