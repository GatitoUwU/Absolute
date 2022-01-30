package es.vytale.absolute.lobby;

import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * This code has been created by
 * gatogamer#6666 A.K.A. gatogamer.
 * If you want to use my code, please
 * don't remove this messages and
 * give me the credits. Arigato! n.n
 */
@RequiredArgsConstructor
public class LobbyInformerTask extends BukkitRunnable {
    private final LobbyManager lobbyManager;

    @Override
    public void run() {
        LobbyData lobbyData = lobbyManager.getSelfData();
        lobbyData.getPlayers().clear();
        Bukkit.getOnlinePlayers().forEach(player -> lobbyData.getPlayers().add(player.getUniqueId()));
        lobbyManager.getAbsolute().getMilanesa().getMilanesaMessageHandler().sendMessage("lobbies::update", lobbyData);
    }
}