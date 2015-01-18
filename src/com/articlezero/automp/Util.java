package com.articlezero.automp;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Util {

	private static Util util = new Util();
	
	public static Util getUtil(){
		return util;
	}
	
	public boolean isPlayer(CommandSender sender){
		return (sender instanceof Player);
	}
}
