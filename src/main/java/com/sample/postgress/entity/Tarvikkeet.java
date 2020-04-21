package com.sample.postgress.entity;

public class Tarvikkeet {

	int tarvikeid;
	String tarvikenimi;
	String yksikko;
	double mitta;
	int varastotilanne;
	double sisaanottohinta;
	int vero;
	
	
	public String getyksikko() {
		return yksikko;
	}
	public void setyksikko(String yksikko) {
		this.yksikko = yksikko;
	}

	public int gettarvikeid() {
		return tarvikeid;
	}
	public void settarvikeid(int tarvikeid) {
		this.tarvikeid = tarvikeid;
	}

	public String gettarvikenimi() {
		return tarvikenimi;
	}
	public void settarvikenimi(String tarvikenimi) {
		this.tarvikenimi = tarvikenimi;
	}

	public double getmitta() {
		return mitta;
	}
	public void setmitta(double mitta) {
		this.mitta = mitta;
	}

	public int getvarastotilanne() {
		return varastotilanne;
	}
	public void setvarastotilanne(int varastotilanne) {
		this.varastotilanne = varastotilanne;
	}
	
	public double getsisaanottohinta() {
		return sisaanottohinta;
	}
	public void setsisaanottohinta(double sisaanottohinta) {
		this.sisaanottohinta = sisaanottohinta;
	}

	public int getvero() {
		return vero;
	}
	public void setvero(int vero) {
		this.vero = vero;
	}
	
}