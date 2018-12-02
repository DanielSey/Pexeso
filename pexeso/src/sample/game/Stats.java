package sample.game;

import sample.others.Images;
import sample.others.CheckBack;
import sample.others.Music;
import sample.others.ButtonClass;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Stats {

    private Stage statsWindow;
    private Group root;
    private Images _images = new Images();

    private Music _music = new Music();
    private MediaPlayer mediaPlayer;

    private ArrayList<String> arrLiScore = new ArrayList<>();
    private ListView<String> listView;

    public Stats(){
        statsWindow = new Stage();
        statsWindow.setTitle("Pexeso - Statistics");
        root = new Group();
        Scene statsScene = new Scene(root);
        statsWindow.setScene(statsScene);
        Canvas canvas3 = new Canvas(500, 500);
        root.getChildren().add(canvas3);

        //code
        setBackground();
        setBackBut();
        setResetBut();
        loadStats();
        loadListView();

        statsWindow.show();
    }

    private void setBackground(){
        Images _images = new Images();
        ImageView iwBackground = new ImageView(_images.getMenuBackground3());
        root.getChildren().add(iwBackground);
    }

    private void setBackBut(){
        ImageView iw = new ImageView(_images.getBackImage());
        ButtonClass _button = new ButtonClass(240, 30, 0.5, 1.0, iw);
        root.getChildren().add(_button.getButton());

        _button.getButton().setOnAction(event1 -> {
            mediaPlayer = new MediaPlayer(_music.getClick());
            mediaPlayer.play();

            statsWindow.hide();
        });
    }

    private void setResetBut(){
        ImageView iw = new ImageView(_images.getResetImage());
        ButtonClass _button = new ButtonClass(230, 370, 0.5, 1.0, iw);
        root.getChildren().add(_button.getButton());

        _button.getButton().setOnAction(event -> {
            mediaPlayer = new MediaPlayer(_music.getClick());
            mediaPlayer.play();

            CheckBack _ckReset = new CheckBack(Alert.AlertType.CONFIRMATION,"Do you really want to reset statistics?", ButtonType.YES, ButtonType.CANCEL, ButtonType.NO);
            _ckReset.getAlert().showAndWait();

            if (_ckReset.getAlert().getResult() == ButtonType.YES) {
                listView.getItems().removeAll();
                arrLiScore.clear();
                resetFile();

                statsWindow.hide();
            }
        });
    }

    private void resetFile(){
        File file = new File("score.txt");
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.print("Name       Time"); //7x
            writer.close();
        } catch (IOException ex1) {
            System.out.printf("ERROR writing score to file: %s\n", ex1);
        }
    }

    private void loadListView(){
        listView = new ListView<>();
        for(int i = 0; i < arrLiScore.size(); i++) {
            listView.getItems().add(arrLiScore.get(i));
        }

        listView.setLayoutX(50);
        listView.setLayoutY(30);
        listView.setPadding(new Insets(20, 20, 20, 20));
        root.getChildren().add(listView);
    }

    private void loadStats(){
        BufferedReader reader = null;
        try {
            File file = new File("score.txt");
            reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                arrLiScore.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
