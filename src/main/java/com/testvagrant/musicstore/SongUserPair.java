package com.testvagrant.musicstore;

public class SongUserPair {

	private String user;
	private String song;
	
	/*  Module Information
     	Module Name: SongUserPair
    	Date of Creation: 08-11-2023
    	Name of Creator of the module: Annie Soundari Muthuraj
    	History of modification: [Date] - NA
    	Summary: This class represents the association between a song and a user.
	 */
	public SongUserPair(String user, String song) {
		try {
			if(user==null || song==null) {
				throw new IllegalArgumentException("User and Song must not be null");
			}
			this.user = user;
			this.song = song;
		}catch(Exception e) {
			System.err.println("Exception: " +e.getMessage());
		}
			
	}
	
	public String getUser() {
		return user;
	}
	
	public String getSong() {
		return song;
	}
}
