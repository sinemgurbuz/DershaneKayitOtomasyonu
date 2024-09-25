package application;

import java.util.Date;

public class Devamsızlıkbilgi {
	private int ID,yetki;
	private String AD,SOYAD;
	private Date DEVAMSIZLIKTARİHİ;
	
	Devamsızlıkbilgi(){
		
	}
	Devamsızlıkbilgi(int ID,String AD,String SOYAD,Date DEVAMSIZLIKTARİHİ,int yetki){
		this.ID=ID;
		this.AD=AD;
		this.SOYAD=SOYAD;
		this.DEVAMSIZLIKTARİHİ=DEVAMSIZLIKTARİHİ;
		this.yetki=yetki;
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
	public Date getDEVAMSIZLIKTARİHİ() {
		return DEVAMSIZLIKTARİHİ;
	}
	public void setDEVAMSIZLIKTARİHİ(Date dEVAMSIZLIKTARİHİ) {
		DEVAMSIZLIKTARİHİ = dEVAMSIZLIKTARİHİ;
	}

}
