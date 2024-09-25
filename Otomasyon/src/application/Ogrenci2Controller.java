package application;
//yonetici icin ögrenci bilgi formu

import java.net.URL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import com.otomasyonMysql.Util.OtomasyonUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Ogrenci2Controller {
	
	Connection baglanti=null;
	PreparedStatement sorgu=null;
	ResultSet getir=null;
	String sql;
	
	public Ogrenci2Controller() {
		baglanti=OtomasyonUtil.bagla();
	}


    @FXML
    private TableColumn<OgrenciBilgi, Integer> Yetki;
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<OgrenciBilgi, String> AD;

    @FXML
    private TableColumn<OgrenciBilgi, String> ADRES;

    @FXML
    private TableColumn<OgrenciBilgi, LocalDate> GİRİSTARİHİ;

    @FXML
    private TableColumn<OgrenciBilgi, Integer> ID;

    @FXML
    private TableColumn<OgrenciBilgi, String> ODEMETİPİ;

    @FXML
    private TableColumn<OgrenciBilgi, String> SINIF;

    @FXML
    private TableColumn<OgrenciBilgi, String> SOYAD;

    @FXML
    private TableColumn<OgrenciBilgi, String> TELEFON;

    @FXML
    private TableColumn<OgrenciBilgi, Double> UCRET;

    @FXML
    private TableColumn<OgrenciBilgi, String> VELİADSOYAD;

    @FXML
    private TableColumn<OgrenciBilgi, String> VELİTELEFON;

    @FXML
    private Button buttonGeri;

    @FXML
    private Button button_ekle;

    @FXML
    private Button button_guncelle;

    @FXML
    private DatePicker giristarihi;

    @FXML
    private TableView<OgrenciBilgi> tabloOgrenci;

    @FXML
    private TextField textAD;

    @FXML
    private TextField textAdres;

    @FXML
    private TextField textAra;

    @FXML
    private TextField textID;

    @FXML
    private TextField textOdemetipi;

    @FXML
    private TextField textSoyad;

    @FXML
    private TextField textSınıf;

    @FXML
    private TextField textUcret;

    @FXML
    private TextField textVeliAd;

    @FXML
    private TextField textVeliTelefon;

    @FXML
    private TextField text_telefon;
    
    @FXML
    private Button button_Yenile;

    @FXML
    private TextField textOdemeDurumu;
    
    @FXML
    private Button button_sil;
    
    
    public void degerlerigetir(TableView<OgrenciBilgi> tablo,String sql) {
 	   
    	ObservableList<OgrenciBilgi>ogrenciListe=FXCollections.observableArrayList();
    	try {
    		sorgu=baglanti.prepareStatement(sql);
    		ResultSet getirilen=sorgu.executeQuery();
    		while(getirilen.next()) {
    			ogrenciListe.add(new OgrenciBilgi(getirilen.getInt("ID"),getirilen.getString("Ad"),getirilen.getString("Soyad"),getirilen.getString("Telefon"),getirilen.getString("Adres"),getirilen.getString("Sınıf"),getirilen.getDate("GirisTarihi"),getirilen.getString("VeliAdSoyad"),getirilen.getString("VeliTelefon"),getirilen.getString("OdemeTipi"),getirilen.getDouble("Ucret"),getirilen.getString("OdemeDurumu"),getirilen.getInt("Yetki")));;
    		}
    		
    		ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
    		AD.setCellValueFactory(new PropertyValueFactory<>("AD"));
    		SOYAD.setCellValueFactory(new PropertyValueFactory<>("SOYAD"));
    		TELEFON.setCellValueFactory(new PropertyValueFactory<>("TELEFON"));
    		ADRES.setCellValueFactory(new PropertyValueFactory<>("ADRES"));
    		SINIF.setCellValueFactory(new PropertyValueFactory<>("SINIF"));
    		GİRİSTARİHİ.setCellValueFactory(new PropertyValueFactory<>("GİRİSTARİHİ"));
    		VELİADSOYAD.setCellValueFactory(new PropertyValueFactory<>("VELİADSOYAD"));
    		VELİTELEFON.setCellValueFactory(new PropertyValueFactory<>("VELİTELEFON"));
    		ODEMETİPİ.setCellValueFactory(new PropertyValueFactory<>("ODEMETİPİ"));
    		UCRET.setCellValueFactory(new PropertyValueFactory<>("UCRET"));
    		Yetki.setCellValueFactory(new PropertyValueFactory<>("yetki"));


    		tabloOgrenci.setItems(ogrenciListe);
    		
			
    		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
		}
    }


    @FXML
    void TabloOgrenci_MouseClick(MouseEvent event) {
    	OgrenciBilgi bilgi= new OgrenciBilgi();
		bilgi=(OgrenciBilgi)tabloOgrenci.getItems().get(tabloOgrenci.getSelectionModel().getSelectedIndex());
		textID.setText(String.valueOf(bilgi.getID()));
		textAD.setText(bilgi.getAD());
		textSoyad.setText(bilgi.getSOYAD());
		text_telefon.setText(bilgi.getTELEFON());
		textAdres.setText(bilgi.getADRES());
		textSınıf.setText(bilgi.getSINIF());
		textVeliAd.setText(bilgi.getVELİADSOYAD());
		textVeliTelefon.setText(bilgi.getVELİTELEFON());
		textOdemetipi.setText(bilgi.getODEMETİPİ());
		textUcret.setText(String.valueOf(bilgi.getUCRET()));
		
		
		


    }

    @FXML
    void buttonGeri_Click(ActionEvent event) {
    	Stage stage;
       	stage=(Stage) buttonGeri.getScene().getWindow();
       	stage.close();

    }

    @FXML
    void button_ekle_Click(ActionEvent event) {
    	sql="insert into ogrencibilgi(ID,Ad,Soyad,Telefon,Adres,Sınıf,GirisTarihi,VeliAdSoyad,VeliTelefon,OdemeTipi,Ucret,Yetki,OdemeDurumu)values(?,?,?,?,?,?,?,?,?,?,?,?,?) ";
    	
          try {
    		
    		sorgu=baglanti.prepareStatement(sql);
    		sorgu.setString(13, textOdemeDurumu.getText());
    		sorgu.setString(12,"1");
    		sorgu.setString(11,textUcret.getText());
    		sorgu.setString(10,textOdemetipi.getText());
    		sorgu.setString(9,textVeliTelefon.getText());
    		sorgu.setString(8,textVeliAd.getText());
    		sorgu.setString(7,String.valueOf(giristarihi.getValue()));
    		sorgu.setString(6,textSınıf.getText());
    		sorgu.setString(5,textAdres.getText());
    		sorgu.setString(4,text_telefon.getText());
    		sorgu.setString(3,textSoyad.getText());
    		sorgu.setString(2,textAD.getText());
    		sorgu.setString(1,textID.getText());
    		
    		sorgu.executeUpdate();
    		if(!sorgu.equals(null)) {
    			System.out.println("Eklendi...");
    			sql="select * from ogrencibilgi";
    	    	degerlerigetir(tabloOgrenci,sql);}
    	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString()+OtomasyonUtil.hatamesajı);
			
		}

    }

    @FXML
    void button_guncelle_Click(ActionEvent event) {
    	sql="update ogrencibilgi set Telefon=? ,Adres=?,VeliAdSoyad=?,VeliTelefon=?,Yetki=? Where Ad=?";
    	try {
    		
    		sorgu=baglanti.prepareStatement(sql);
    		sorgu.setString(6,textAD.getText());
    		sorgu.setString(5,"1");
    		sorgu.setString(4,textVeliTelefon.getText());
    		sorgu.setString(3,textVeliAd.getText());
    		sorgu.setString(2,textAdres.getText());
    		sorgu.setString(1,text_telefon.getText());
    		sorgu.executeUpdate();
    		if(!sorgu.equals(null)) {
    			System.out.println("guncellendi");
    			sql="select * from ogrencibilgi";
    	    	degerlerigetir(tabloOgrenci,sql);}
    	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString()+OtomasyonUtil.hatamesajı);
			
		}
    	

    }
    

    @FXML
    void button_sil_Click(ActionEvent event) {
    	sql="delete from ogrencibilgi where Ad=? ";
    	
        try {
  		
  		sorgu=baglanti.prepareStatement(sql);
  		sorgu.setString(1,textAD.getText());

  		sorgu.executeUpdate();
  		if(!sorgu.equals(null)) {
  			System.out.println("silindi...");
  			sql="select * from ogrencibilgi";
  	    	degerlerigetir(tabloOgrenci,sql);}
  	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString()+OtomasyonUtil.hatamesajı);
			
		}
    	
  

    }

    @FXML
    void textAra_KeyyPressed(KeyEvent event) {
    	if(textAra.getText().equals("")) {
    		sql="select * from ogrencibilgi";
    	}
    	else {
    	
    			sql="select * from ogrencibilgi where Ad like '%"+textAra.getText()+"%' ";
    			
    	}
    	degerlerigetir(tabloOgrenci,sql);
    	
    	


    }
    
    @FXML
    void buttonYenile_click(ActionEvent event) {

    	sql="select * from ogrencibilgi";
    	degerlerigetir(tabloOgrenci,sql);
    }

    @FXML
    void initialize() {
    	sql="select * from ogrencibilgi";
    	degerlerigetir(tabloOgrenci,sql);
        

    }

}
