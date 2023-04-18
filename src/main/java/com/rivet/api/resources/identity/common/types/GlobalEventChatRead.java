package com.rivet.api.resources.identity.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.UUID;

@JsonDeserialize(
    builder = GlobalEventChatRead.Builder.class
)
public final class GlobalEventChatRead {
  private final UUID threadId;

  private final String readTs;

  private int _cachedHashCode;

  GlobalEventChatRead(UUID threadId, String readTs) {
    this.threadId = threadId;
    this.readTs = readTs;
  }

  @JsonProperty("thread_id")
  public UUID getThreadId() {
    return threadId;
  }

  @JsonProperty("read_ts")
  public String getReadTs() {
    return readTs;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GlobalEventChatRead && equalTo((GlobalEventChatRead) other);
  }

  private boolean equalTo(GlobalEventChatRead other) {
    return threadId.equals(other.threadId) && readTs.equals(other.readTs);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.threadId, this.readTs);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GlobalEventChatRead{" + "threadId: " + threadId + ", readTs: " + readTs + "}";
  }

  public static ThreadIdStage builder() {
    return new Builder();
  }

  public interface ThreadIdStage {
    ReadTsStage threadId(UUID threadId);

    Builder from(GlobalEventChatRead other);
  }

  public interface ReadTsStage {
    _FinalStage readTs(String readTs);
  }

  public interface _FinalStage {
    GlobalEventChatRead build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements ThreadIdStage, ReadTsStage, _FinalStage {
    private UUID threadId;

    private String readTs;

    private Builder() {
    }

    @Override
    public Builder from(GlobalEventChatRead other) {
      threadId(other.getThreadId());
      readTs(other.getReadTs());
      return this;
    }

    @Override
    @JsonSetter("thread_id")
    public ReadTsStage threadId(UUID threadId) {
      this.threadId = threadId;
      return this;
    }

    @Override
    @JsonSetter("read_ts")
    public _FinalStage readTs(String readTs) {
      this.readTs = readTs;
      return this;
    }

    @Override
    public GlobalEventChatRead build() {
      return new GlobalEventChatRead(threadId, readTs);
    }
  }
}
