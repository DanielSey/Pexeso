package sample.others;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;

public class ButtonClass {

    private Button button;

    public ButtonClass(int posX, int posY, ImageView iw){
        button = new Button("", iw);
        button.setLayoutX(posX);
        button.setLayoutY(posY);
    }

    public ButtonClass(int posX, int posY, double scaleX, double scaleY, ImageView iw){
        button = new Button("", iw);
        button.setLayoutX(posX);
        button.setLayoutY(posY);
        button.setScaleX(scaleX);
        button.setScaleY(scaleY);
    }

    public Button getButton() {
        return button;
    }
}
