package com.sample.postgress.entity;

public class Tyoluettelo {

	int sopimusid;
	int tyoid;
	int maara;
	int alennus;
	
	
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

	public int gettyoid() {
		return tyoid;
	}
	public void settyoid(int tyoid) {
		this.tyoid = tyoid;
	}

	public int getalennus() {
		return alennus;
	}
	public void setalennus(int alennus) {
		this.alennus = alennus;
	}
}