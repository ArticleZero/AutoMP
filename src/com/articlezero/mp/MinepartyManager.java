package com.articlezero.mp;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.plugin.Plugin;

import com.articlezero.automp.Countdown;

public class MinepartyManager {

	private static MinepartyManager mpm = new MinepartyManager();
	private Plugin plugin;
	private static Set<Mineparty> objects = new HashSet<Mineparty>();
	
	public static MinepartyManager getMinePartyManager(){
		return mpm;
	}
	
	public void initPlugin(Plugin p){
		this.plugin = p;
	}
	
	/**
	 * @param name name of the mp
	 * @return mineparty object
	 */
	public Mineparty getMineparty(String name){
		for(Mineparty mp:objects){
			if(mp.getName().equalsIgnoreCase(name)){
				return mp;
			}
		}
		return null;
	}
	
	/**
	 * starts a mineparty
	 * @param name name of the mineparty to start
	 */
	public void startMineparty(String name){
		new Countdown(plugin.getConfig(), name).runTaskTimer(plugin, 0L, 20L);
	}
	
	/**
	 * @param name name of the mp to destroy
	 */
	public void destroyMineparty(String name){
		if(getMineparty(name) != null){
			objects.remove(getMineparty(name));
		}
	}
}
