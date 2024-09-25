package application;
//yonetici ogretmen ödemeleri

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

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

public class OgretmenUcretController {
	
	Connection baglanti=null;
	PreparedStatement sorgu=null;
	ResultSet getir=null;
	String sql;
	
	public OgretmenUcretController() {
		baglanti=OtomasyonUtil.bagla();
	

}

    @FXML
    private TableColumn<OgretmenBilgi, String> AD;

    @FXML
    private TableColumn<OgretmenBilgi, String> BRANŞ;

    @FXML
    private TableColumn<OgretmenBilgi, Integer> DERSSAATİ;

    @FXML
    private TableColumn<OgretmenBilgi, Date> GİRİS_TARİHİ;

    @FXML
    private TableColumn<OgretmenBilgi, Integer> ID;

    @FXML
    private TableColumn<OgretmenBilgi, String> SOYAD;

    @FXML
    private TableColumn<OgretmenBilgi, Double> UCRET;


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
    private TextField textAra;

    @FXML
    private TextField textBrans;

    @FXML
    private TextField textDersSaati;

    @FXML
    private TextField textID;

    @FXML
    private TextField textSoyad;

    @FXML
    private TextField textUcret;

    @FXML
    private TableColumn<OgretmenBilgi,Integer> İSLEM_YETKİ;
    
    
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
    		GİRİS_TARİHİ.setCellValueFactory(new PropertyValueFactory<>("GİRİS_TARİHİ"));
    		DERSSAATİ.setCellValueFactory(new PropertyValueFactory<>("DersSaati"));
    		İSLEM_YETKİ.setCellValueFactory(new PropertyValueFactory<>("YETKİ"));
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
		textUcret.setText(String.valueOf(bilgi1.getUCRET()));
		textDersSaati.setText(String.valueOf(bilgi1.getDersSaati()));

    }

   

    @FXML
    void buttonGeri_Click(ActionEvent event) {
    	Stage stage;
       	stage=(Stage) buttonGeri.getScene().getWindow();
       	stage.close();


    }

    @FXML
    void button_guncelle_Click(ActionEvent event) {
    	sql="update ogretmenbilgi set UCRET=? ,DersSaati=?,YETKİ=? Where AD=?";
    	try {
    		
    		sorgu=baglanti.prepareStatement(sql);
    		sorgu.setString(4,textAd.getText());
    		sorgu.setString(3,"1");
    		sorgu.setString(2,textDersSaati.getText());
    		sorgu.setInt(1,Integer.parseInt(textDersSaati.getText())*200);
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

    