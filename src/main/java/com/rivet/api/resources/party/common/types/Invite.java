package com.rivet.api.resources.party.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@JsonDeserialize(
    builder = Invite.Builder.class
)
public final class Invite {
  private final UUID inviteId;

  private final String createTs;

  private final String token;

  private final Optional<InviteAlias> alias;

  private final InviteExternalLinks external;

  private int _cachedHashCode;

  Invite(UUID inviteId, String createTs, String token, Optional<InviteAlias> alias,
      InviteExternalLinks external) {
    this.inviteId = inviteId;
    this.createTs = createTs;
    this.token = token;
    this.alias = alias;
    this.external = external;
  }

  @JsonProperty("invite_id")
  public UUID getInviteId() {
    return inviteId;
  }

  /**
   * @return RFC3339 timestamp.
   */
  @JsonProperty("create_ts")
  public String getCreateTs() {
    return createTs;
  }

  /**
   * @return A JSON Web Token.
   * Slightly modified to include a description prefix and use Protobufs of
   * JSON.
   */
  @JsonProperty("token")
  public String getToken() {
    return token;
  }

  @JsonProperty("alias")
  public Optional<InviteAlias> getAlias() {
    return alias;
  }

  @JsonProperty("external")
  public InviteExternalLinks getExternal() {
    return external;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Invite && equalTo((Invite) other);
  }

  private boolean equalTo(Invite other) {
    return inviteId.equals(other.inviteId) && createTs.equals(other.createTs) && token.equals(other.token) && alias.equals(other.alias) && external.equals(other.external);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.inviteId, this.createTs, this.token, this.alias, this.external);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Invite{" + "inviteId: " + inviteId + ", createTs: " + createTs + ", token: " + token + ", alias: " + alias + ", external: " + external + "}";
  }

  public static InviteIdStage builder() {
    return new Builder();
  }

  public interface InviteIdStage {
    CreateTsStage inviteId(UUID inviteId);

    Builder from(Invite other);
  }

  public interface CreateTsStage {
    TokenStage createTs(String createTs);
  }

  public interface TokenStage {
    ExternalStage token(String token);
  }

  public interface ExternalStage {
    _FinalStage external(InviteExternalLinks external);
  }

  public interface _FinalStage {
    Invite build();

    _FinalStage alias(Optional<InviteAlias> alias);

    _FinalStage alias(InviteAlias alias);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements InviteIdStage, CreateTsStage, TokenStage, ExternalStage, _FinalStage {
    private UUID inviteId;

    private String createTs;

    private String token;

    private InviteExternalLinks external;

    private Optional<InviteAlias> alias = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(Invite other) {
      inviteId(other.getInviteId());
      createTs(other.getCreateTs());
      token(other.getToken());
      alias(other.getAlias());
      external(other.getExternal());
      return this;
    }

    @Override
    @JsonSetter("invite_id")
    public CreateTsStage inviteId(UUID inviteId) {
      this.inviteId = inviteId;
      return this;
    }

    /**
     * <p>RFC3339 timestamp.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("create_ts")
    public TokenStage createTs(String createTs) {
      this.createTs = createTs;
      return this;
    }

    /**
     * <p>A JSON Web Token.
     * Slightly modified to include a description prefix and use Protobufs of
     * JSON.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("token")
    public ExternalStage token(String token) {
      this.token = token;
      return this;
    }

    @Override
    @JsonSetter("external")
    public _FinalStage external(InviteExternalLinks external) {
      this.external = external;
      return this;
    }

    @Override
    public _FinalStage alias(InviteAlias alias) {
      this.alias = Optional.of(alias);
      return this;
    }

    @Override
    @JsonSetter(
        value = "alias",
        nulls = Nulls.SKIP
    )
    public _FinalStage alias(Optional<InviteAlias> alias) {
      this.alias = alias;
      return this;
    }

    @Override
    public Invite build() {
      return new Invite(inviteId, createTs, token, alias, external);
    }
  }
}
