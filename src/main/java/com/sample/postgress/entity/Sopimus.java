package com.sample.postgress.entity;

public class Sopimus {

	int sopimusid;
	String kuvaus;
	String osoite;
	int asiakasid; 

	
	public String getosoite() {
		return osoite;
	}
	public void setosoite(String osoite) {
		this.osoite = osoite;
	}

	public int getsopimusid() {
		return sopimusid;
	}
	public void setsopimusid(int sopimusid) {
		this.sopimusid = sopimusid;
	}

	public String getkuvaus() {
		return kuvaus;
	}
	public void setkuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}

	public int getasiakasid() {
		return asiakasid;
	}
	public void setasiakasid(int asiakasid) {
		this.asiakasid = asiakasid;
	}
}