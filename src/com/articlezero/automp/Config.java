package com.articlezero.automp;

import org.bukkit.plugin.Plugin;

public class Config {
	
	private static Plugin p;
	public boolean intervals;
	
	public void init(Plugin plugin){
		p = plugin;
	}
	
	public void load(){
		this.intervals = p.getConfig().getInt("interval") == 0 ? false : true; 	
	}
}
