package com.sample.postgress.entity;

public class Lasku {

	int laskuid;
	int sopimusid;
	String paivamaara;
    String erapaiva;
    double laskutuslisa;
    boolean tila; 
	
	
	public String getpaivamaara() {
		return paivamaara;
	}
	public void setpaivamaara(String paivamaara) {
		this.paivamaara = paivamaara;
	}

	public int getlaskuid() {
		return laskuid;
	}
	public void setlaskuid(int laskuid) {
		this.laskuid = laskuid;
	}

	public int getsopimusid() {
		return sopimusid;
	}
	public void setsopimusid(int sopimusid) {
		this.sopimusid = sopimusid;
	}

	public String geterapaiva() {
		return erapaiva;
	}
	public void seterapaiva(String erapaiva) {
		this.erapaiva = erapaiva;
	}
	
    public double getlaskutuslisa() {
		return laskutuslisa;
	}
	public void setlaskutuslisa(double laskutuslisa) {
		this.laskutuslisa = laskutuslisa;
	}

	public boolean gettila() {
		return tila;
	}
	public void settila(boolean tila) {
		this.tila = tila;
	}
	
	
}