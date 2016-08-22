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

	public void red(String s) {
		b.append(ChatColor.RED.toString()).append(s);
	}
	
	public void darkred(String s) {
		b.append(ChatColor.DARK_RED.toString()).append(s);
	}
	
	public void gold(String s) {
		b.append(ChatColor.GOLD.toString()).append(s);
	}
	
	public void green(String s) {
		b.append(ChatColor.GREEN.toString()).append(s);
	}
	
	public void darkgreen(String s) {
		b.append(ChatColor.DARK_GREEN.toString()).append(s);
	}
	
	public void yellow(String s) {
		b.append(ChatColor.YELLOW.toString()).append(s);
	}
	
	public void blue(String s) {
		b.append(ChatColor.BLUE.toString()).append(s);
	}
	
	public void darkblue(String s) {
		b.append(ChatColor.DARK_BLUE.toString()).append(s);
	}
	
	public void darkpurple(String s) {
		b.append(ChatColor.DARK_PURPLE.toString()).append(s);
	}
	
	public void lightpurple(String s) {
		b.append(ChatColor.LIGHT_PURPLE.toString()).append(s);
	}
	
	public void magic(String s) {
		b.append(ChatColor.MAGIC.toString()).append(s);
	}
	
	public void underline(String s) {
		b.append(ChatColor.UNDERLINE.toString()).append(s);
	}
	
	public void reset(String s) {
		b.append(ChatColor.RESET.toString()).append(s);
	}
	
	public void white(String s) {
		b.append(ChatColor.WHITE.toString()).append(s);
	}
	
	public void black(String s) {
		b.append(ChatColor.BLACK.toString()).append(s);
	}
	
	public void then(String s) {
		b.append(s);
	}
	
	public String toString() {
		return b.toString();
	}
	

}
