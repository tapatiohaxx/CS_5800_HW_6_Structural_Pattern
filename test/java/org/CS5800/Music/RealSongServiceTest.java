package org.CS5800.Music;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RealSongServiceTest {
    private RealSongService service;

    @BeforeEach
    public void setUp() {
        service = new RealSongService();
        service.addSong(new Song("Fear of the Dark", "Iron Maiden", "Fear of the Dark", 438));
        service.addSong(new Song("The Trooper", "Iron Maiden", "Piece of Mind", 246));
        service.addSong(new Song("Holy Diver", "Dio", "Holy Diver", 270));
        service.addSong(new Song("Creep", "Radiohead", "Pablo Honey", 238));
        service.addSong(new Song("Karma Police", "Radiohead", "OK Computer", 264));
        service.addSong(new Song("All Star", "Smash Mouth", "Astro Lounge", 203));
        service.addSong(new Song("Walking on the Sun", "Smash Mouth", "Fush Yu Mang", 200));
    }

    @Test
    void testGetSongFound() {
        Song song = service.getSong("Fear of the Dark");
        assertNotNull(song, "Song should be found");
        assertEquals("Fear of the Dark", song.getTitle(), "Song title should match");
    }

    @Test
    void testGetSongNotFound() {
        Song song = service.getSong("Unknown Song");
        assertNull(song, "Song should not be found");
    }

    @Test
    void testGetSongsByArtistMultipleMatches() {
        List<Song> songs = service.getSongsByArtist("Radiohead");
        assertNotNull(songs, "Result should not be null");
        assertEquals(2, songs.size(), "Should find two songs by Radiohead");
    }

    @Test
    void testGetSongsByArtistNoMatch() {
        List<Song> songs = service.getSongsByArtist("Unknown Artist");
        assertTrue(songs.isEmpty(), "Should not find any songs");
    }

    @Test
    void testGetSongsByAlbum() {
        List<Song> songs = service.getSongsByAlbum("OK Computer");
        assertNotNull(songs, "Result should not be null");
        assertEquals(2, songs.size(), "Should find two songs in OK Computer album");
    }

    @Test
    void testGetSongsByAlbumNoMatch() {
        List<Song> songs = service.getSongsByAlbum("Unknown Album");
        assertTrue(songs.isEmpty(), "Should not find any songs");
    }
}

