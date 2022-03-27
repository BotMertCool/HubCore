package me.botmert.hubcore.utils;

import lombok.Getter;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

@Getter
public class ConfigYML extends YamlConfiguration {
	private final File yamlFile;

	public ConfigYML(Plugin plugin, String name, File path) {
		if (!path.exists())
			path.mkdirs();

		this.yamlFile = new File(path, name + ".yml");
		if (!this.yamlFile.exists()) plugin.saveResource(this.yamlFile.getName(), false);

		this.reload();
	}

	public void reload() {
		try {
			this.load(this.yamlFile);
		} catch (InvalidConfigurationException | IOException ex) {
			ex.printStackTrace();
		}
	}

	public void save() {
		try {
			this.save(this.yamlFile);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
