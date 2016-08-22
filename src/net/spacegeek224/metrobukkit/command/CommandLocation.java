package net.spacegeek224.metrobukkit.command;

import java.io.File;
import java.util.Map;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import net.spacegeek224.metrobukkit.MetroPlugin;
import net.spacegeek224.metrobukkit.util.MessageBuilder;

public class CommandLocation {

	public FileConfiguration config;
	public World w;
	private MetroPlugin p;
	private Map<String, Object> locations;

	public CommandLocation(MetroPlugin p) {

		this.p = p;
		config = YamlConfiguration.loadConfiguration(new File(p.getDataFolder(), "goto.yml"));
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) { // stub
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (args.length == 1) {
				if (args[0].startsWith("-")) {
					switch (args[0].substring(1)) {
					case "set":
						break;
					default:
						player.sendMessage(new MessageBuilder().red("Unknown command option ").yellow(args[0].substring(1)).red(".").s());

					}
				} else {

				}
			} else {
				return false;
			}

		} else {
			sender.sendMessage(new MessageBuilder().red("Only players can do this!").s());
		}
		return true;
	}

}
