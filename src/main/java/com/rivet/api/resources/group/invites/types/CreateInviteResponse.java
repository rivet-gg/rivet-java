package com.rivet.api.resources.group.invites.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = CreateInviteResponse.Builder.class
)
public final class CreateInviteResponse {
  private final String code;

  private int _cachedHashCode;

  CreateInviteResponse(String code) {
    this.code = code;
  }

  /**
   * @return The code that will be passed to <code>rivet.api.group#ConsumeInvite</code> to join a group.
   */
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CreateInviteResponse && equalTo((CreateInviteResponse) other);
  }

  private boolean equalTo(CreateInviteResponse other) {
    return code.equals(other.code);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.code);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "CreateInviteResponse{" + "code: " + code + "}";
  }

  public static CodeStage builder() {
    return new Builder();
  }

  public interface CodeStage {
    _FinalStage code(String code);

    Builder from(CreateInviteResponse other);
  }

  public interface _FinalStage {
    CreateInviteResponse build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements CodeStage, _FinalStage {
    private String code;

    private Builder() {
    }

    @Override
    public Builder from(CreateInviteResponse other) {
      code(other.getCode());
      return this;
    }

    /**
     * <p>The code that will be passed to <code>rivet.api.group#ConsumeInvite</code> to join a group.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("code")
    public _FinalStage code(String code) {
      this.code = code;
      return this;
    }

    @Override
    public CreateInviteResponse build() {
      return new CreateInviteResponse(code);
    }
  }
}
