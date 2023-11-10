package com.testvargrant.musicstore.tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.testvagrant.musicstore.PlayStoreManager;
import com.testvagrant.musicstore.SongUserPair;
import com.testvagrant.musicstore.UserPlayList;

public class MusicStoreTests {
	
	@Test
	public void testSongUserPair() {
		SongUserPair pair = new SongUserPair("User1", "S1");
		Assert.assertEquals("User1",pair.getUser());
		Assert.assertEquals("S1", pair.getSong());
	}
	
	@Test
	public void testUserPlaylist() {
        UserPlayList playlist = new UserPlayList(3);
        playlist.addSong("S1");
        playlist.addSong("S2");
        List<String> songs = playlist.getRecentlyPlayed();
        Assert.assertEquals(2, songs.size());
        Assert.assertTrue(songs.contains("S1"));
        Assert.assertTrue(songs.contains("S2"));

        playlist.setCapacity(1);
        songs = playlist.getRecentlyPlayed();
        Assert.assertEquals(1, songs.size());
    }
	
	@Test
    public void testRecentlyPlayedStoreManager() {
        PlayStoreManager manager = new PlayStoreManager();
        manager.addSong("User1", "S1");
        manager.addSong("User1", "S2");
        List<String> songs = manager.getRecentlyPlayed("User1");
        Assert.assertEquals(2, songs.size());
        Assert.assertTrue(songs.contains("S1"));
        Assert.assertTrue(songs.contains("S2"));

        manager.setCapacity("User1", 1);
        songs = manager.getRecentlyPlayed("User1");
        Assert.assertEquals(1, songs.size());
    }
}
