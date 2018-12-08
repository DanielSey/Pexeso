package sample.game;

import sample.others.Images;
import sample.others.CheckBack;
import sample.others.Music;
import sample.others.ButtonClass;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EndGame {

    private static final int WIDTH = 300;
    private static final int HEIGHT = 100;

    private Group root;
    private Stage mainWindow;
    private Stage gameWindow;
    private Stage endWindow;
    private Images _images = new Images();
    private ButtonClass _saveBut;
    private TextField textField;
    private Music _music = new Music();
    private MediaPlayer mediaPlayer;
    private long endTime;
    private int pairs;

    public EndGame(Stage stage, Stage stage2, long endTime, int pairs){
        gameWindow = stage2;
        mainWindow = stage;
        endWindow = new Stage();
        endWindow.setTitle("Pexeso - Save Score");
        root = new Group();
        Scene gameScene = new Scene(root);
        endWindow.setScene(gameScene);
        Canvas canvas2 = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas2);

        //code
        this.endTime = endTime;
        this.pairs = pairs;
        setTextField();
        setSubmitBut();
        setText();

        endWindow.show();
    }

    private void setText(){
        Label text = new Label("Enter your name:");
        text.setLayoutX(85);
        root.getChildren().add(text);
    }

    private void setTextField(){
        textField = new TextField();
        textField.setPromptText("Enter your name.");
        textField.setLayoutY(20);
        textField.setLayoutX(50);
        root.getChildren().add(textField);
    }

    private void setSubmitBut(){
        ImageView iw = new ImageView(_images.getSaveImage());
        _saveBut = new ButtonClass(0, 50, 0.5, 0.7, iw);
        root.getChildren().add(_saveBut.getButton());

        saveName();
    }

    private void saveName(){
        _saveBut.getButton().setOnAction(event1 -> {
            mediaPlayer = new MediaPlayer(_music.getClick());
            mediaPlayer.play();

            if(textField.getText().length() <= 2 || textField.getText().length() >= 6){
                CheckBack _ckBack = new CheckBack(Alert.AlertType.INFORMATION,"You must enter at least 3 characters! Maximum is 5 chars.", ButtonType.OK);
                _ckBack.getAlert().showAndWait();
            }
            else {
                String name = textField.getText();

                File file = new File("score.txt");
                try {
                    BufferedWriter output = new BufferedWriter(new FileWriter(file, true));
                    output.newLine();
                    output.append(name + "              " + endTime + "              " + pairs); //2x7 |_|
                    output.close();
                } catch (IOException ex1) {
                    System.out.printf("ERROR writing score to file: %s\n", ex1);
                }

                endWindow.hide();
                gameWindow.hide();
                mainWindow.show();
            }
        });
    }
}
