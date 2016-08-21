package net.spacegeek224.metrobukkit.command;

import java.util.List;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

import net.spacegeek224.metrobukkit.MetroPlugin;

public class CommandGoTo implements CommandExecutor {

	public FileConfiguration config;
	public World w;
	private MetroPlugin p;

	public CommandGoTo(MetroPlugin p) {
		this.p = p;
		config = p.getConfig();
		w = p.getServer().getWorld("world");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (args.length == 1) {
				Map<String, Object> locations = config.getConfigurationSection("goto").getValues(true);
				ConfigurationSection s = (ConfigurationSection) locations.get(args[0]);

				String toName = s.getString("name");
				String toWorld = s.getString("world");
				String toX = s.getString("x");
				String toY = s.getString("y");
				String toZ = s.getString("z");

				Location toLocation = new Location(p.getServer().getWorld(toWorld), s.getInt(toX), s.getInt(toY),
						s.getInt(toZ));
				// player.sendMessage(new
				// StringBuilder(ChatColor.GREEN.toString()).append("Sending you
				// to: " + toWorld + " - " + "(" + toX + "," + toY + "," + toZ +
				// ")...").toString());
				player.sendMessage(new StringBuilder(ChatColor.GREEN.toString())
						.append("Sending you to ")
						.append(ChatColor.YELLOW.toString())
						.append(toName)
						.append(ChatColor.GREEN.toString())
						.append("...").toString());
				player.teleport(toLocation);
				// player.teleport(toLocation,TeleportCause.UNKNOWN);
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
