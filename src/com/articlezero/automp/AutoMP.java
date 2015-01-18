package com.articlezero.automp;

import java.io.File;
import java.util.logging.Level;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.articlezero.automp.lang.Lang;
import com.articlezero.automp.lang.PluginFile;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;

public class AutoMP extends JavaPlugin{

	public static WorldEditPlugin worldEditPlugin = null;
	
	public void onEnable() {
		MPUtil.getMPUtil().init(this);
		new PluginFile(this, "mp.yml", getDataFolder().toString(), false, false);
		new PluginFile(this, "messages.yml", getDataFolder().toString(), true, true);
		Lang.setFile(YamlConfiguration.loadConfiguration(PluginFile.getFile("messages.yml")));
		File config = new File(getDataFolder(), "config.yml");
		if(!config.exists()){
			getServer().getLogger().info("No config.yml found! Generating a new one!");
			saveDefaultConfig();
		}
		if(!enableWorldEdit()){
			return;
		}
	}
	
	public void onDisable() {
		
	}
	
	public boolean enableWorldEdit(){
		if(getServer().getPluginManager().isPluginEnabled("WorldEdit")){
			worldEditPlugin = (WorldEditPlugin) getServer().getPluginManager().getPlugin("WorldEdit");
			return true;
		}else{
			getServer().getLogger().log(Level.SEVERE, "[" + getName() + "] " + "Disabling due to no WorldEdit dependency found!");
			getServer().getPluginManager().disablePlugin(this);
			return false;
		}
//		Selection sel = worldEditPlugin.getSelection(plr);
//		if (sel instanceof Polygonal2DSelection) {
//		  Polygonal2DSelection polySel = (Polygonal2DSelection) sel;
//		  int minY = polySel.getNativeMinimumPoint().getBlockY();
//		  int maxY = polySel.getNativeMaximumPoint().getBlockY();
//		}
//		else if (sel instanceof CuboidSelection) {
//		  BlockVector min = sel.getNativeMinimumPoint().toBlockVector();
//		  BlockVector max = sel.getNativeMaximumPoint().toBlockVector();
//		}
	}
	
}
