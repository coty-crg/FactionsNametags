package com.wanderingcorgi.factiontags;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	public static String dataFolder; 
	public boolean AmSaving; 
	
	public void onEnable(){
		Bukkit.getConsoleSender().sendMessage("[Starting tag plugin]");
		dataFolder = getDataFolder().toString(); 

		Events pluginEvents = new Events(this);
	}
	
	public void onDisable(){
		Bukkit.getConsoleSender().sendMessage("[Stopping tag plugin]");
	}
}
