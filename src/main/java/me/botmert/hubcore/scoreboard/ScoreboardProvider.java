package me.botmert.hubcore.scoreboard;

import io.github.thatkawaiisam.assemble.AssembleAdapter;
import me.botmert.hubcore.HubCore;
import me.botmert.hubcore.utils.ColorUtil;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardProvider implements AssembleAdapter {

	FileConfiguration scoreboardConfig = HubCore.getInstance().getConfigHandler().getScoreboard();

	@Override
	public String getTitle(Player player) {
		if (scoreboardConfig.getString("scoreboard.title") == null) {
			return ChatColor.RED + "Set the title!";
		}
		return ColorUtil.translate(scoreboardConfig.getString("scoreboard.title"));
	}

	@Override
	public List<String> getLines(Player player) {
		final List<String> toReturn = new ArrayList<>();

		toReturn.add("&a&lThis is a line!");


		toReturn.add(0, scoreboardConfig.getString("scoreboard.seperatorLine"));
		if (!scoreboardConfig.getString("scoreboard.footer").isEmpty()) {
			toReturn.add("");
			toReturn.add(scoreboardConfig.getString("scoreboard.footer"));
		}
		toReturn.add(scoreboardConfig.getString("scoreboard.seperatorLine"));



		return toReturn;
	}
}
