package org.CS5800.Music;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class CachingSongServiceTest {
    private CachingSongService cachingService;
    private RealSongService realService;

    @Before
    public void setUp() {
        realService = new RealSongService();
        cachingService = new CachingSongService(realService);
    }

    @Test
    public void testCachingMechanism() {
        long startTime = System.currentTimeMillis();
        cachingService.getSong("Song 1");
        long duration = System.currentTimeMillis() - startTime;
        startTime = System.currentTimeMillis();
        cachingService.getSong("Song 1");
        long cachedDuration = System.currentTimeMillis() - startTime;
        assertTrue(duration > cachedDuration);
    }

    @Test
    public void testCachingDataIntegrity() {
        Song song = cachingService.getSong("Song 1");
        assertEquals("Song 1", song.getTitle());
        Song cachedSong = cachingService.getSong("Song 1");
        assertEquals("Song 1", cachedSong.getTitle());
        assertEquals(song.getArtist(), cachedSong.getArtist());
        assertEquals(song.getAlbum(), cachedSong.getAlbum());
        assertEquals(song.getDuration(), cachedSong.getDuration());
    }

    @Test
    public void testCacheForDifferentMethods() {
        List<Song> songsByArtist = cachingService.getSongsByArtist("Artist 1");
        assertNotNull(songsByArtist);
        assertEquals(2, songsByArtist.size());
        List<Song> cachedSongsByArtist = cachingService.getSongsByArtist("Artist 1");
        assertEquals(songsByArtist.size(), cachedSongsByArtist.size());
    }
}

