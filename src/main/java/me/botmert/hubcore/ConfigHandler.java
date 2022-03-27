package me.botmert.hubcore;

import lombok.Getter;
import me.botmert.hubcore.HubCore;
import me.botmert.hubcore.utils.ConfigYML;

public class ConfigHandler {

	@Getter private final ConfigYML messages;
	@Getter private final ConfigYML scoreboard;

	public ConfigHandler() {
		this.messages = new ConfigYML(HubCore.getInstance(), "messages", HubCore.getInstance().getDataFolder());
		this.scoreboard = new ConfigYML(HubCore.getInstance(), "scoreboard", HubCore.getInstance().getDataFolder());

		HubCore.getInstance().getConfig().options().copyDefaults(true);
		HubCore.getInstance().saveConfig();
	}
}
