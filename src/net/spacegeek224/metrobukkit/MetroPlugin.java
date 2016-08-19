package net.spacegeek224.metrobukkit;

import org.bukkit.plugin.java.JavaPlugin;

import net.spacegeek224.metrobukkit.command.CommandGoTo;

public class MetroPlugin extends JavaPlugin {
	// Fired when plugin is first enabled
    @Override
    public void onEnable() {
    	this.saveDefaultConfig();
    	registerCommands();
    	getServer().getLogger().info("MetroPlugin is up and running!");
    }
    // Fired when plugin is disabled
    @Override
    public void onDisable() {
    	this.saveConfig();
    	getServer().getLogger().info("MetroPlugin is shutting down...");
    }
    
    public void registerCommands() {
    	this.getCommand("goto").setExecutor(new CommandGoTo(this));
    }
}
