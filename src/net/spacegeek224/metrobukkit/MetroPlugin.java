package net.spacegeek224.metrobukkit;

import org.bukkit.plugin.java.JavaPlugin;

public class MetroPlugin extends JavaPlugin {
	// Fired when plugin is first enabled
    @Override
    public void onEnable() {
    	getServer().getLogger().info("MetroPlugin is up and running!");
    }
    // Fired when plugin is disabled
    @Override
    public void onDisable() {
    	getServer().getLogger().info("MetroPlugin is shutting down...");
    }
}
