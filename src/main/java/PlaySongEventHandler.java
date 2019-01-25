import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.Song;

/**
 * A {@link EventHandler} that triggers whenever the user clicks a song from the song list.
 *
 * @author Andrew Groebe.
 */
public final class PlaySongEventHandler implements EventHandler<MouseEvent> {

    /**
     * The instance of {@link TreeView} required to retrieve the appropriate instances of {@Song}.
     */
    private final TreeView treeView;

    /**
     * The instance of {@link Scene} currently being used.
     */
    private final Scene scene;

    public PlaySongEventHandler(TreeView treeView, Scene scene) {
        this.treeView = treeView;
        this.scene = scene;
    }

    /**
     * The method called when this event is triggered.
     *
     * @param event the intercepted mouse event.
     */
    public void handle(MouseEvent event) {
        Node node = event.getPickResult().getIntersectedNode();
        if (node instanceof Text) {
            Song song = (Song) ((TreeItem) treeView.getSelectionModel().getSelectedItem()).getValue();
            MusicPlayer.getSingleton().play(song);
            ImageView imageView = (ImageView) scene.lookup("#albumcover");
            imageView.setImage(new Image(song.getAlbumCover().toString()));
            System.out.println(imageView.getX());
        }


    }

}
