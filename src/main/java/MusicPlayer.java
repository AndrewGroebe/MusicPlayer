import com.google.gson.Gson;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.Song;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The music player model in this application. A single instance of this class is created when the application is
 * started and only that instance is used.
 *
 * @author Andrew Groebe.
 */
public final class MusicPlayer {

    /**
     * In accordance with the singleton design pattern, this object represents the only instance of this class to be used
     * by other files.
     */
    private static final MusicPlayer SINGLETON = new MusicPlayer();

    private final ArrayList<Song> songs = new ArrayList<Song>();

    private MediaPlayer mediaPlayer;

    public MusicPlayer() {
        loadSongs();
    }

    /**
     * Plays the provided song.
     * @param song The song to play.
     */
    public void play(Song song) {
        Media media = new Media(song.getURI().toString());
        if (mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            mediaPlayer.stop();
        }
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    /**
     * Loads the songs and their required data from external storage.
     */
    private void loadSongs() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/store/songs.json"));
            Song[] songs = new Gson().fromJson(reader, Song[].class);
            this.songs.addAll(Arrays.asList(songs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public static MusicPlayer getSingleton() {
        return SINGLETON;
    }

}
