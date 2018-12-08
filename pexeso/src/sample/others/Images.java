package sample.others;

import javafx.scene.image.Image;

public class Images {

    private static final int NUMBER_OF_IMAGES = 15; //number of cards + 1

    private Image imgBlack;
    private Image menuBackground;
    private Image menuBackground2;
    private Image menuBackground3;
    private Image playImage;
    private Image exitImage;
    private Image statsImage;
    private Image backImage;
    private Image saveImage;
    private Image resetImage;
    private Image[] arrOfImages;

    public Images(){
        resetImage = new Image("res/img/menu/reset.png");
        statsImage = new Image("res/img/menu/statistics.png");
        saveImage = new Image("res/img/menu/save.png");
        backImage = new Image("res/img/menu/back.png");
        exitImage = new Image("res/img/menu/exit.png");
        playImage = new Image("res/img/menu/play.png");
        menuBackground = new Image("res/img/menu/background.jpg");
        menuBackground2 = new Image("res/img/menu/background2_670x650.jpg");
        menuBackground3 = new Image("res/img/menu/background3.jpg");
        imgBlack = new Image("res/img/cards/black.png");

        arrOfImages = new Image[NUMBER_OF_IMAGES];

        for(int i = 0; i < NUMBER_OF_IMAGES; i++){
            arrOfImages[i] = new Image("res/img/cards/card" + i + ".png");
        }
    }

    public Image getImage(int index){
        return arrOfImages[index];
    }

    public Image getImgBlack() {
        return imgBlack;
    }

    public Image getMenuBackground() {
        return menuBackground;
    }

    public Image getPlayImage() {
        return playImage;
    }

    public Image getExitImage() {
        return exitImage;
    }

    public Image getStatsImage() {
        return statsImage;
    }

    public Image getBackImage() {
        return backImage;
    }

    public Image getSaveImage() {
        return saveImage;
    }

    public Image getMenuBackground2() {
        return menuBackground2;
    }

    public Image getMenuBackground3() {
        return menuBackground3;
    }

    public Image getResetImage() {
        return resetImage;
    }
}
