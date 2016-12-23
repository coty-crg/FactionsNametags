package com.wanderingcorgi.factiontags;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.kitteh.tag.AsyncPlayerReceiveNameTagEvent;

import com.massivecraft.factions.Rel;
import com.massivecraft.factions.entity.MPlayer;

public class Events implements Listener{
	private final Main plugin;
	
	public Events(Main plugin){
		this.plugin = plugin;
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onNameTag(AsyncPlayerReceiveNameTagEvent event) {
		
		Player namedPlayer = event.getNamedPlayer(); 
		MPlayer namedMPlayer = MPlayer.get(namedPlayer); 
		
		if(!namedMPlayer.hasFaction())
			return; 
		
		Player player = event.getPlayer(); 
		MPlayer mPlayer = MPlayer.get(player); 
		
		Rel relation = namedMPlayer.getRelationTo(mPlayer);
		ChatColor color = relation.getColor(); 
		
		String newTag = String.format("%s/%s/%s", color, namedMPlayer.getFactionName(), namedPlayer.getDisplayName()); 
		event.setTag(newTag);
	}
}
