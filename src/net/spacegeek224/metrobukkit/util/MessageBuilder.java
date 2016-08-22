package net.spacegeek224.metrobukkit.util;

import org.bukkit.ChatColor;

public class MessageBuilder {

	private StringBuilder b;

	public MessageBuilder() {
		this.b = new StringBuilder(ChatColor.RESET.toString());
		// TODO Auto-generated constructor stub
	}
	
	public MessageBuilder(String s) {
		this.b = new StringBuilder(ChatColor.RESET.toString()).append(s);
		// TODO Auto-generated constructor stub
	}

	public MessageBuilder red(String s) {
		b.append(ChatColor.RED.toString()).append(s);
		return this;
	}
	
	public MessageBuilder darkred(String s) {
		b.append(ChatColor.DARK_RED.toString()).append(s);
		return this;
	}
	
	public MessageBuilder gold(String s) {
		b.append(ChatColor.GOLD.toString()).append(s);
		return this;
	}
	
	public MessageBuilder green(String s) {
		b.append(ChatColor.GREEN.toString()).append(s);
		return this;
	}
	
	public MessageBuilder darkgreen(String s) {
		b.append(ChatColor.DARK_GREEN.toString()).append(s);
		return this;
	}
	
	public MessageBuilder yellow(String s) {
		b.append(ChatColor.YELLOW.toString()).append(s);
		return this;
	}
	
	public MessageBuilder blue(String s) {
		b.append(ChatColor.BLUE.toString()).append(s);
		return this;
	}
	
	public MessageBuilder darkblue(String s) {
		b.append(ChatColor.DARK_BLUE.toString()).append(s);
		return this;
	}
	
	public MessageBuilder darkpurple(String s) {
		b.append(ChatColor.DARK_PURPLE.toString()).append(s);
		return this;
	}
	
	public MessageBuilder lightpurple(String s) {
		b.append(ChatColor.LIGHT_PURPLE.toString()).append(s);
		return this;
	}
	
	public MessageBuilder magic(String s) {
		b.append(ChatColor.MAGIC.toString()).append(s);
		return this;
	}
	
	public MessageBuilder underline(String s) {
		b.append(ChatColor.UNDERLINE.toString()).append(s);
		return this;
	}
	
	public MessageBuilder reset(String s) {
		b.append(ChatColor.RESET.toString()).append(s);
		return this;
	}
	
	public MessageBuilder white(String s) {
		b.append(ChatColor.WHITE.toString()).append(s);
		return this;
	}
	
	public MessageBuilder black(String s) {
		b.append(ChatColor.BLACK.toString()).append(s);
		return this;
	}
	
	public MessageBuilder aqua(String s) {
		b.append(ChatColor.AQUA.toString()).append(s);
		return this;
	}
	
	public MessageBuilder darkaqua(String s) {
		b.append(ChatColor.DARK_AQUA.toString()).append(s);
		return this;
	}
	
	
	
	public MessageBuilder then(String s) {
		b.append(s);
		return this;
	}
	
	public String s() {
		return b.toString();
	}
	

}
