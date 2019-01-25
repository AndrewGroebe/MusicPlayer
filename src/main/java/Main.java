import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Song;


/**
 * The entry point of this JavaFX application; starts the program and triggers subsequent startup tasks.
 *
 * @author Andrew Groebe.
 */
public final class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent layout = FXMLLoader.load(getClass().getResource("/layout.fxml"));
        Scene scene = new Scene(layout, 1200, 700);

        // Populate the song list. This needs to be done manually so each TreeItem can encapsulate its respective instance of model.Song.
        final TreeView treeView = (TreeView) scene.lookup("#songlist");
        TreeItem root = new TreeItem<String>("Songs");
        for (Song song : MusicPlayer.getSingleton().getSongs()) {
            TreeItem<Song> treeItem = new TreeItem<Song>(song);
            root.getChildren().add(treeItem);
        }
        treeView.addEventHandler(MouseEvent.MOUSE_CLICKED, new PlaySongEventHandler(treeView, scene));

        treeView.setRoot(root);
        treeView.setShowRoot(false);

        stage.setScene(scene);
        stage.setTitle("Music Player");
        stage.show();
    }



}