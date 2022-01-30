package es.vytale.absolute;

import es.vytale.absolute.lobby.LobbyManager;
import es.vytale.milanesa.spigot.Milanesa;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class Absolute extends JavaPlugin {

    private LobbyManager lobbyManager;
    private Milanesa milanesa;

    @Override
    public void onEnable() {
        milanesa = Milanesa.getPlugin(Milanesa.class);

        lobbyManager = new LobbyManager(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void log(String s) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&bAbsolute &8> &7" + s));
    }
}
