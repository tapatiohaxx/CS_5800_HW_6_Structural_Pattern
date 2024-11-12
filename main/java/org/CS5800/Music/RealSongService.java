package org.CS5800.Music;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RealSongService implements SongService {
    private List<Song> songs = new ArrayList<>();

    public RealSongService() {
        initializeSongs();
    }

    private void initializeSongs() {
        addSong(new Song("Alexander The Great", "Iron Maiden", "Somewhere in Time", 438));
        addSong(new Song("The Trooper", "Iron Maiden", "Piece of Mind", 246));
        addSong(new Song("Holy Diver", "Dio", "Holy Diver", 270));
        addSong(new Song("Rainbow in the Dark", "Dio", "Holy Diver", 255));
        addSong(new Song("Creep", "Radiohead", "Pablo Honey", 238));
        addSong(new Song("Karma Police", "Radiohead", "OK Computer", 264));
        addSong(new Song("All Star", "Smash Mouth", "Astro Lounge", 203));
        addSong(new Song("Walking on the Sun", "Smash Mouth", "Fush Yu Mang", 200));
        addSong(new Song("Run to the Hills", "Iron Maiden", "The Number of the Beast", 231));
        addSong(new Song("OK Computer", "Radiohead", "OK Computer", 240));
    }

    void addSong(Song song) {
        songs.add(song);
    }

    private void simulateNetworkDelay() {
        try {
            Thread.sleep(1000); // simulate 1 second network delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public Song getSong(String title) {
        simulateNetworkDelay();
        return songs.stream().filter(song -> song.getTitle().equals(title)).findFirst().orElse(null);
    }

    @Override
    public List<Song> getSongsByArtist(String artist) {
        simulateNetworkDelay();
        return songs.stream().filter(song -> song.getArtist().equals(artist)).collect(Collectors.toList());
    }

    @Override
    public List<Song> getSongsByAlbum(String album) {
        simulateNetworkDelay();
        return songs.stream().filter(song -> song.getAlbum().equals(album)).collect(Collectors.toList());
    }
}

