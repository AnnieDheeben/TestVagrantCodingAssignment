package com.testvagrant.musicstore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayStoreManager {
	
	private Map<String, UserPlayList> playLists;
	
	// Module Information
    // Module Name: RecentlyPlayedStoreManager
    // Date of Creation: 08-11-2023
    // Name of Creator of the module: Annie Soundari Muthuraj
    // History of modification: [Date] - NA
    // Summary: This class manages multiple users and their playlists 

	public PlayStoreManager() {
		playLists = new HashMap<>();
	}
	
	public void addSong(String user, String song) {
		try {
			if(user==null || song==null) {
				throw new IllegalArgumentException("User and Song must not be null");
			}
			playLists.putIfAbsent(user, new UserPlayList(3));
			playLists.get(user).addSong(song);
		}catch(Exception e) {
			System.err.println("Exception: " +e.getMessage());
		}
	}
	
	public List<String> getRecentlyPlayed(String user){
		try {
			if(user==null) {
				throw new IllegalArgumentException("User must not be null");
			}
			if(playLists.containsKey(user)) {
			return playLists.get(user).getRecentlyPlayed();
			}
			return new ArrayList<>();
		}catch(Exception e) {
			System.err.println("Exception :" +e.getMessage());
			return new ArrayList<>();
		}
		
	}
	
	public void setCapacity(String user, int newCapacity) {
		try {
			if(user==null) {
				throw new IllegalArgumentException("User must not be null");
			}
			if(newCapacity<=0) {
				throw new IllegalArgumentException("New Capacity must be greater than 0");
			}
			if(playLists.containsKey(user)) {
				playLists.get(user).setCapacity(newCapacity);
			}
		}catch(Exception e) {
			System.err.println("Exception :" +e.getMessage());
		}
	}
}
