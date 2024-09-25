package application;

import java.util.Date;

public class OgrenciBilgi {
	
	private int ID;
	private String AD,SOYAD,TELEFON,ADRES,SINIF,VELİADSOYAD,VELİTELEFON,ODEMETİPİ;
	private Date GİRİSTARİHİ;
	private double UCRET;
	private int yetki;
	private String OdemeDurumu;
	
	
	OgrenciBilgi()
	{
		this.ID=ID;
		this.yetki=yetki;
		
	}
	
	OgrenciBilgi(int ID,String AD,String SOYAD,String TELEFON,String ADRES,String SINIF,Date GİRİSTARİHİ,String VELİADSOYAD,String VELİTELEFON,String ODEMETİPİ,double UCRET,String OdemeDurumu,int yetki){
		this.ID=ID;
		this.AD=AD;
		this.SOYAD=SOYAD;
		this.TELEFON=TELEFON;
		this.ADRES=ADRES;
		this.SINIF=SINIF;
		this.GİRİSTARİHİ=GİRİSTARİHİ;
		this.VELİADSOYAD=VELİADSOYAD;
		this.VELİTELEFON=VELİTELEFON;
		this.ODEMETİPİ=ODEMETİPİ;
		this.UCRET=UCRET;
		this.OdemeDurumu=OdemeDurumu;
		this.yetki=yetki;
		
	}

	public String getOdemeDurumu() {
		return OdemeDurumu;
	}

	public void setOdemeDurumu(String odemeDurumu) {
		OdemeDurumu = odemeDurumu;
	}

	public int getYetki() {
		return yetki;
	}

	public void setYetki(int yetki) {
		this.yetki = yetki;
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

	public String getSINIF() {
		return SINIF;
	}

	public void setSINIF(String sINIF) {
		SINIF = sINIF;
	}

	public String getVELİADSOYAD() {
		return VELİADSOYAD;
	}

	public void setVELİADSOYAD(String vELİADSOYAD) {
		VELİADSOYAD = vELİADSOYAD;
	}

	public String getVELİTELEFON() {
		return VELİTELEFON;
	}

	public void setVELİTELEFON(String vELİTELEFON) {
		VELİTELEFON = vELİTELEFON;
	}

	public String getODEMETİPİ() {
		return ODEMETİPİ;
	}

	public void setODEMETİPİ(String oDEMETİPİ) {
		ODEMETİPİ = oDEMETİPİ;
	}

	public Date getGİRİSTARİHİ() {
		return GİRİSTARİHİ;
	}

	public void setGİRİSTARİHİ(Date gİRİSTARİHİ) {
		GİRİSTARİHİ = gİRİSTARİHİ;
	}

	public double getUCRET() {
		return UCRET;
	}

	public void setUCRET(double uCRET) {
		UCRET = uCRET;
	}
	

}
