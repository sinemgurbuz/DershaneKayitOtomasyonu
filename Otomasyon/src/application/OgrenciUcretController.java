package application;
//calısan icin ögrenci ödeme formu

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle;

import com.otomasyonMysql.Util.OtomasyonUtil;

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

public class OgrenciUcretController {
	Connection baglanti=null;
	PreparedStatement sorgu=null;
	ResultSet getir=null;
	String sql;
	
	public OgrenciUcretController() {
		baglanti=OtomasyonUtil.bagla();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<OgrenciBilgi, String> AD;
    
    @FXML
    private TableColumn<OgrenciBilgi, String> SOYAD;
    
    @FXML
    private TextField textSoyad;

    @FXML
    private TableColumn<OgrenciBilgi, Date> GİRİSTARİHİ;

    @FXML
    private TableColumn<OgrenciBilgi, Integer> ID;

    @FXML
    private TableColumn<OgrenciBilgi, String> ODEMEDURUMU;

    @FXML
    private TableColumn<OgrenciBilgi, String> ODEMETİPİ;

    @FXML
    private TableColumn<OgrenciBilgi, Double> UCRET;

    @FXML
    private TableColumn<OgrenciBilgi, Integer> YETKİ;

    @FXML
    private Button buttonGeri;

    @FXML
    private Button button_guncelle;

   
    @FXML
    private TableView<OgrenciBilgi> tabloOgrenci;

    @FXML
    private TextField textAra;

    @FXML
    private TextField textOdemeDurumu;

    @FXML
    private TextField textOdemeTipi;
    
    @FXML
    private TextField textAD;
    
    
    
    
     public void degerlerigetir(TableView<OgrenciBilgi> tablo,String sql) {
    	
    	ObservableList<OgrenciBilgi>ogrenciodemeliste=FXCollections.observableArrayList();
    	try {
    		sorgu=baglanti.prepareStatement(sql);
    		ResultSet getirilen=sorgu.executeQuery();
    		while(getirilen.next()) {
    			ogrenciodemeliste.add(new OgrenciBilgi(getirilen.getInt("ID"),getirilen.getString("Ad"),getirilen.getString("Soyad"),getirilen.getString("Telefon"),getirilen.getString("Adres"),getirilen.getString("Sınıf"),getirilen.getDate("GirisTarihi"),getirilen.getString("VeliAdSoyad"),getirilen.getString("VeliTelefon"),getirilen.getString("OdemeTipi"),getirilen.getDouble("Ucret"),getirilen.getString("OdemeDurumu"),getirilen.getInt("Yetki")));
    		}
    		
    		ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
    		AD.setCellValueFactory(new PropertyValueFactory<>("AD"));
    		SOYAD.setCellValueFactory(new PropertyValueFactory<>("SOYAD"));
    		UCRET.setCellValueFactory(new PropertyValueFactory<>("UCRET"));
    		ODEMETİPİ.setCellValueFactory(new PropertyValueFactory<>("ODEMETİPİ"));
    		GİRİSTARİHİ.setCellValueFactory(new PropertyValueFactory<>("GİRİSTARİHİ"));
    		ODEMEDURUMU.setCellValueFactory(new PropertyValueFactory<>("OdemeDurumu"));
    		YETKİ.setCellValueFactory(new PropertyValueFactory<>("yetki"));
    		

    		tabloOgrenci.setItems(ogrenciodemeliste);
    		
			
    		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
		}
    }

    
    

    @FXML
    void TabloOgrenci_MouseClick(MouseEvent event) {
    	OgrenciBilgi bilgi2= new OgrenciBilgi();
		bilgi2=(OgrenciBilgi)tabloOgrenci.getItems().get(tabloOgrenci.getSelectionModel().getSelectedIndex());
		
		textOdemeTipi.setText(bilgi2.getODEMETİPİ());
		textOdemeDurumu.setText(bilgi2.getOdemeDurumu());
		textAD.setText(bilgi2.getAD());
		textSoyad.setText(bilgi2.getSOYAD());
		
    }

    @FXML
    void buttonGeri_Click(ActionEvent event) {
    	Stage stage;
       	stage=(Stage) buttonGeri.getScene().getWindow();
       	stage.close();


    }

    @FXML
    void button_guncelle_Click(ActionEvent event) {
    	sql="update ogrencibilgi set OdemeTipi=? ,OdemeDurumu=?,yetki=? Where Ad=?";
    	try {
    		
    		sorgu=baglanti.prepareStatement(sql);
    		sorgu.setString(4,textAD.getText());
    		sorgu.setString(3,"0");
    		sorgu.setString(2,textOdemeDurumu.getText());
    		sorgu.setString(1,textOdemeTipi.getText());
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
    void initialize() {
    	sql="select * from ogrencibilgi";
    	degerlerigetir(tabloOgrenci,sql);
        
    }

}
