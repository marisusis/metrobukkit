package net.spacegeek224.metrobukkit.util;

import org.bukkit.ChatColor;

public class MessageBuilder {

	private StringBuilder b;

	public MessageBuilder() {
		this.b = new StringBuilder(ChatColor.RESET.toString());
		// TODO Auto-generated constructor stub
	}

	public void red() {
		b.append(ChatColor.RED.toString());
	}
	
	public void darkred() {
		b.append(ChatColor.DARK_RED.toString());
	}
	
	public void gold() {
		b.append(ChatColor.GOLD.toString());
	}
	
	public void green() {
		b.append(ChatColor.GREEN.toString());
	}
	
	public void darkgreen() {
		b.append(ChatColor.DARK_GREEN.toString());
	}
	
	public void yellow() {
		b.append(ChatColor.YELLOW.toString());
	}
	
	public void blue() {
		b.append(ChatColor.BLUE.toString());
	}
	
	public void darkblue() {
		b.append(ChatColor.DARK_BLUE.toString());
	}
	
	public void darkpurple() {
		b.append(ChatColor.DARK_PURPLE.toString());
	}
	
	public void lightpurple() {
		b.append(ChatColor.LIGHT_PURPLE.toString());
	}
	
	public void magic() {
		b.append(ChatColor.MAGIC.toString());
	}
	
	public void underline() {
		b.append(ChatColor.UNDERLINE.toString());
	}
	
	public void reset() {
		b.append(ChatColor.RESET.toString());
	}
	
	public void white() {
		b.append(ChatColor.WHITE.toString());
	}
	
	public void black() {
		b.append(ChatColor.BLACK.toString());
	}
	
	public void then(String s) {
		b.append(s);
	}
	
	public String toString() {
		return b.toString();
	}
	

}
