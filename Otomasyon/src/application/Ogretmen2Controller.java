package application;
//yonetici icin ögretmen bilgi formu

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

public class Ogretmen2Controller {

	Connection baglanti=null;
	PreparedStatement sorgu=null;
	ResultSet getir=null;
	String sql;
	
	public Ogretmen2Controller() {
		baglanti=OtomasyonUtil.bagla();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<OgretmenBilgi, String> AD;

    @FXML
    private TableColumn<OgretmenBilgi, String> ADRES;

    @FXML
    private TableColumn<OgretmenBilgi, String> BRANŞ;

    @FXML
    private TableColumn<OgretmenBilgi, Date> GİRİS_TARİHİ;

    @FXML
    private TableColumn<OgretmenBilgi, Integer> ID;

    @FXML
    private TableColumn<OgretmenBilgi, String> SOYAD;

    @FXML
    private TableColumn<OgretmenBilgi, String> TELEFON;

    @FXML
    private Button buttonEkle;

    @FXML
    private Button buttonGeri;

    @FXML
    private Button button_guncelle;

    @FXML
    private DatePicker giristarihi;

    @FXML
    private TableView<OgretmenBilgi> tabloOgretmen;

    @FXML
    private TextField textAd;

    @FXML
    private TextField textAdres;

    @FXML
    private TextField textAra;

    @FXML
    private TextField textBrans;

    @FXML
    private TextField textSoyad;
    
    
    @FXML
    private TextField textUcret;

    @FXML
    private TextField textDersSaati;


    @FXML
    private TextField text_telefon;

    @FXML
    private TableColumn<OgretmenBilgi, Integer> YETKİ;
    
    @FXML
    private TextField textID;
    
    @FXML
    private TableColumn<OgretmenBilgi, Double> UCRET;
    
    @FXML
    private TableColumn<OgretmenBilgi, Integer> DERSSAATİ;
    

    @FXML
    private Button button_sil;

    
    
    
    
   public void degerlerigetir(TableView<OgretmenBilgi> tablo,String sql) {
    	
    	ObservableList<OgretmenBilgi>ogretmenListe=FXCollections.observableArrayList();
    	try {
    		sorgu=baglanti.prepareStatement(sql);
    		ResultSet getirilen=sorgu.executeQuery();
    		while(getirilen.next()) {
    			ogretmenListe.add(new OgretmenBilgi(getirilen.getInt("ID"),getirilen.getString("AD"),getirilen.getString("SOYAD"),getirilen.getString("BRANŞ"),getirilen.getString("TELEFON"),getirilen.getString("ADRES"),getirilen.getDate("GİRİS_TARİHİ"),getirilen.getInt("YETKİ"),getirilen.getInt("DersSaati"),getirilen.getDouble("UCRET")));
    		}
    		
    		ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
    		AD.setCellValueFactory(new PropertyValueFactory<>("AD"));
    		SOYAD.setCellValueFactory(new PropertyValueFactory<>("SOYAD"));
    		BRANŞ.setCellValueFactory(new PropertyValueFactory<>("BRANŞ"));
    		TELEFON.setCellValueFactory(new PropertyValueFactory<>("TELEFON"));
    		ADRES.setCellValueFactory(new PropertyValueFactory<>("ADRES"));
    		GİRİS_TARİHİ.setCellValueFactory(new PropertyValueFactory<>("GİRİS_TARİHİ"));
    		YETKİ.setCellValueFactory(new PropertyValueFactory<>("YETKİ"));
    		DERSSAATİ.setCellValueFactory(new PropertyValueFactory<>("DersSaati"));
    		UCRET.setCellValueFactory(new PropertyValueFactory<>("UCRET"));

    		tabloOgretmen.setItems(ogretmenListe);
    		
			
    		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
		}
    }

    @FXML
    void TabloOgretmen_MouseClick(MouseEvent event) {
    	OgretmenBilgi bilgi1= new OgretmenBilgi();
    	
		bilgi1=(OgretmenBilgi)tabloOgretmen.getItems().get(tabloOgretmen.getSelectionModel().getSelectedIndex());
		textID.setText(String.valueOf(bilgi1.getID()));
		textAd.setText(bilgi1.getAD());
		textSoyad.setText(bilgi1.getSOYAD());
		textBrans.setText(bilgi1.getBRANŞ());
		text_telefon.setText(bilgi1.getTELEFON());
		textAdres.setText(bilgi1.getADRES());
		textDersSaati.setText(String.valueOf(bilgi1.getDersSaati()));
		textUcret.setText(String.valueOf(bilgi1.getUCRET()));
    }
    
    
    @FXML
    void button_sil_Click(ActionEvent event) {
      sql="delete from ogretmenbilgi where AD=? ";
    	
        try {
  		
  		sorgu=baglanti.prepareStatement(sql);
  		sorgu.setString(1,textAd.getText());

  		sorgu.executeUpdate();
  		if(!sorgu.equals(null)) {
  			System.out.println("silindi...");
  			sql="select * from ogretmenbilgi";
  	    	degerlerigetir(tabloOgretmen,sql);}
  	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString()+OtomasyonUtil.hatamesajı);
			
		}
    	

    }

