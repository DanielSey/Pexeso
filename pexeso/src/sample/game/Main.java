package sample.game;

import sample.others.Images;
import sample.others.CheckBack;
import sample.others.Music;
import sample.others.ButtonClass;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Main extends Application {

    private Group root;
    private Images _images = new Images();

    private ButtonClass _butPlay = null;
    private ButtonClass _butStats = null;
    private ButtonClass _butExit = null;

    private Music _music = new Music();
    private MediaPlayer mediaPlayer;

    @Override
    public void start(Stage primaryStage) throws Exception{
        /*--------------------------------main--------------------------------*/
        primaryStage.setTitle("Pexeso - menu");
        root = new Group();
        Scene theScene = new Scene(root);
        primaryStage.setScene(theScene);
        //primaryStage.setResizable(false);
        Canvas canvas = new Canvas(560, 385);
        root.getChildren().add(canvas);
        //GraphicsContext gc = canvas.getGraphicsContext2D();
        /*--------------------------------main--------------------------------*/

        //code
        setBackground();
        setButtons();

        //PLAY BUTTON
        _butPlay.getButton().setOnAction(event -> {
            mediaPlayer = new MediaPlayer(_music.getClick());
            mediaPlayer.play();

            primaryStage.hide();
            Game _game = new Game(primaryStage);
        });

        //STATS BUTTON
        _butStats.getButton().setOnAction(event -> {
            mediaPlayer = new MediaPlayer(_music.getClick());
            mediaPlayer.play();

            Stats _stats = new Stats();
        });

        //EXIT BUTTON
        _butExit.getButton().setOnAction(event -> {
            mediaPlayer = new MediaPlayer(_music.getClick());
            mediaPlayer.play();

            CheckBack _cb = new CheckBack(Alert.AlertType.CONFIRMATION,"Do you really want to quit?", ButtonType.YES, ButtonType.NO);
            _cb.getAlert().showAndWait();

            if (_cb.getAlert().getResult() == ButtonType.YES) {
                primaryStage.close();
            }
        });

        primaryStage.show();
    }

    public void setButtons(){
        //play button
        ImageView iw = new ImageView(_images.getPlayImage());
        _butPlay = new ButtonClass(150, 20, iw);
        root.getChildren().add(_butPlay.getButton());

        //stats button
        ImageView iw2 = new ImageView(_images.getStatsImage());
        _butStats = new ButtonClass(0, 100, 0.5, 0.7, iw2);
        root.getChildren().add(_butStats.getButton());

        //exit button
        ImageView iw3 = new ImageView(_images.getExitImage());
        _butExit = new ButtonClass(150, 300, 0.5, 0.5, iw3);
        root.getChildren().add(_butExit.getButton());
    }

    public void setBackground(){
        ImageView iwBackground = new ImageView(_images.getMenuBackground());
        root.getChildren().add(iwBackground);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
