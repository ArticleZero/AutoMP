package com.articlezero.automp.lang;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class PluginFile {

	private static Set<PluginFile> files = new HashSet<PluginFile>();
	private File file;
	String name;

	public PluginFile(Plugin p, String name, String dir, boolean copyDefaults, boolean alert){
		this.name = name;
		file = new File(dir, name);
		if(!file.exists()){
			try{
				file.createNewFile();
			}catch (IOException e){
				return; //The file already exists
			}
			if(copyDefaults){
				p.saveResource(name, false);
			}
			if(alert){
				Bukkit.getServer().getLogger().info("[" + p.getDescription().getName() + "] " + "Could not find the file " + name + "! Generating a new one.");
			}
		}
		files.add(this);
	}
	
	public File getFile(){
		return file;
	}
	
	public FileConfiguration getConfiguration(){
		return YamlConfiguration.loadConfiguration(file);
	}
	
	public String getName(){
		return name;
	}
	
	public static File getFile(String name){
		for(PluginFile f:files){
			if(f.getName().equalsIgnoreCase(name)) return f.getFile();
		}
		return null;
	}
	
}
