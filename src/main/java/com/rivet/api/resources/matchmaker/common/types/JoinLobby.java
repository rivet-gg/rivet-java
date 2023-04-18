package com.rivet.api.resources.matchmaker.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@JsonDeserialize(
    builder = JoinLobby.Builder.class
)
public final class JoinLobby {
  private final UUID lobbyId;

  private final JoinRegion region;

  private final Map<String, JoinPort> ports;

  private final JoinPlayer player;

  private int _cachedHashCode;

  JoinLobby(UUID lobbyId, JoinRegion region, Map<String, JoinPort> ports, JoinPlayer player) {
    this.lobbyId = lobbyId;
    this.region = region;
    this.ports = ports;
    this.player = player;
  }

  @JsonProperty("lobby_id")
  public UUID getLobbyId() {
    return lobbyId;
  }

  @JsonProperty("region")
  public JoinRegion getRegion() {
    return region;
  }

  /**
   * @return <strong>Deprecated</strong>
   */
  @JsonProperty("ports")
  public Map<String, JoinPort> getPorts() {
    return ports;
  }

  /**
   * @return <strong>Deprecated</strong>
   */
  @JsonProperty("player")
  public JoinPlayer getPlayer() {
    return player;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof JoinLobby && equalTo((JoinLobby) other);
  }

  private boolean equalTo(JoinLobby other) {
    return lobbyId.equals(other.lobbyId) && region.equals(other.region) && ports.equals(other.ports) && player.equals(other.player);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.lobbyId, this.region, this.ports, this.player);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "JoinLobby{" + "lobbyId: " + lobbyId + ", region: " + region + ", ports: " + ports + ", player: " + player + "}";
  }

  public static LobbyIdStage builder() {
    return new Builder();
  }

  public interface LobbyIdStage {
    RegionStage lobbyId(UUID lobbyId);

    Builder from(JoinLobby other);
  }

  public interface RegionStage {
    PlayerStage region(JoinRegion region);
  }

  public interface PlayerStage {
    _FinalStage player(JoinPlayer player);
  }

  public interface _FinalStage {
    JoinLobby build();

    _FinalStage ports(Map<String, JoinPort> ports);

    _FinalStage putAllPorts(Map<String, JoinPort> ports);

    _FinalStage ports(String key, JoinPort value);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements LobbyIdStage, RegionStage, PlayerStage, _FinalStage {
    private UUID lobbyId;

    private JoinRegion region;

    private JoinPlayer player;

    private Map<String, JoinPort> ports = new LinkedHashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(JoinLobby other) {
      lobbyId(other.getLobbyId());
      region(other.getRegion());
      ports(other.getPorts());
      player(other.getPlayer());
      return this;
    }

    @Override
    @JsonSetter("lobby_id")
    public RegionStage lobbyId(UUID lobbyId) {
      this.lobbyId = lobbyId;
      return this;
    }

    @Override
    @JsonSetter("region")
    public PlayerStage region(JoinRegion region) {
      this.region = region;
      return this;
    }

    /**
     * <p><strong>Deprecated</strong></p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("player")
    public _FinalStage player(JoinPlayer player) {
      this.player = player;
      return this;
    }

    /**
     * <p><strong>Deprecated</strong></p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage ports(String key, JoinPort value) {
      this.ports.put(key, value);
      return this;
    }

    /**
     * <p><strong>Deprecated</strong></p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage putAllPorts(Map<String, JoinPort> ports) {
      this.ports.putAll(ports);
      return this;
    }

    @Override
    @JsonSetter(
        value = "ports",
        nulls = Nulls.SKIP
    )
    public _FinalStage ports(Map<String, JoinPort> ports) {
      this.ports.clear();
      this.ports.putAll(ports);
      return this;
    }

    @Override
    public JoinLobby build() {
      return new JoinLobby(lobbyId, region, ports, player);
    }
  }
}
