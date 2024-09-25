package application;

public class Kayıt_giris {
	private int ıd;
	private String kullanıcıAD;
	private String sifre;

	Kayıt_giris(int id, String kullanıcıAD, String sifre){
		this.ıd=id;
		this.kullanıcıAD=kullanıcıAD;
		this.sifre=sifre;
		
	}
	Kayıt_giris(){
		
	}

	public int getId() {
		return ıd;
	}

	public void setId(int id) {
		ıd = id;
	}

	public String getKullanıcıAD() {
		return kullanıcıAD;
	}

	public void setKullanıcıAD(String kullanıcıAD) {
		this.kullanıcıAD = kullanıcıAD;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
}


