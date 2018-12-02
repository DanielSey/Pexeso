package sample.others;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class CheckBack {

    private Alert alert;

    public CheckBack(Alert.AlertType alType, String conText, ButtonType but1){
        alert = new Alert(alType, conText, but1);
    }

    public CheckBack(Alert.AlertType alType, String conText, ButtonType but1, ButtonType but2){
        alert = new Alert(alType, conText, but1, but2);
    }

    public CheckBack(Alert.AlertType alType, String conText, ButtonType but1, ButtonType but2, ButtonType but3){
        alert = new Alert(alType, conText, but1, but2, but3);
    }

    public Alert getAlert() {
        return alert;
    }
}
