package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.otomasyonMysql.Util.OtomasyonUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Sifre2Controller {

	Connection baglanti=null;
	PreparedStatement sorgu=null;
	ResultSet getir=null;
	String sql;
	
	public Sifre2Controller() {
		baglanti=OtomasyonUtil.bagla();
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Kayıt_giris, String> AD;

    @FXML
    private TableColumn<Kayıt_giris, String> SİFRE;

    @FXML
    private TableColumn<Kayıt_giris, Integer> YETKİ;

    @FXML
    private Button buttonGeri;

    @FXML
    private Button button_guncelle;

    @FXML
    private TableView<Kayıt_giris> tablosifre;

    @FXML
    private TextField textAd;

    @FXML
    private PasswordField textSifre;

    @FXML
    private TextField textYetki;
    
    public void degerlerigetir(TableView<Kayıt_giris> tablo,String sql) {
  	   
    	ObservableList<Kayıt_giris>kayıt=FXCollections.observableArrayList();
    	try {
    		sorgu=baglanti.prepareStatement(sql);
    		ResultSet getirilen=sorgu.executeQuery();
    		while(getirilen.next()) {
    			kayıt.add(new Kayıt_giris(getirilen.getInt("ıd"),getirilen.getString("kullanıcıAD"),getirilen.getString("sifre")));
    		}
    		
    		YETKİ.setCellValueFactory(new PropertyValueFactory<>("ıd"));
    		AD.setCellValueFactory(new PropertyValueFactory<>("kullanıcıAD"));
    		SİFRE.setCellValueFactory(new PropertyValueFactory<>("sifre"));
    		

    		

    		tablosifre.setItems(kayıt);
    		
			
    		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
		}
    }

    @FXML
    void buttonGeri_Click(ActionEvent event) {
    	Stage stage;
       	stage=(Stage) buttonGeri.getScene().getWindow();
       	stage.close();

    }

    @FXML
    void button_guncelle_Click(ActionEvent event) {
    	sql="update giris set sifre=? where kullanıcıAD=? and ıd=?";
    	try {
    		if(textYetki.getText().equals("1")) {
    			sorgu=baglanti.prepareStatement(sql);
        		sorgu.setString(1,textAd.getText().trim());
        		sorgu.setString(3,textYetki.getText().trim());
        		sorgu.setString(2,OtomasyonUtil.MD5Sifreleme(textSifre.getText().trim()));
        		sorgu.executeUpdate();
        		
        		Alert alert=new Alert(AlertType.INFORMATION);
        		alert.setTitle("ŞİFRE DEĞİŞTİRME");
        		alert.setHeaderText("BİLGİ!");
        		alert.setContentText("şifre değiştirildi...");
        		alert.showAndWait();
        		textYetki.setText("");
        		textAd.setText("");
        		textSifre.setText("");
        		}
    		
    }
    	 catch (Exception e) {
 			System.out.println(e.getMessage().toString()+OtomasyonUtil.hatamesajı);
 			// TODO: handle exception
 			
 		}
    }

    @FXML
    void tabloSifre_mouseClick(MouseEvent event) {
    	Kayıt_giris Kayıt=new Kayıt_giris();
		Kayıt=(Kayıt_giris)tablosifre.getItems().get(tablosifre.getSelectionModel().getSelectedIndex());
		
		textAd.setText(Kayıt.getKullanıcıAD());
		//textSifre.setText(Kayıt.getSifre());
		textYetki.setText(String.valueOf(Kayıt.getId()));


    }

    @FXML
    void initialize() {
    	sql="select * from giris";
    	degerlerigetir(tablosifre,sql);
        


    }

}
