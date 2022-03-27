package me.botmert.hubcore.command;

import me.botmert.hubcore.HubCore;
import me.botmert.hubcore.utils.ColorUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class HubCoreCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player) || sender instanceof ConsoleCommandSender) {
			sender.sendMessage(ColorUtil.translate("&cOnly players can use these commands!"));
			return true;
		}

		Player player = (Player)sender;

		if (cmd.getName().equalsIgnoreCase("hubcore")) {

			if (!player.hasPermission("hubcore.admin")) {
				player.sendMessage(ColorUtil.translate(HubCore.getInstance().getConfigHandler().getMessages().getString("noPermission")));
				return true;
			}

			if (args.length != 1 || args[0].equalsIgnoreCase("help")) {
				//send help command
				sendHelp(player);
				return true;
			}

			if (args[0].equalsIgnoreCase("reload")) {
				//send reload the plugin
				HubCore.getInstance().reloadConfig();
				HubCore.getInstance().getConfigHandler().getScoreboard().reload();
				HubCore.getInstance().getConfigHandler().getMessages().reload();
				player.sendMessage(ChatColor.GREEN + "The config files have been reloaded!");
				return true;
			}


		}
		return true;
	}

	public void sendHelp(Player player) {
		player.sendMessage(ColorUtil.translate("&c/hubcore help - View all the commands in this plugin"));
		player.sendMessage(ColorUtil.translate("&c/hubcore reload - Reload all of the config files"));
	}

}
