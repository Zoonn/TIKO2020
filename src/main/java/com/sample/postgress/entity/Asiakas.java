package com.sample.postgress.entity;

public class Asiakas {

	int puhelinnumero;
	String asiakasid;
	String nimi;
	String sahkoposti;
	String osoite;
	String yritys;
	
	public int getpuhelinnumero() {
		return puhelinnumero;
	}
	public void setpuhelinnumero(int puhelinnumero) {
		this.puhelinnumero = puhelinnumero;
	}
	public String getsahkoposti() {
		return sahkoposti;
	}
	public void setsahkoposti(String sahkoposti) {
		this.sahkoposti = sahkoposti;
	}
	public String getasiakasid() {
		return asiakasid;
	}
	public void setasiakasid(String asiakasid) {
		this.asiakasid = asiakasid;
	}
	public String getnimi() {
		return nimi;
	}
	public void setnimi(String nimi) {
		this.nimi = nimi;
	}
	public String getosoite() {
		return osoite;
	}
	public void setosoite(String osoite) {
		this.osoite = osoite;
	}
	public String getyritys() {
		return yritys;
	}
	public void setyritys(String yritys) {
		this.yritys = yritys;
	}
	
	
}
