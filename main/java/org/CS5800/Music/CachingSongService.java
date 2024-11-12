package org.CS5800.Music;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CachingSongService implements SongService {
    private SongService realService;
    private Map<String, Song> songCache;
    private Map<String, List<Song>> artistCache;
    private Map<String, List<Song>> albumCache;

    public CachingSongService(SongService realService) {
        this.realService = realService;
        this.songCache = new HashMap<>();
        this.artistCache = new HashMap<>();
        this.albumCache = new HashMap<>();
    }

    @Override
    public Song getSong(String title) {
        if (!songCache.containsKey(title)) {
            songCache.put(title, realService.getSong(title));
        }
        return songCache.get(title);
    }

    @Override
    public List<Song> getSongsByArtist(String artist) {
        if (!artistCache.containsKey(artist)) {
            artistCache.put(artist, realService.getSongsByArtist(artist));
        }
        return artistCache.get(artist);
    }

    @Override
    public List<Song> getSongsByAlbum(String album) {
        if (!albumCache.containsKey(album)) {
            albumCache.put(album, realService.getSongsByAlbum(album));
        }
        return albumCache.get(album);
    }
}
