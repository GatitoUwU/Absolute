package es.vytale.absolute.lobby;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * This code has been created by
 * gatogamer#6666 A.K.A. gatogamer.
 * If you want to use my code, please
 * don't remove this messages and
 * give me the credits. Arigato! n.n
 */
@Getter
@Setter
public class Lobby {
    private final String id;
    private ConcurrentSkipListSet<UUID> players = new ConcurrentSkipListSet<>();
    private int maxPlayers = 0;

    public Lobby(String id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return players.size() > maxPlayers;
    }

    public void load(LobbyData lobbyData) {
        this.players = lobbyData.getPlayers();
        this.maxPlayers = lobbyData.getMaxPlayers();
    }

    public LobbyData export() {
        return new LobbyData(id, players, maxPlayers);
    }
}