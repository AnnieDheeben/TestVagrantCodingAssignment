package com.testvagrant.musicstore;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UserPlayList {

	private int capacity;
	private Queue<String> songsQueue;
	
	/* 	Module Information
 	   	Module Name: SongUserPair
		Date of Creation: 08-11-2023
		Name of Creator of the module: Annie Soundari Muthuraj
		History of modification: [Date] - NA
		Summary: This class manages the palyList for a specific user.
	*/
	
	public UserPlayList(int capacity) {
		try {
			if(capacity<=0) {
				throw new IllegalArgumentException("Capacity must be greater than 0");
			}
			this.capacity = capacity;
			songsQueue = new LinkedList<>();
		}catch(Exception e) {
			System.err.println("Exception: " +e.getMessage());
		}
	}
	
	public void addSong(String song) {
		try {
			if(song==null) {
				throw new IllegalArgumentException("Song must not be null");
			}
			if(songsQueue.size() == capacity) {
				songsQueue.poll(); //remove the least recently played song
			}
			songsQueue.offer(song);
		}catch(Exception e) {
			System.err.println("Exception: " +e.getMessage());
		}
	}
	
	public List<String> getRecentlyPlayed(){
		return new ArrayList<>(songsQueue);
	}
	
	public void setCapacity(int newCapacity) {
		try {
			if(newCapacity<=0) {
				throw new IllegalArgumentException("New Capacity must be greater than 0");
			}
			capacity = newCapacity;
			while(songsQueue.size() > capacity) {
			songsQueue.poll(); //remove excess songs if the new capacity is smaller
			}
	   }catch(Exception e) {
		System.err.println("Exception: " +e.getMessage());
	}
  }
}

