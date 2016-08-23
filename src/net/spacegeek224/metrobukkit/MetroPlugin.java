package net.spacegeek224.metrobukkit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import net.spacegeek224.metrobukkit.command.CommandGoTo;
import net.spacegeek224.metrobukkit.command.CommandLocation;

public class MetroPlugin extends JavaPlugin implements PluginMessageListener {
	// Fired when plugin is first enabled

	public String[] configlist = { "config.yml", "locations.yml" };

	public Map<String, FileConfiguration> configs;

	@Override
	public void onEnable() {
		// this.saveDefaultConfig();
	    this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

	   
		if (!getDataFolder().exists()) {
			getServer().getLogger().log(Level.WARNING, "Folder does not exist");
			getDataFolder().mkdir();
		}
		for (String name : configlist) {
			File configFile = new File(getDataFolder(), name);
			if (!configFile.exists()) {
				try {
					configFile.createNewFile();
					getServer().getLogger().log(Level.WARNING, "Creating file: " + name);
					try (InputStream is = getResource(name); OutputStream os = new FileOutputStream(configFile)) {
						ByteStreams.copy(is, os);
					}
				} catch (IOException e) {
					getServer().getLogger().log(Level.SEVERE, "Can't create config file");
					throw new RuntimeException("Unable to create configuration file", e);
				}
			}
			// configs.put(name, YamlConfiguration.loadConfiguration(new
			// File(getDataFolder(), name)));
		}
		registerCommands();
		getServer().getLogger().info("MetroPlugin is up and running!");
	}

	// Fired when plugin is disabled
	@Override
	public void onDisable() {
		// this.saveConfig();
		getServer().getLogger().info("MetroPlugin is shutting down...");
	}

	
	public void registerCommands() {
		this.getCommand("goto").setExecutor(new CommandGoTo(this));
		this.getCommand("loc").setExecutor(new CommandLocation(this));
		this.getCommand("location").setExecutor(new CommandLocation(this));
	}

	@Override
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
		// TODO Auto-generated method stub
		if (!channel.equals("BungeeCord")) {
		      return;
		    }
		    ByteArrayDataInput in = ByteStreams.newDataInput(message);
		    String subchannel = in.readUTF();
		    if (subchannel.equals("SomeSubChannel")) {
		      // Use the code sample in the 'Response' sections below to read
		      // the data.
		    }
		
	}
}
