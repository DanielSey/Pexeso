package sample.setup;

import sample.others.Images;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Card {

    private int position;
    private int cardId;
    private Button but;
    private Images _images = new Images();
    private ImageView frontColor;

    public Card(){
        ImageView iw = new ImageView(_images.getImgBlack());
        but = new Button("", iw);
    }

    //just testing
    /*public Card(int index, int id){
        ImageView iw = new ImageView(_images.getImgBlack());
        but = new Button("" + index + ", " + id, iw);
    }*/

    private void setButId(int id){
        but.setId("" + id);
    }

    public Button getBut(){
        return but;
    }

    public void setColor(int color){
        frontColor = new ImageView(_images.getImage(color));
    }

    public void flip(){
        but.setGraphic(frontColor);
    }

    public void backFlip(){
        ImageView iw = new ImageView(_images.getImgBlack());
        but.setGraphic(iw);
    }

    public void setId(int id){
        setButId(position);
        this.cardId = id;
    }

    public int getCardId() {
        return this.cardId;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

}
