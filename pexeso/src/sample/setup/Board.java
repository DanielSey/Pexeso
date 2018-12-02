package sample.setup;

import sample.others.Music;
import sample.game.EndGame;

import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Board {

    private static final int numberOfPairs = 8;

    private Music _music = new Music();
    private ArrayList<Card> arrLiCard = new ArrayList<Card>();
    private int count = 0;

    private Card _card1;
    private Card _card2;

    private Button but1;
    private Button but2;

    private Stage mainWindow;
    private Stage gameWindow;

    private long startTime;
    private long endTime;

    public Board(Stage stage, Stage stage2){
        startTime = System.currentTimeMillis();
        gameWindow = stage2;
        mainWindow = stage;
        generatePairs();
        Collections.shuffle(arrLiCard);
    }

    private void addEvent(Card card){

        Button button = card.getBut();

        EventHandler<MouseEvent> event = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if(count == -1){
                    but1.setDisable(false);
                    but2.setDisable(false);
                    _card1.backFlip();
                    _card2.backFlip();
                    _card1 = null;
                    _card2 = null;
                    count++;
                }

                count++;

                if(count == 1){
                    MediaPlayer mediaPlayer = new MediaPlayer(_music.getSwitchCard());
                    mediaPlayer.play();

                    animation(card.getBut());
                    card.flip();
                    _card1 = card;
                    but1 = card.getBut();
                    but1.setDisable(true);
                }
                if(count == 2){
                    MediaPlayer mediaPlayer = new MediaPlayer(_music.getSwitchCard());
                    mediaPlayer.play();

                    animation(card.getBut());
                    card.flip();
                    _card2 = card;
                    but2 = card.getBut();
                    but2.setDisable(true);

                    if(_card1.getCardId() == _card2.getCardId()){
                        MediaPlayer mediaPlayer2 = new MediaPlayer(_music.getApplause());
                        mediaPlayer2.play();

                        //System.out.println("trefa!");
                        count = 0;
                        arrLiCard.remove(_card2);
                        arrLiCard.remove(_card1);
                        _card1 = null;
                        _card2 = null;
                    }
                    else {
                        //System.out.println("vedle!");
                        count = -1;
                    }
                }
                if(arrLiCard.size() <= 0){
                    MediaPlayer mediaPlayer = new MediaPlayer(_music.getEndApplause());
                    mediaPlayer.play();

                    //System.out.println("Konec!");

                    endTime = System.currentTimeMillis() - startTime;
                    endTime = endTime / 1000;
                    EndGame _endGame = new EndGame(mainWindow, gameWindow, endTime);
                }
            }
        };

        button.setOnMouseClicked(event);
    }

    private void animation(Button b){
        FadeTransition ft = new FadeTransition();
        ft.setNode(b);
        ft.setDuration(new Duration(1000));
        ft.setFromValue(1.0);
        ft.setToValue(0.5);
        ft.setCycleCount(2);
        ft.setAutoReverse(true);
        ft.play();
    }

    private void generatePairs(){
        Card card1;
        Card card2;
        Random rnd = new Random();
        int a;
        for(int i = 0; i < numberOfPairs; i++){
            while (true) {
                a = rnd.nextInt(16);
                if (isFree(a)) {
                    //card1 = new Card(a, i); //just testing
                    card1 = new Card();
                    card1.setPosition(a);
                    card1.setId(i);
                    card1.setColor(i);
                    addEvent(card1);
                    break;
                }
            }
            while (true) {
                a = rnd.nextInt(16);
                if (isFree(a)) {
                    //card2 = new Card(a, i); //just testing
                    card2 = new Card();
                    card2.setPosition(a);
                    card2.setId(i);
                    card2.setColor(i);
                    addEvent(card2);
                    break;
                }
            }
            arrLiCard.add(card1);
            arrLiCard.add(card2);
        }
    }

    private boolean isFree(int position){
        for(Card a: arrLiCard){
            if(position == a.getPosition()) return false;
        }
        return true;
    }

    public ArrayList<Card> getArrCard(){
        return arrLiCard;
    }
}
