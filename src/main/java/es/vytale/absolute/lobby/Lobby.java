package es.vytale.absolute.lobby;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

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
    private final Set<UUID> players = ConcurrentHashMap.newKeySet();
    private int maxPlayers = 0;

    public Lobby(String id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return players.size() > maxPlayers;
    }
}