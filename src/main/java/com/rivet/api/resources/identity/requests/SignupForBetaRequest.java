package com.rivet.api.resources.identity.requests;

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
    builder = SignupForBetaRequest.Builder.class
)
public final class SignupForBetaRequest {
  private final String name;

  private final Optional<String> companyName;

  private final String companySize;

  private final String preferredTools;

  private final String goals;

  private int _cachedHashCode;

  SignupForBetaRequest(String name, Optional<String> companyName, String companySize,
      String preferredTools, String goals) {
    this.name = name;
    this.companyName = companyName;
    this.companySize = companySize;
    this.preferredTools = preferredTools;
    this.goals = goals;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("company_name")
  public Optional<String> getCompanyName() {
    return companyName;
  }

  @JsonProperty("company_size")
  public String getCompanySize() {
    return companySize;
  }

  @JsonProperty("preferred_tools")
  public String getPreferredTools() {
    return preferredTools;
  }

  @JsonProperty("goals")
  public String getGoals() {
    return goals;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof SignupForBetaRequest && equalTo((SignupForBetaRequest) other);
  }

  private boolean equalTo(SignupForBetaRequest other) {
    return name.equals(other.name) && companyName.equals(other.companyName) && companySize.equals(other.companySize) && preferredTools.equals(other.preferredTools) && goals.equals(other.goals);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.name, this.companyName, this.companySize, this.preferredTools, this.goals);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "SignupForBetaRequest{" + "name: " + name + ", companyName: " + companyName + ", companySize: " + companySize + ", preferredTools: " + preferredTools + ", goals: " + goals + "}";
  }

  public static NameStage builder() {
    return new Builder();
  }

  public interface NameStage {
    CompanySizeStage name(String name);

    Builder from(SignupForBetaRequest other);
  }

  public interface CompanySizeStage {
    PreferredToolsStage companySize(String companySize);
  }

  public interface PreferredToolsStage {
    GoalsStage preferredTools(String preferredTools);
  }

  public interface GoalsStage {
    _FinalStage goals(String goals);
  }

  public interface _FinalStage {
    SignupForBetaRequest build();

    _FinalStage companyName(Optional<String> companyName);

    _FinalStage companyName(String companyName);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements NameStage, CompanySizeStage, PreferredToolsStage, GoalsStage, _FinalStage {
    private String name;

    private String companySize;

    private String preferredTools;

    private String goals;

    private Optional<String> companyName = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(SignupForBetaRequest other) {
      name(other.getName());
      companyName(other.getCompanyName());
      companySize(other.getCompanySize());
      preferredTools(other.getPreferredTools());
      goals(other.getGoals());
      return this;
    }

    @Override
    @JsonSetter("name")
    public CompanySizeStage name(String name) {
      this.name = name;
      return this;
    }

    @Override
    @JsonSetter("company_size")
    public PreferredToolsStage companySize(String companySize) {
      this.companySize = companySize;
      return this;
    }

    @Override
    @JsonSetter("preferred_tools")
    public GoalsStage preferredTools(String preferredTools) {
      this.preferredTools = preferredTools;
      return this;
    }

    @Override
    @JsonSetter("goals")
    public _FinalStage goals(String goals) {
      this.goals = goals;
      return this;
    }

    @Override
    public _FinalStage companyName(String companyName) {
      this.companyName = Optional.of(companyName);
      return this;
    }

    @Override
    @JsonSetter(
        value = "company_name",
        nulls = Nulls.SKIP
    )
    public _FinalStage companyName(Optional<String> companyName) {
      this.companyName = companyName;
      return this;
    }

    @Override
    public SignupForBetaRequest build() {
      return new SignupForBetaRequest(name, companyName, companySize, preferredTools, goals);
    }
  }
}
