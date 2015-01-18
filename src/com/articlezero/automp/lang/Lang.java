package com.articlezero.automp.lang;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

public enum Lang {

	PREFIX("prefix", "&7[&4AutoMP&7]"),
	MP_STARTED("mp_started", "&aSuccessfully started a mineparty!"),
	MP_STOPPED("mp_stopped", "&aSuccessfully stopped a mineparty!"),
	MP_EXISTS("mp_exists", "&cError: A mineparty with that name already exists!"),
	MULTIPLE_MP("multiple_mp", "&cError: There are multiple minepartys configured. Please specify one with /mp start <name>!"),
	MP_NOT_FOUND("mp_not_found", "&cError: The specified mineparty, {name}, was not found! Did you spell it correctly?"),
	NO_SELECTION("no_selection", "&cError: You do not have a selection selected with WorldEdit! Please select one then try again."),
	NOT_CUBOID("not_cuboid", "&cError: The region you have selected with WorldEdit isn't a cuboid selection! Please use a cuboid selection then try again."),
	CREATED_MP("created_mp", "&aSuccessfully created a new mineparty with the name of {name}!"),
	ROUNDS_NOT_DEFINED("rounds_not_defined", "&cError: There are no rounds defined for the mineparty {name}! Define them using /mp set {name}!"),
	NO_PERMS("no_perms", "&cYou do not have permission to use this command!");
	

	private String path;
	private String name;
	private static YamlConfiguration lang;
	
	Lang(String path, String def) { 
		this.path = path;
		this.name = def;
	}

	/**
	 * Sets the yaml file to get the message from (Usally called in onEnable)
	 * @param langConfig - The yamlconfiguration to use 
	 */
	public static void setFile(YamlConfiguration messages) {
		lang = messages;
	}

	/**
	 * Gets text lang
	 * @return String - The formatted string
	 */
	public String toString(String[] replace, String[] with) {
		if (this == PREFIX){
			return ChatColor.translateAlternateColorCodes('&', lang.getString(this.path, name)) + " ";
		}else{
			String s = lang.getString(this.path, name);
			if(replace != null && with != null){
				for(int i = 0; i < replace.length; i++){
					s.replace(replace[i], with[i]);
				}
			}
			return ChatColor.translateAlternateColorCodes('&', s);
		}
	}
	

}
