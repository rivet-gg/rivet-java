package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.game.common.types.Handle;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = GameLobbyExpenses.Builder.class
)
public final class GameLobbyExpenses {
  private final Handle game;

  private final List<NamespaceSummary> namespaces;

  private final List<RegionTierExpenses> expenses;

  private int _cachedHashCode;

  GameLobbyExpenses(Handle game, List<NamespaceSummary> namespaces,
      List<RegionTierExpenses> expenses) {
    this.game = game;
    this.namespaces = namespaces;
    this.expenses = expenses;
  }

  @JsonProperty("game")
  public Handle getGame() {
    return game;
  }

  /**
   * @return A list of namespace summaries.
   */
  @JsonProperty("namespaces")
  public List<NamespaceSummary> getNamespaces() {
    return namespaces;
  }

  /**
   * @return A list of multiple region tier expenses.
   */
  @JsonProperty("expenses")
  public List<RegionTierExpenses> getExpenses() {
    return expenses;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GameLobbyExpenses && equalTo((GameLobbyExpenses) other);
  }

  private boolean equalTo(GameLobbyExpenses other) {
    return game.equals(other.game) && namespaces.equals(other.namespaces) && expenses.equals(other.expenses);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.game, this.namespaces, this.expenses);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GameLobbyExpenses{" + "game: " + game + ", namespaces: " + namespaces + ", expenses: " + expenses + "}";
  }

  public static GameStage builder() {
    return new Builder();
  }

  public interface GameStage {
    _FinalStage game(Handle game);

    Builder from(GameLobbyExpenses other);
  }

  public interface _FinalStage {
    GameLobbyExpenses build();

    _FinalStage namespaces(List<NamespaceSummary> namespaces);

    _FinalStage addNamespaces(NamespaceSummary namespaces);

    _FinalStage addAllNamespaces(List<NamespaceSummary> namespaces);

    _FinalStage expenses(List<RegionTierExpenses> expenses);

    _FinalStage addExpenses(RegionTierExpenses expenses);

    _FinalStage addAllExpenses(List<RegionTierExpenses> expenses);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements GameStage, _FinalStage {
    private Handle game;

    private List<RegionTierExpenses> expenses = new ArrayList<>();

    private List<NamespaceSummary> namespaces = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(GameLobbyExpenses other) {
      game(other.getGame());
      namespaces(other.getNamespaces());
      expenses(other.getExpenses());
      return this;
    }

    @Override
    @JsonSetter("game")
    public _FinalStage game(Handle game) {
      this.game = game;
      return this;
    }

    /**
     * <p>A list of multiple region tier expenses.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addAllExpenses(List<RegionTierExpenses> expenses) {
      this.expenses.addAll(expenses);
      return this;
    }

    /**
     * <p>A list of multiple region tier expenses.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addExpenses(RegionTierExpenses expenses) {
      this.expenses.add(expenses);
      return this;
    }

    @Override
    @JsonSetter(
        value = "expenses",
        nulls = Nulls.SKIP
    )
    public _FinalStage expenses(List<RegionTierExpenses> expenses) {
      this.expenses.clear();
      this.expenses.addAll(expenses);
      return this;
    }

    /**
     * <p>A list of namespace summaries.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addAllNamespaces(List<NamespaceSummary> namespaces) {
      this.namespaces.addAll(namespaces);
      return this;
    }

    /**
     * <p>A list of namespace summaries.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addNamespaces(NamespaceSummary namespaces) {
      this.namespaces.add(namespaces);
      return this;
    }

    @Override
    @JsonSetter(
        value = "namespaces",
        nulls = Nulls.SKIP
    )
    public _FinalStage namespaces(List<NamespaceSummary> namespaces) {
      this.namespaces.clear();
      this.namespaces.addAll(namespaces);
      return this;
    }

    @Override
    public GameLobbyExpenses build() {
      return new GameLobbyExpenses(game, namespaces, expenses);
    }
  }
}
