package es.vytale.absolute.lobby;

import lombok.Data;

import java.util.UUID;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * This code has been created by
 * gatogamer#6666 A.K.A. gatogamer.
 * If you want to use my code, please
 * don't remove this messages and
 * give me the credits. Arigato! n.n
 */
@Data
public class LobbyData {
    private final String id;
    private final ConcurrentSkipListSet<UUID> players;
    private final int maxPlayers;
}