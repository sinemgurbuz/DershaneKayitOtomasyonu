package application;


import java.util.Date;

public class OgretmenBilgi {
	private int ID;
	private String AD,SOYAD,BRANŞ,TELEFON,ADRES;
	private Date GİRİS_TARİHİ;
	private int YETKİ,DersSaati;
	private double UCRET;
	
	OgretmenBilgi(){
		
	}
	OgretmenBilgi(int ID,String AD,String SOYAD,String BRANŞ,String TELEFON,String ADRES,Date GİRİS_TARİHİ,int YETKİ,int DersSaati,double UCRET){
		this.ID=ID;
		this.AD=AD;
		this.SOYAD=SOYAD;
		this.BRANŞ=BRANŞ;
		this.TELEFON=TELEFON;
		this.ADRES=ADRES;
		this.GİRİS_TARİHİ=GİRİS_TARİHİ;
		this.YETKİ=YETKİ;
		this.DersSaati=DersSaati;
		this.UCRET=UCRET;
	}
	public int getDersSaati() {
		return DersSaati;
	}
	public void setDersSaati(int dersSaati) {
		DersSaati = dersSaati;
	}
	public double getUCRET() {
		return UCRET;
	}
	public void setUCRET(double uCRET) {
		UCRET = uCRET;
	}

	public int getYETKİ() {
		return YETKİ;
	}
	public void setYETKİ(int YETKİ) {
		YETKİ = YETKİ;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getAD() {
		return AD;
	}
	public void setAD(String aD) {
		AD = aD;
	}
	public String getSOYAD() {
		return SOYAD;
	}
	public void setSOYAD(String sOYAD) {
		SOYAD = sOYAD;
	}
	public String getBRANŞ() {
		return BRANŞ;
	}
	public void setBRANŞ(String bRANŞ) {
		BRANŞ = bRANŞ;
	}
	public String getTELEFON() {
		return TELEFON;
	}
	public void setTELEFON(String tELEFON) {
		TELEFON = tELEFON;
	}
	public String getADRES() {
		return ADRES;
	}
	public void setADRES(String aDRES) {
		ADRES = aDRES;
	}
	public Date getGİRİS_TARİHİ() {
		return GİRİS_TARİHİ;
	}
	public void setGİRİS_TARİHİ(Date gİRİS_TARİHİ) {
		GİRİS_TARİHİ = gİRİS_TARİHİ;
	}

}
