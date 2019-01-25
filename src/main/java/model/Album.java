package model;

import java.util.ArrayList;
import java.util.Arrays;

public final class Album {

    /**
     * The title of the album.
     */
    private final String title;

    /**
     * The contents of the album; the collection of songs.
     */
    private final ArrayList<Song> contents;

    public Album(String title, Song... songs) {
        this.title = title;
        contents = (ArrayList<Song>) Arrays.asList(songs);
    }

    public String getTitle() {
        return title;
    }
}
