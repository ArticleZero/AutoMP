package com.articlezero.automp;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.scheduler.BukkitRunnable;

public class Countdown extends BukkitRunnable{

	int counter;
	FileConfiguration config;
	String mp;
	
	public Countdown(FileConfiguration config, String mp){
		this.counter = config.getInt("countdown");
		this.config = config;
		this.mp = mp;
	}
	
	@Override
	public void run(){
		if(config.getConfigurationSection("interval_commands").getKeys(false) != null){
			for(String key:config.getConfigurationSection("interval_commands").getKeys(false)){
				if(Integer.parseInt(key) == counter){
					for(String command:config.getStringList("interval_commands." + key)){
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
					}
					break;
				}
			}
		}
		if(counter == 0){
			MPUtil.getMPUtil().startMP(mp);
			this.cancel();
			return;
		}
		counter--;
	}
	
}
