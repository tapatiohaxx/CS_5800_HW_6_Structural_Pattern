package org.CS5800.Music;

import static org.junit.Assert.*;
import org.junit.Test;

public class SongTest {
    @Test
    public void testSongProperties() {
        Song song = new Song("OK, Computer", "Radiohead", "OK, Computer", 300);
        assertEquals("OK, Computer", song.getTitle());
        assertEquals("Radiohead", song.getArtist());
        assertEquals("OK, Computer", song.getAlbum());
        assertEquals(300, song.getDuration());
    }

    @Test
    public void testToString() {
        Song song = new Song("OK, Computer", "Radiohead", "OK, Computer", 300);
        String expected = "Song[title=OK, Computer, artist=Radiohead, album=OK, Computer, duration=300s]";
        assertEquals(expected, song.toString());
    }
}
