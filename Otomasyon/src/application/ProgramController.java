package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ProgramController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn10;

    @FXML
    private Button btn11;

    @FXML
    private Button btn12;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Button btn_cıkıs;

    @FXML
    void btn11_Click(ActionEvent event) {
      	try {
    		Stage stage1=new Stage();
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("form6.fxml"));
    		Scene scene=new Scene(pane1);
    		stage1.setScene(scene);
    		stage1.show();
    		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}


    }

    @FXML
    void btn12_Click(ActionEvent event) {
    	try {
    		Stage stage1=new Stage();
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("form7.fxml"));
    		Scene scene=new Scene(pane1);
    		stage1.setScene(scene);
    		stage1.show();
    		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}



    }

    @FXML
    void btn8_Click(ActionEvent event) {
    	try {
    		Stage stage1=new Stage();
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("form3.fxml"));
    		Scene scene=new Scene(pane1);
    		stage1.setScene(scene);
    		stage1.show();
    		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

    }

    @FXML
    void btn9_Click(ActionEvent event) {
    	try {
    		Stage stage1=new Stage();
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("form4.fxml"));
    		Scene scene=new Scene(pane1);
    		stage1.setScene(scene);
    		stage1.show();
    		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

    }
    

    @FXML
    void btn_cıkıs_click(ActionEvent event) {

    
        Stage stage;
    	stage=(Stage) btn_cıkıs.getScene().getWindow();
    	stage.close();
    	

    }

    @FXML
    void byn10_Click(ActionEvent event) {
    	try {
    		Stage stage1=new Stage();
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("form5.fxml"));
    		Scene scene=new Scene(pane1);
    		stage1.setScene(scene);
    		stage1.show();
    		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

    }

    @FXML
    void initialize() {
        

    }

}
