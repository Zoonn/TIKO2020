package com.sample.postgress.entity;

public class Tarvikeluettelo {

	int sopimusid;
	int tarvikeid;
	int maara;
	int alennus;
	double veroton_hinta;
	
	
	public int getmaara() {
		return maara;
	}
	public void setmaara(int maara) {
		this.maara = maara;
	}

	public int getsopimusid() {
		return sopimusid;
	}
	public void setsopimusid(int sopimusid) {
		this.sopimusid = sopimusid;
	}

	public int gettarvikeid() {
		return tarvikeid;
	}
	public void settarvikeid(int tarvikeid) {
		this.tarvikeid = tarvikeid;
	}

	public double getveroton_hinta() {
		return veroton_hinta;
	}
	public void setveroton_hinta(double veroton_hinta) {
		this.veroton_hinta = veroton_hinta;
	}

	public int getalennus() {
		return alennus;
	}
	public void setalennus(int alennus) {
		this.alennus = alennus;
	}
	
	
}