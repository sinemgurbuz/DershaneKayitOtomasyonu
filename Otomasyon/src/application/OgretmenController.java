package application;
//ogretmen bilgi formu calısan icin

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.sql.*;
import com.otomasyonMysql.Util.OtomasyonUtil;

public class OgretmenController {
	
	Connection baglanti=null;
	PreparedStatement sorgu=null;
	ResultSet getir=null;
	String sql;
	
	public OgretmenController() {
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
    private Button buttonGeri;

    @FXML
    private Button button_guncelle;

    @FXML
    private TableView<OgretmenBilgi> tabloOgretmen;

    @FXML
    private TextField textAdres;

    @FXML
    private TextField textAra;

    @FXML
    private TextField textID;

    @FXML
    private TextField text_telefon;
    
    @FXML
    private TableColumn<OgretmenBilgi, Integer> İSLEM_YETKİ;
    
    
    
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
    		İSLEM_YETKİ.setCellValueFactory(new PropertyValueFactory<>("YETKİ"));


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
		
		textID.setText(bilgi1.getAD());
		text_telefon.setText(bilgi1.getTELEFON());
		textAdres.setText(bilgi1.getADRES());
		

    }

    @FXML
    void buttonGeri_Click(ActionEvent event) {
    	Stage stage;
       	stage=(Stage) buttonGeri.getScene().getWindow();
       	stage.close();

    }

    @FXML
    void button_guncelle_Click(ActionEvent event) {
    	
    	sql="update ogretmenbilgi set TELEFON=? ,ADRES=?,YETKİ=? Where AD=?";
    	try {
    		
    		sorgu=baglanti.prepareStatement(sql);
    		sorgu.setString(4,textID.getText());
    		sorgu.setString(3,"0");
    		sorgu.setString(2,textAdres.getText());
    		sorgu.setString(1,text_telefon.getText());
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

