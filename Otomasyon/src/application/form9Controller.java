package application;
//devamsızlık yonetici

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class form9Controller {
	
	Connection baglanti=null;
	PreparedStatement sorgu=null;
	ResultSet getir=null;
	String sql;
	
	public form9Controller() {
		baglanti=OtomasyonUtil.bagla();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TableColumn<Devamsızlıkbilgi, String> AD;

    @FXML
    private TableColumn<Devamsızlıkbilgi, Date> DEVAMSIZLIK;

    @FXML
    private TableColumn<Devamsızlıkbilgi, Integer> ID;

    @FXML
    private TableColumn<Devamsızlıkbilgi, String> SOYAD;

    @FXML
    private Button button_ekle;


    @FXML
    private DatePicker devamsızlıkTarihi;

    @FXML
    private TableView<Devamsızlıkbilgi> tabloDevamsızlık;

    @FXML
    private TextField textAD;

    @FXML
    private TextField textAra;

    @FXML
    private TextField textID;
    @FXML
    private TableColumn<Devamsızlıkbilgi, Integer> yetki;
  
    @FXML
    private TextField textSoyad;
    
    @FXML
    private Button button_geri;
    
    public void degerlerigetir(TableView<Devamsızlıkbilgi> tablo,String sql) {
  	   
    	ObservableList<Devamsızlıkbilgi>Liste=FXCollections.observableArrayList();
    	try {
    		sorgu=baglanti.prepareStatement(sql);
    		ResultSet getirilen=sorgu.executeQuery();
    		while(getirilen.next()) {
    			Liste.add(new Devamsızlıkbilgi(getirilen.getInt("ID"),getirilen.getString("Ad"),getirilen.getString("Soyad"),getirilen.getDate("DEVAMSIZLIKGÜN"),getirilen.getInt("yetki")));
    		}
    		
    		ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
    		AD.setCellValueFactory(new PropertyValueFactory<>("AD"));
    		SOYAD.setCellValueFactory(new PropertyValueFactory<>("SOYAD"));
    		yetki.setCellValueFactory(new PropertyValueFactory<>("yetki"));
    		DEVAMSIZLIK.setCellValueFactory(new PropertyValueFactory<>("DEVAMSIZLIKTARİHİ"));
    		tabloDevamsızlık.setItems(Liste);
    		
			
    		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
		}
    }
   



    @FXML
    void button_geri_click(ActionEvent event) {
    	Stage stage;
       	stage=(Stage) button_geri.getScene().getWindow();
       	stage.close();

    }
  
    @FXML
    void button_ekle(ActionEvent event) {
      sql="insert into devamsızlık(ID,AD,SOYAD,DEVAMSIZLIKGÜN,yetki)values(?,?,?,?,?) ";
    	
        try {
  		
  		sorgu=baglanti.prepareStatement(sql);
  	
  		sorgu.setString(4,String.valueOf(devamsızlıkTarihi.getValue()));
  		sorgu.setString(5,"1");
  		sorgu.setString(3,textSoyad.getText());
  		sorgu.setString(2,textAD.getText());
  		sorgu.setString(1,textID.getText());
  		
  		sorgu.executeUpdate();
  		if(!sorgu.equals(null)) {
  			System.out.println("Eklendi...");
  			sql="select * from devamsızlık";
  	    	degerlerigetir(tabloDevamsızlık,sql);}
  	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString()+OtomasyonUtil.hatamesajı);
			
		}

    }



    @FXML
    void tabloDevamsızlıkMouseClicked(MouseEvent event) {
    	Devamsızlıkbilgi bilgi= new Devamsızlıkbilgi();
		bilgi=(Devamsızlıkbilgi)tabloDevamsızlık.getItems().get(tabloDevamsızlık.getSelectionModel().getSelectedIndex());
		textID.setText(String.valueOf(bilgi.getID()));
		textAD.setText(bilgi.getAD());
		textSoyad.setText(bilgi.getSOYAD());
	


    }

    @FXML
    void textAra_keyPressed(KeyEvent event) {
    	if(textAra.getText().equals("")) {
    		sql="select * from devamsızlık";
    	}
    	else {
    	
    			sql="select * from devamsızlık where AD like '%"+textAra.getText()+"%' ";
    			
    	}
    	degerlerigetir(tabloDevamsızlık,sql);

    }

    @FXML
    void initialize() {
      	sql="select * from devamsızlık";
    	degerlerigetir(tabloDevamsızlık,sql);

    }

}