    @FXML
    void buttonEkle_Click(ActionEvent event) {
    	sql="insert into ogretmenbilgi (AD,SOYAD,BRANŞ,TELEFON,ADRES,GİRİS_TARİHİ,DersSaati,UCRET,YETKİ)values (?,?,?,?,?,?,?,?,?)";

    	try {
    		
    		sorgu=baglanti.prepareStatement(sql);
    		sorgu.setString(7,String.valueOf(textDersSaati.getText()));
    		sorgu.setString(8,String.valueOf(textUcret.getText()));
    		sorgu.setString(9,"1");
    		sorgu.setString(6,String.valueOf(giristarihi.getValue()));
    		sorgu.setString(5,textAdres.getText());
    		sorgu.setString(4,text_telefon.getText());
    		sorgu.setString(3,textBrans.getText());
    		sorgu.setString(2,textSoyad.getText());
    		sorgu.setString(1,textAd.getText());
    		sorgu.executeUpdate();
    		if(!sorgu.equals(null)) {
    			System.out.println("Eklendi...");
    			sql="select * from ogretmenbilgi";
    	    	degerlerigetir(tabloOgretmen,sql);}
    	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString()+OtomasyonUtil.hatamesajı);
			
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
    	sql="update ogretmenbilgi set TELEFON=? ,ADRES=?,YETKİ=?,UCRET=?,DersSaati=? Where AD=?";
    	try {
    		
    		sorgu=baglanti.prepareStatement(sql);
    		sorgu.setString(6,textAd.getText());
    		sorgu.setString(3,"1");
    		sorgu.setString(2,textAdres.getText());
    		sorgu.setString(1,text_telefon.getText());
    		sorgu.setInt(4,Integer.parseInt(textDersSaati.getText())*200);
    		sorgu.setString(5,String.valueOf(textDersSaati.getText()));
    		sorgu.executeUpdate();
    		if(!sorgu.equals(null)) {
    			System.out.println("guncellendi");
    			sql="select * from ogretmenbilgi";
    	    	degerlerigetir(tabloOgretmen,sql);}
    	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString()+OtomasyonUtil.hatamesajı);
			
		}

    }

    @FXML
    void textAra_KeyyPressed(KeyEvent event) {
       if(textAra.getText().equals("")) {
    		
    		sql="select * from ogretmenbilgi";
    	}
    	else {
    	
    			sql="select * from ogretmenbilgi where AD like '%"+textAra.getText()+"%' ";
    			
    	}
    	degerlerigetir(tabloOgretmen,sql);

    }

    @FXML
    void initialize() {
    	sql="select * from ogretmenbilgi";
    	degerlerigetir(tabloOgretmen,sql);
        
    }

}
