package com.rivet.api.resources.party.common.types;

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
    builder = Handle.Builder.class
)
public final class Handle {
  private final UUID partyId;

  private final String createTs;

  private final Activity activity;

  private final ExternalLinks external;

  private int _cachedHashCode;

  Handle(UUID partyId, String createTs, Activity activity, ExternalLinks external) {
    this.partyId = partyId;
    this.createTs = createTs;
    this.activity = activity;
    this.external = external;
  }

  @JsonProperty("party_id")
  public UUID getPartyId() {
    return partyId;
  }

  @JsonProperty("create_ts")
  public String getCreateTs() {
    return createTs;
  }

  @JsonProperty("activity")
  public Activity getActivity() {
    return activity;
  }

  @JsonProperty("external")
  public ExternalLinks getExternal() {
    return external;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Handle && equalTo((Handle) other);
  }

  private boolean equalTo(Handle other) {
    return partyId.equals(other.partyId) && createTs.equals(other.createTs) && activity.equals(other.activity) && external.equals(other.external);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.partyId, this.createTs, this.activity, this.external);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Handle{" + "partyId: " + partyId + ", createTs: " + createTs + ", activity: " + activity + ", external: " + external + "}";
  }

  public static PartyIdStage builder() {
    return new Builder();
  }

  public interface PartyIdStage {
    CreateTsStage partyId(UUID partyId);

    Builder from(Handle other);
  }

  public interface CreateTsStage {
    ActivityStage createTs(String createTs);
  }

  public interface ActivityStage {
    ExternalStage activity(Activity activity);
  }

  public interface ExternalStage {
    _FinalStage external(ExternalLinks external);
  }

  public interface _FinalStage {
    Handle build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements PartyIdStage, CreateTsStage, ActivityStage, ExternalStage, _FinalStage {
    private UUID partyId;

    private String createTs;

    private Activity activity;

    private ExternalLinks external;

    private Builder() {
    }

    @Override
    public Builder from(Handle other) {
      partyId(other.getPartyId());
      createTs(other.getCreateTs());
      activity(other.getActivity());
      external(other.getExternal());
      return this;
    }

    @Override
    @JsonSetter("party_id")
    public CreateTsStage partyId(UUID partyId) {
      this.partyId = partyId;
      return this;
    }

    @Override
    @JsonSetter("create_ts")
    public ActivityStage createTs(String createTs) {
      this.createTs = createTs;
      return this;
    }

    @Override
    @JsonSetter("activity")
    public ExternalStage activity(Activity activity) {
      this.activity = activity;
      return this;
    }

    @Override
    @JsonSetter("external")
    public _FinalStage external(ExternalLinks external) {
      this.external = external;
      return this;
    }

    @Override
    public Handle build() {
      return new Handle(partyId, createTs, activity, external);
    }
  }
}
