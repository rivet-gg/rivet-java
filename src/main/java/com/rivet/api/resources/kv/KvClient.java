package com.rivet.api.resources.kv;

import com.rivet.api.resources.kv.requests.DeleteBatchRequest;
import com.rivet.api.resources.kv.requests.DeleteOperationRequest;
import com.rivet.api.resources.kv.requests.GetBatchRequest;
import com.rivet.api.resources.kv.requests.GetOperationRequest;
import com.rivet.api.resources.kv.types.GetBatchResponse;
import com.rivet.api.resources.kv.types.GetResponse;
import com.rivet.api.resources.kv.types.PutBatchRequest;
import com.rivet.api.resources.kv.types.PutRequest;

public interface KvClient {
  GetResponse get(GetOperationRequest request);

  void put(PutRequest request);

  void delete(DeleteOperationRequest request);

  GetBatchResponse getBatch(GetBatchRequest request);

  void putBatch(PutBatchRequest request);

  void deleteBatch(DeleteBatchRequest request);
}
