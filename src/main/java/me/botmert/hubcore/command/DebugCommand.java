package me.botmert.hubcore.command;

import me.botmert.hubcore.utils.ColorUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class DebugCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player) || sender instanceof ConsoleCommandSender) {
			sender.sendMessage(ColorUtil.translate("&cOnly players can use these commands!"));
			return true;
		}

		Player player = (Player) sender;



		return true;
	}
}