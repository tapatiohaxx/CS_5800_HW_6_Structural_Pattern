package org.CS5800.Music;

public class Song {
    private String title;
    private String artist;
    private String album;
    private int duration; // duration in seconds

    public Song(String title, String artist, String album, int duration) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return String.format("Song[title=%s, artist=%s, album=%s, duration=%ds]", title, artist, album, duration);
    }
}

