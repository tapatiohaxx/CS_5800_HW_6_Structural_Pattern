package org.CS5800.Music;

import java.util.List;

public interface SongService {
    Song getSong(String title);
    List<Song> getSongsByArtist(String artist);
    List<Song> getSongsByAlbum(String album);
}

