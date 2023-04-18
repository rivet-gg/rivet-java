package com.rivet.api.resources.identity.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.identity.common.types.Status;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = UpdateStatusRequest.Builder.class
)
public final class UpdateStatusRequest {
  private final Status status;

  private int _cachedHashCode;

  UpdateStatusRequest(Status status) {
    this.status = status;
  }

  @JsonProperty("status")
  public Status getStatus() {
    return status;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof UpdateStatusRequest && equalTo((UpdateStatusRequest) other);
  }

  private boolean equalTo(UpdateStatusRequest other) {
    return status.equals(other.status);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.status);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "UpdateStatusRequest{" + "status: " + status + "}";
  }

  public static StatusStage builder() {
    return new Builder();
  }

  public interface StatusStage {
    _FinalStage status(Status status);

    Builder from(UpdateStatusRequest other);
  }

  public interface _FinalStage {
    UpdateStatusRequest build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements StatusStage, _FinalStage {
    private Status status;

    private Builder() {
    }

    @Override
    public Builder from(UpdateStatusRequest other) {
      status(other.getStatus());
      return this;
    }

    @Override
    @JsonSetter("status")
    public _FinalStage status(Status status) {
      this.status = status;
      return this;
    }

    @Override
    public UpdateStatusRequest build() {
      return new UpdateStatusRequest(status);
    }
  }
}
