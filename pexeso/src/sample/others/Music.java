package sample.others;

import javafx.scene.media.Media;

import java.io.File;

public class Music {

    private Media switchCard;
    private Media applause;
    private Media endApplause;
    private Media click;

    public Music(){
        switchCard = new Media(new File("src/res/sound/switchCard.mp3").toURI().toString());
        applause = new Media(new File("src/res/sound/applause.mp3").toURI().toString());
        endApplause = new Media(new File("src/res/sound/endApplause.mp3").toURI().toString());
        click = new Media(new File("src/res/sound/click1.wav").toURI().toString());
    }

    public Media getSwitchCard() {
        return switchCard;
    }

    public Media getApplause() {
        return applause;
    }

    public Media getEndApplause() {
        return endApplause;
    }

    public Media getClick() {
        return click;
    }
}
