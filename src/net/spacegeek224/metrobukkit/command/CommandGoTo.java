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
import net.spacegeek224.metrobukkit.util.MessageBuilder;

public class CommandGoTo implements CommandExecutor {

	public FileConfiguration config;
	public World w;
	private MetroPlugin p;
	private Map<String, Object> locations;

	public CommandGoTo(MetroPlugin p) {

		this.p = p;
		config = YamlConfiguration.loadConfiguration(new File(p.getDataFolder(), "locations.yml"));

		locations = config.getConfigurationSection("locations").getValues(true);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (args.length == 1) {
				if (args[0].startsWith("-")) {
					switch (args[0].substring(1)) {
					case "list":
						player.sendMessage(new MessageBuilder().aqua("List of locations:").s());
						for (Object o : locations.values()) {
							if (o instanceof ConfigurationSection) {
								player.sendMessage(
										new MessageBuilder().yellow("- " + (((ConfigurationSection) o).getName())).s());
							}
						}
						break;
					case "rl":
						player.sendMessage(new MessageBuilder().yellow("Reloading goto locations...").s());
						try {
							config.load(new File(p.getDataFolder(), "locations.yml"));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvalidConfigurationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						locations = config.getConfigurationSection("locations").getValues(true);
						
					}
				} else {
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
						// to: " + toWorld + " - " + "(" + toX + "," + toY + ","
						// +
						// toZ +
						// ")...").toString());
						player.sendMessage(
								new MessageBuilder().green("Sending you to ").yellow(toName).green("...").s());
						player.teleport(toLocation);
						// player.teleport(toLocation,TeleportCause.UNKNOWN);
					} else {
						player.sendMessage(
								new MessageBuilder().red("I'm not sure where ").yellow(args[0]).red(" is.").s());
					}
				}
			} else {
				return false;
			}

		} else {
			sender.sendMessage(new MessageBuilder().red("Only players can do this!").s());
		}
		// If the player (or console) uses our command correct, we can return
		// true
		return true;
	}

}
