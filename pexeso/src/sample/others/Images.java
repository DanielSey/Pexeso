package sample.others;

import javafx.scene.image.Image;

public class Images {

    private final Image imgBlack;
    private final Image menuBackground;
    private final Image menuBackground2;
    private final Image menuBackground3;
    private final Image playImage;
    private final Image exitImage;
    private final Image statsImage;
    private final Image backImage;
    private final Image saveImage;
    private final Image resetImage;
    private Image[] arrOfImages;

    public Images(){
        resetImage = new Image("res/img/menu/reset.png");
        statsImage = new Image("res/img/menu/statistics.png");
        saveImage = new Image("res/img/menu/save.png");
        backImage = new Image("res/img/menu/back.png");
        exitImage = new Image("res/img/menu/exit.png");
        playImage = new Image("res/img/menu/play.png");
        menuBackground = new Image("res/img/menu/background.jpg");
        menuBackground2 = new Image("res/img/menu/background2.jpg");
        menuBackground3 = new Image("res/img/menu/background3.jpg");
        imgBlack = new Image("res/img/cards/black.png");

        int numberOfImage = 8;
        arrOfImages = new Image[numberOfImage];

        for(int i = 0; i < numberOfImage; i++){
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
