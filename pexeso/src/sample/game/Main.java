package sample.game;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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

    private static final int WIDTH = 560;
    private static final int HEIGHT = 385;

    private static final int MAX_PAIRS = 15; //14 + 1

    private Group root;
    private Images _images = new Images();

    private ButtonClass _butPlay = null;
    private ButtonClass _butStats = null;
    private ButtonClass _butExit = null;

    private Music _music = new Music();
    private MediaPlayer mediaPlayer;

    private TextField textField;

    @Override
    public void start(Stage primaryStage) throws Exception{
        /*--------------------------------main--------------------------------*/
        primaryStage.setTitle("Pexeso - menu");
        root = new Group();
        Scene theScene = new Scene(root);
        primaryStage.setScene(theScene);
        //primaryStage.setResizable(false);
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);
        //GraphicsContext gc = canvas.getGraphicsContext2D();
        /*--------------------------------main--------------------------------*/

        //code
        setBackground();
        setButtons();
        setTextField();

        //PLAY BUTTON
        _butPlay.getButton().setOnAction(event -> {
            mediaPlayer = new MediaPlayer(_music.getClick());
            mediaPlayer.play();

            String numberOfPairsString = textField.getText();
            int numberOfPairs;

            if(textField.getText().isEmpty()){
                numberOfPairs = 8;
                startGame(primaryStage, numberOfPairs);
            }
            else{
                try {
                    numberOfPairs = Integer.parseInt(numberOfPairsString);
                    if(numberOfPairs > 0 && numberOfPairs < MAX_PAIRS){
                        startGame(primaryStage, numberOfPairs);
                    }
                    else {
                        setAlert("Error: bad input!\nYou entered: " + numberOfPairs + "\nYou must enter a number from 1 to " + (MAX_PAIRS-1) + ".");
                    }
                }catch (Exception e) {
                    setAlert("Error: " + e.getMessage() + "\nYou must enter a number from 1 to " + (MAX_PAIRS-1) + ".");
                }
            }
        });

        //STATS BUTTON
        _butStats.getButton().setOnAction(event -> {
            mediaPlayer = new MediaPlayer(_music.getClick());
            mediaPlayer.play();

            new Stats();
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

    private void startGame(Stage stage, int number){
        new Game(stage, number);
        stage.hide();
    }

    private void setAlert(String conText){
        CheckBack _cb = new CheckBack(Alert.AlertType.INFORMATION, conText, ButtonType.OK);
        _cb.getAlert().showAndWait();
    }

    private void setTextField(){
        Label label = new Label("Enter number of pairs(even count):");
        label.setLayoutX(100);
        label.setLayoutY(70);
        label.setTextFill(Color.WHITE);
        label.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        root.getChildren().add(label);

        textField = new TextField();
        textField.setPromptText("default: 8");
        textField.setLayoutX(200);
        textField.setLayoutY(100);
        root.getChildren().add(textField);
    }

    private void setButtons(){
        //play button
        ImageView iw = new ImageView(_images.getPlayImage());
        _butPlay = new ButtonClass(150, 20, iw);
        root.getChildren().add(_butPlay.getButton());

        //stats button
        ImageView iw2 = new ImageView(_images.getStatsImage());
        _butStats = new ButtonClass(0, 150, 0.5, 0.7, iw2);
        root.getChildren().add(_butStats.getButton());

        //exit button
        ImageView iw3 = new ImageView(_images.getExitImage());
        _butExit = new ButtonClass(150, 300, 0.5, 0.5, iw3);
        root.getChildren().add(_butExit.getButton());
    }

    private void setBackground(){
        ImageView iwBackground = new ImageView(_images.getMenuBackground());
        root.getChildren().add(iwBackground);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
