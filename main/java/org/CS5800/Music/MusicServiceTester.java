package org.CS5800.Music;

import java.util.List;

public class MusicServiceTester {
    public static void main(String[] args) {
        SongService realService = new RealSongService();
        SongService cachingService = new CachingSongService(realService);

        // Test getting songs by different artists
        printSongs(cachingService.getSongsByArtist("Iron Maiden"));
        printSongs(cachingService.getSongsByArtist("Dio"));
        printSongs(cachingService.getSongsByArtist("Radiohead"));
        printSongs(cachingService.getSongsByArtist("Smash Mouth"));
    }

    private static void printSongs(List<Song> songs) {
        for (Song song : songs) {
            System.out.println(song);
        }
        System.out.println();
    }
}

