package com.rivet.api.resources.chat.common.types;

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

@JsonDeserialize(
    builder = Topic.Builder.class
)
public final class Topic {
  private final Optional<TopicGroup> group;

  private final Optional<TopicParty> party;

  private final Optional<TopicDirect> direct;

  private int _cachedHashCode;

  Topic(Optional<TopicGroup> group, Optional<TopicParty> party, Optional<TopicDirect> direct) {
    this.group = group;
    this.party = party;
    this.direct = direct;
  }

  @JsonProperty("group")
  public Optional<TopicGroup> getGroup() {
    return group;
  }

  @JsonProperty("party")
  public Optional<TopicParty> getParty() {
    return party;
  }

  @JsonProperty("direct")
  public Optional<TopicDirect> getDirect() {
    return direct;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Topic && equalTo((Topic) other);
  }

  private boolean equalTo(Topic other) {
    return group.equals(other.group) && party.equals(other.party) && direct.equals(other.direct);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.group, this.party, this.direct);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Topic{" + "group: " + group + ", party: " + party + ", direct: " + direct + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<TopicGroup> group = Optional.empty();

    private Optional<TopicParty> party = Optional.empty();

    private Optional<TopicDirect> direct = Optional.empty();

    private Builder() {
    }

    public Builder from(Topic other) {
      group(other.getGroup());
      party(other.getParty());
      direct(other.getDirect());
      return this;
    }

    @JsonSetter(
        value = "group",
        nulls = Nulls.SKIP
    )
    public Builder group(Optional<TopicGroup> group) {
      this.group = group;
      return this;
    }

    public Builder group(TopicGroup group) {
      this.group = Optional.of(group);
      return this;
    }

    @JsonSetter(
        value = "party",
        nulls = Nulls.SKIP
    )
    public Builder party(Optional<TopicParty> party) {
      this.party = party;
      return this;
    }

    public Builder party(TopicParty party) {
      this.party = Optional.of(party);
      return this;
    }

    @JsonSetter(
        value = "direct",
        nulls = Nulls.SKIP
    )
    public Builder direct(Optional<TopicDirect> direct) {
      this.direct = direct;
      return this;
    }

    public Builder direct(TopicDirect direct) {
      this.direct = Optional.of(direct);
      return this;
    }

    public Topic build() {
      return new Topic(group, party, direct);
    }
  }
}
