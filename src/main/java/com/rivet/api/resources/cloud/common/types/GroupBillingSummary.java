package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = GroupBillingSummary.Builder.class
)
public final class GroupBillingSummary {
  private final List<GameLobbyExpenses> games;

  private final double balance;

  private int _cachedHashCode;

  GroupBillingSummary(List<GameLobbyExpenses> games, double balance) {
    this.games = games;
    this.balance = balance;
  }

  /**
   * @return A list of multiple game lobby expenses.
   */
  @JsonProperty("games")
  public List<GameLobbyExpenses> getGames() {
    return games;
  }

  /**
   * @return A group's available balance.
   */
  @JsonProperty("balance")
  public double getBalance() {
    return balance;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GroupBillingSummary && equalTo((GroupBillingSummary) other);
  }

  private boolean equalTo(GroupBillingSummary other) {
    return games.equals(other.games) && balance == other.balance;
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.games, this.balance);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GroupBillingSummary{" + "games: " + games + ", balance: " + balance + "}";
  }

  public static BalanceStage builder() {
    return new Builder();
  }

  public interface BalanceStage {
    _FinalStage balance(double balance);

    Builder from(GroupBillingSummary other);
  }

  public interface _FinalStage {
    GroupBillingSummary build();

    _FinalStage games(List<GameLobbyExpenses> games);

    _FinalStage addGames(GameLobbyExpenses games);

    _FinalStage addAllGames(List<GameLobbyExpenses> games);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements BalanceStage, _FinalStage {
    private double balance;

    private List<GameLobbyExpenses> games = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(GroupBillingSummary other) {
      games(other.getGames());
      balance(other.getBalance());
      return this;
    }

    /**
     * <p>A group's available balance.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("balance")
    public _FinalStage balance(double balance) {
      this.balance = balance;
      return this;
    }

    /**
     * <p>A list of multiple game lobby expenses.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addAllGames(List<GameLobbyExpenses> games) {
      this.games.addAll(games);
      return this;
    }

    /**
     * <p>A list of multiple game lobby expenses.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addGames(GameLobbyExpenses games) {
      this.games.add(games);
      return this;
    }

    @Override
    @JsonSetter(
        value = "games",
        nulls = Nulls.SKIP
    )
    public _FinalStage games(List<GameLobbyExpenses> games) {
      this.games.clear();
      this.games.addAll(games);
      return this;
    }

    @Override
    public GroupBillingSummary build() {
      return new GroupBillingSummary(games, balance);
    }
  }
}
