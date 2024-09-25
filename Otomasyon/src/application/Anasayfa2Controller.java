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

public class Anasayfa2Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private Button button_sifre;
    
    @FXML
    private URL location;

    @FXML
    private Button Devamsızlık;

    @FXML
    private Button btnCıkıs;

    @FXML
    private Button dersProgramı;

    @FXML
    private Button odemeler;

    @FXML
    private Button odemeler1;

    @FXML
    private Button ogr_bilgi;

    @FXML
    private Button ögrt_bilgi;

    @FXML
    void Devamsızlık_Click(ActionEvent event) {
    	try {
    		Stage stage1=new Stage();
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("form9.fxml"));
    		Scene scene=new Scene(pane1);
    		stage1.setScene(scene);
    		stage1.show();
    		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

    }

    @FXML
    void btnCıkıs_Click(ActionEvent event) {
    	Stage stage;
       	stage=(Stage) btnCıkıs.getScene().getWindow();
       	stage.close();

    }

    @FXML
    void dersProgramı_Click(ActionEvent event) {
    	try {
    		Stage stage1=new Stage();
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("Program.fxml"));
    		Scene scene=new Scene(pane1);
    		stage1.setScene(scene);
    		stage1.show();
    		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

    }

    @FXML
    void odemeler1_Click(ActionEvent event) {//öğretmen ödemeleri
    	try {
    		Stage stage1=new Stage();
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("OgretmenUcret.fxml"));
    		Scene scene=new Scene(pane1);
    		stage1.setScene(scene);
    		stage1.show();
    		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}


    }

    @FXML
    void odemeler_Click(ActionEvent event) {//öğrenci ödemeleri
    	try {
    		Stage stage1=new Stage();
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("OgrenciUcret2.fxml"));
    		Scene scene=new Scene(pane1);
    		stage1.setScene(scene);
    		stage1.show();
    		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}


    }
    
    @FXML
    void button_sifre_click(ActionEvent event) {
    	try {
    		Stage stage1=new Stage();
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("Sifre2.fxml"));
    		Scene scene=new Scene(pane1);
    		stage1.setScene(scene);
    		stage1.show();
    		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}


    }


    @FXML
    void ogr_bilgi_Click(ActionEvent event) {
    	try {
    		Stage stage1=new Stage();
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("Ogrenci2.fxml"));
    		Scene scene=new Scene(pane1);
    		stage1.setScene(scene);
    		stage1.show();
    		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}


    }

    @FXML
    void ögrt_bilgi_Click(ActionEvent event) {
    	try {
    		Stage stage1=new Stage();
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("Ogretmen2.fxml"));
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

