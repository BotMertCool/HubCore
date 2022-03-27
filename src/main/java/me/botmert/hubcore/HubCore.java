package me.botmert.hubcore;

import io.github.thatkawaiisam.assemble.Assemble;
import io.github.thatkawaiisam.assemble.AssembleStyle;
import lombok.Getter;
import me.botmert.hubcore.command.HubCoreCommand;
import me.botmert.hubcore.listener.HubCoreListener;
import me.botmert.hubcore.listener.PreventionListener;
import me.botmert.hubcore.scoreboard.ScoreboardProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class HubCore extends JavaPlugin {

	@Getter private static HubCore instance;
	@Getter private ConfigHandler configHandler;


	@Override
	public void onEnable() {
		instance = this;
		saveDefaultConfig();
		sendPluginInfo();

		configHandler = new ConfigHandler();

		//Init Listeners
		getServer().getPluginManager().registerEvents(new HubCoreListener(), this);
		getServer().getPluginManager().registerEvents(new PreventionListener(), this);

		//Init Commands
		getCommand("hubcore").setExecutor(new HubCoreCommand());

		//Init Scoreboard
		Assemble assemble = new Assemble(this, new ScoreboardProvider());
		assemble.setTicks(20);
		assemble.setAssembleStyle(AssembleStyle.MODERN);

		//Init Tab

		System.out.println("[" + getName() + "] Plugin started successfully.");
	}

	@Override
	public void onDisable() {
		instance = null;
	}

	private void sendPluginInfo() {
		System.out.println("\n\n" + getName() + "\n" + "This plugin was made by: BotMert\n");
	}




}
