package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class form6Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_geri;

    @FXML
    void btn_geri_Click(ActionEvent event) {
    	Stage stage;
    	stage=(Stage) btn_geri.getScene().getWindow();
    	stage.close();


    }

    @FXML
    void initialize() {
        assert btn_geri != null : "fx:id=\"btn_geri\" was not injected: check your FXML file 'form6.fxml'.";

    }

}
