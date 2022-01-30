package es.vytale.absolute.lobby;

import es.vytale.absolute.Absolute;
import es.vytale.milanesa.common.objects.CachedManager;
import lombok.Getter;
import org.bukkit.Bukkit;

import java.util.concurrent.ConcurrentSkipListSet;

/**
 * This code has been created by
 * gatogamer#6666 A.K.A. gatogamer.
 * If you want to use my code, please
 * don't remove this messages and
 * give me the credits. Arigato! n.n
 */
@Getter
public class LobbyManager extends CachedManager<String, Lobby> {
    private final Absolute absolute;
    private LobbyData selfData;

    public LobbyManager(Absolute absolute) {
        this.absolute = absolute;

        if (absolute.getConfig().contains("lobbyId")) {
            absolute.log("&cERROR AL CARGAR ABSOLUTE: Por favor, indica un id de Lobby.");
            absolute.log("&cERROR AL CARGAR ABSOLUTE: Por favor, indica un id de Lobby.");
            absolute.log("&cERROR AL CARGAR ABSOLUTE: Por favor, indica un id de Lobby.");
            absolute.log("&cERROR AL CARGAR ABSOLUTE: Por favor, indica un id de Lobby.");
            absolute.log("&cERROR AL CARGAR ABSOLUTE: Por favor, indica un id de Lobby.");
            System.exit(0);
            return;
        }
        int id = absolute.getConfig().getInt("lobbyId", 0);

        this.selfData = new LobbyData(String.valueOf(id), new ConcurrentSkipListSet<>(), Bukkit.getMaxPlayers());

        new LobbyInformerTask(this).runTaskTimerAsynchronously(absolute, 20L, 20L);
        absolute.getMilanesa().getMilanesaMessageHandler().registerChannel(new LobbyChannel(absolute));
    }

    @Override
    public Lobby getOrCreate(String s) {
        return getValues().computeIfAbsent(s, Lobby::new);
    }
}