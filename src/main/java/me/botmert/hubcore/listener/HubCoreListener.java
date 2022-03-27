package me.botmert.hubcore.listener;

import me.botmert.hubcore.HubCore;
import me.botmert.hubcore.utils.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HubCoreListener implements Listener {

   // public Location spawnLocation() {

    @EventHandler
    public void OnJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        FileConfiguration config = HubCore.getInstance().getConfig();
        FileConfiguration messages = HubCore.getInstance().getConfigHandler().getMessages();

        event.setJoinMessage(null);

        World w = Bukkit.getServer().getWorld(HubCore.getInstance().getConfig().getString("spawn.world"));
        double x = HubCore.getInstance().getConfig().getDouble("spawn.x");
        double y = HubCore.getInstance().getConfig().getDouble("spawn.y");
        double z = HubCore.getInstance().getConfig().getDouble("spawn.z");
        float yaw = HubCore.getInstance().getConfig().getFloat("spawn.yaw");
        float pitch = HubCore.getInstance().getConfig().getFloat("spawn.pitch");

        player.teleport(new Location(w, x, y + 0.5, z, yaw, pitch));

        if (messages.getBoolean("joinMessageEnabled")) {
            for (String string : messages.getStringList("joinMessage")) {
                player.sendMessage(ColorUtil.translate(string));
            }
        }

        player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 696969, 0));

        if (!(config.getInt("joinEffects.speed") == 0)) {
            player.addPotionEffect(
                    new PotionEffect(PotionEffectType.SPEED, 69696969, config.getInt("joinEffects.speed") - 1)
            );
        }

    }

}
