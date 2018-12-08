package sample.game;

import sample.others.Images;
import sample.others.CheckBack;
import sample.others.Music;
import sample.others.ButtonClass;
import sample.setup.Board;
import sample.setup.Card;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Game {

    private int WIDTH = 670;
    private int HEIGHT = 650;

    private Stage mainWindow;
    private Stage gameWindow;
    private Group root;
    private Images _images = new Images();
    private Board _board;

    private Music _music = new Music();
    private MediaPlayer mediaPlayer;

    private int numberOfPairs;

    public Game(Stage stage, int numberOfPairs){
        this.numberOfPairs = numberOfPairs;
        mainWindow = stage;
        gameWindow = new Stage();
        _board = new Board(mainWindow, gameWindow, numberOfPairs);

        gameWindow.setTitle("Pexeso - Game");
        root = new Group();
        Scene gameScene = new Scene(root);
        gameWindow.setScene(gameScene);
        if(numberOfPairs > 8){
            WIDTH *= 1.7;
        }
        Canvas canvas2 = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas2);

        //code
        setBackground();
        setBoard();
        setBackBut();

        gameWindow.show();
    }

    private void setBackground(){
        Images _images = new Images();
        ImageView iwBackground = new ImageView(_images.getMenuBackground2());
        iwBackground.setFitWidth(WIDTH);
        iwBackground.setFitHeight(HEIGHT);
        root.getChildren().add(iwBackground);
    }


    private void setBoard() {

        int posX = 50;
        int posY = 50;

        for (Card c : _board.getArrCard()) {
            c.getBut().setLayoutX(posX);
            c.getBut().setLayoutY(posY);
            root.getChildren().add(c.getBut());
            posX += 150;
            if(numberOfPairs > 8){
                if (posX > 950) {
                    posY += 150;
                    posX = 50;
                }
            }
            else {
                if (posX > 500) {
                    posY += 150;
                    posX = 50;
                }
            }
        }

    }

    private void setBackBut(){
        ImageView iw = new ImageView(_images.getBackImage());
        ButtonClass _button = new ButtonClass(-50, 0, 0.5, 0.6, iw);
        root.getChildren().add(_button.getButton());

        _button.getButton().setOnAction(event1 -> {
            mediaPlayer = new MediaPlayer(_music.getClick());
            mediaPlayer.play();

            CheckBack _cb = new CheckBack(Alert.AlertType.CONFIRMATION,"Game is not finished. Your progress will be lost.\nDo you really want to quit?", ButtonType.YES, ButtonType.CANCEL);
            _cb.getAlert().showAndWait();

            if (_cb.getAlert().getResult() == ButtonType.YES) {
                mainWindow.show();
                gameWindow.hide();
            }
        });
    }
}
