package model;

import java.io.File;
import java.net.URI;

/**
 * A model class that represents a song and all of its attributes (title, artist, duration, etc).
 *
 * @author Andrew Groebe.
 */
public final class Song {

    /**
     * The title of the song.
     */
    private final String title;

    /**
     * The artist of the song.
     */
    private final String artist;

    /**
     * The duration, in seconds, of the song.
     */
    private final int duration;

    /**
     * The title of the album.
     */
    private final String album;

    /**
     * The genre of the song.
     */
    private final Genre genre;

    public Song(String title, String artist, int duration, String album, Genre genre) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.album = album;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

    public String getAlbum() {
        return album;
    }

    public Genre getGenre() {
        return genre;
    }

    public URI getURI() {
        return new File("src/main/resources/store/mp3/" + title + ".mp3").toURI();
    }

    public URI getAlbumCover() {
        return new File("src/main/resources/store/jpg/" + album + ".jpg").toURI();
    }

    @Override
    public String toString() {
        return title + " - " + artist;
    }
}
