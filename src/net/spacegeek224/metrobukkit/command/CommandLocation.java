package net.spacegeek224.metrobukkit.command;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import net.spacegeek224.metrobukkit.MetroPlugin;
import net.spacegeek224.metrobukkit.util.MessageBuilder;

public class CommandLocation implements CommandExecutor {

	public FileConfiguration config;
	public World w;
	private MetroPlugin p;
	private ConfigurationSection locations;

	public CommandLocation(MetroPlugin p) {

		this.p = p;
		config = YamlConfiguration.loadConfiguration(new File(p.getDataFolder(), "locations.yml"));
		locations = config.getConfigurationSection("locations");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) { // stub
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (args.length >= 1) {
				if (args[0].startsWith("-")) {
					switch (args[0].substring(1)) {
					case "set":
						if (args.length - 1 == 5) {

							ConfigurationSection c = locations.createSection(args[1]);

							c.set("world", args[2].replaceAll("~", player.getWorld().getName()));
							c.set("x", Integer.parseInt(
									args[3].replaceAll("~", Integer.toString((int) player.getLocation().getX()))));
							c.set("y", Integer.parseInt(
									args[4].replaceAll("~", Integer.toString((int) player.getLocation().getY()))));
							c.set("z", Integer.parseInt(
									args[5].replaceAll("~", Integer.toString((int) player.getLocation().getZ()))));

						}
						try {
							config.save(new File(p.getDataFolder(), "locations.yml"));
							config.load(new File(p.getDataFolder(), "locations.yml"));
							locations = config.getConfigurationSection("locations");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvalidConfigurationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					default:
						player.sendMessage(new MessageBuilder().red("Unknown command option ")
								.yellow(args[0].substring(1)).red(". Do ").yellow("/help ").red("for help.").s());
					}
				} else {

				}
			} else {
				return true;
			}

		} else {
			sender.sendMessage(new MessageBuilder().red("Only players can do this!").s());
		}
		return true;
	}

}
