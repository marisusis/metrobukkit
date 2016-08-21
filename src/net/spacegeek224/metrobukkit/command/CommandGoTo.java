package net.spacegeek224.metrobukkit.command;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

import net.spacegeek224.metrobukkit.MetroPlugin;

public class CommandGoTo implements CommandExecutor {

	public FileConfiguration config;
	public World w;
	private MetroPlugin p;
	private Map<String, Object> locations;

	public CommandGoTo(MetroPlugin p) {

		this.p = p;
		FileConfiguration config = YamlConfiguration.loadConfiguration(new File(p.getDataFolder(),"goto.yml"));
		locations = config.getConfigurationSection("locations").getValues(true);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (args.length == 1) {
				if (locations.containsKey(args[0])) {
					ConfigurationSection s = (ConfigurationSection) locations.get(args[0]);

					String toName = s.getName();
					String toWorld = s.getString("world");
					int toX = s.getInt("x");
					int toY = s.getInt("y");
					int toZ = s.getInt("z");

					Location toLocation = new Location(p.getServer().getWorld(toWorld), toX, toY, toZ);
					// player.sendMessage(new
					// StringBuilder(ChatColor.GREEN.toString()).append("Sending
					// you
					// to: " + toWorld + " - " + "(" + toX + "," + toY + "," +
					// toZ +
					// ")...").toString());
					player.sendMessage(new StringBuilder(ChatColor.GREEN.toString()).append("Sending you to ")
							.append(ChatColor.YELLOW.toString()).append(toName).append(ChatColor.GREEN.toString())
							.append("...").toString());
					player.teleport(toLocation);
					// player.teleport(toLocation,TeleportCause.UNKNOWN);
				} else {
					player.sendMessage(new StringBuilder(ChatColor.RED.toString()).append("I can't seem to find ").append(ChatColor.YELLOW.toString()).append(args[0]).append(ChatColor.RED.toString()).append(".").toString());
				}
			} else {
				return false;
			}

		} else {
			sender.sendMessage(
					new StringBuilder(ChatColor.GOLD.toString()).append("Only players can do this!").toString());
		}
		// If the player (or console) uses our command correct, we can return
		// true
		return true;
	}

}
