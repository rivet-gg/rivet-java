package com.rivet.api.resources.chat.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.identity.common.types.Handle;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = MessageBodyGroupMemberKick.Builder.class
)
public final class MessageBodyGroupMemberKick {
  private final Handle identity;

  private int _cachedHashCode;

  MessageBodyGroupMemberKick(Handle identity) {
    this.identity = identity;
  }

  @JsonProperty("identity")
  public Handle getIdentity() {
    return identity;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof MessageBodyGroupMemberKick && equalTo((MessageBodyGroupMemberKick) other);
  }

  private boolean equalTo(MessageBodyGroupMemberKick other) {
    return identity.equals(other.identity);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.identity);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "MessageBodyGroupMemberKick{" + "identity: " + identity + "}";
  }

  public static IdentityStage builder() {
    return new Builder();
  }

  public interface IdentityStage {
    _FinalStage identity(Handle identity);

    Builder from(MessageBodyGroupMemberKick other);
  }

  public interface _FinalStage {
    MessageBodyGroupMemberKick build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements IdentityStage, _FinalStage {
    private Handle identity;

    private Builder() {
    }

    @Override
    public Builder from(MessageBodyGroupMemberKick other) {
      identity(other.getIdentity());
      return this;
    }

    @Override
    @JsonSetter("identity")
    public _FinalStage identity(Handle identity) {
      this.identity = identity;
      return this;
    }

    @Override
    public MessageBodyGroupMemberKick build() {
      return new MessageBodyGroupMemberKick(identity);
    }
  }
}
