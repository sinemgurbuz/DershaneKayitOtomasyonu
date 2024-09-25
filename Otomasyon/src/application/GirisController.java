package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.otomasyonMysql.Util.OtomasyonUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.*;

public class GirisController {
	
	Connection baglanti=null;
	PreparedStatement sorgu=null;
	ResultSet getir=null;
	String sql;
	
	public GirisController() {
		baglanti=OtomasyonUtil.bagla();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField AdminAd;

    @FXML
    private PasswordField AdminSifre;

    @FXML
    private TextField YoneticiAd;

    @FXML
    private PasswordField YoneticiSifre;


    @FXML
    private Button girisAdmin;

    @FXML
    private Button girisYonetici;

    @FXML
    private Label labelSonuc;
    
    @FXML
    private Label labelSonuc1;


    @FXML
    void girisAdmin_click(ActionEvent event) {
    	sql="select * from giris where kullanıcıAD=? and sifre=?";
    	try {
    		sorgu=baglanti.prepareStatement(sql);
    		sorgu.setString(1,AdminAd.getText().trim());
    		sorgu.setString(2,OtomasyonUtil.MD5Sifreleme(AdminSifre.getText().trim()));
    		ResultSet getir=sorgu.executeQuery();
    		
    		if(!getir.next()) {
    			labelSonuc.setText("kullanıcı adı veya sifre hatalı");
    			AdminAd.setText("");
    			AdminSifre.setText("");
    		}
    		else {
    			getir.getString(1);
    			System.out.println("giris basarılı");
    			System.out.println("ID:"+getir.getString("ıd"));
    			System.out.println("kullanıcı ad:"+getir.getString("kullanıcıAD"));
    			System.out.println("sifre:"+getir.getString("sifre"));
    			Stage stage1=new Stage();
        		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("Anasayfa.fxml"));
        		Scene scene=new Scene(pane1);
        		stage1.setScene(scene);
        		stage1.show();
    		}
    		AdminAd.setText("");
			AdminSifre.setText("");

			
		} catch (Exception e) {
			// TODO: handle exception
			labelSonuc.setText(e.getMessage().toString()+OtomasyonUtil.hatamesajı);
		}
    	
    	
    }

    @FXML
    void girisYonetici_click(ActionEvent event) {
    	sql="select * from giris where kullanıcıAD=? and sifre=?";
    	try {
    		sorgu=baglanti.prepareStatement(sql);
    		sorgu.setString(1,YoneticiAd.getText().trim());
    		sorgu.setString(2,OtomasyonUtil.MD5Sifreleme(YoneticiSifre.getText().trim()));
    		ResultSet getir=sorgu.executeQuery();
    		
    		if(!getir.next()) {
    			labelSonuc1.setText("kullanıcı adı veya sifre hatalı");
        		YoneticiAd.setText("");
        		YoneticiSifre.setText("");
    		}
    		else {
    			getir.getString(1);
    			System.out.println("giris basarılı");
    			System.out.println("ID:"+getir.getString("ıd"));
    			System.out.println("kullanıcı ad:"+getir.getString("kullanıcıAD"));
    			System.out.println("sifre:"+getir.getString("sifre"));
    			Stage stage1=new Stage();
        		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("Anasayfa2.fxml"));
        		Scene scene=new Scene(pane1);
        		stage1.setScene(scene);
        		stage1.show();

    		}
    		YoneticiAd.setText("");
    		YoneticiSifre.setText("");
    		

			
		} catch (Exception e) {
			// TODO: handle exception
			labelSonuc1.setText(e.getMessage().toString()+OtomasyonUtil.hatamesajı);
		}
    	

    }

    @FXML
    void initialize() {
       
    }

}
