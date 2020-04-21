package com.sample.postgress.entity;

public class Tyo {

	int tyoid;
	String tyonnimi;
	int vero;

	
	public int getvero() {
		return vero;
	}
	public void setvero(int vero) {
		this.vero = vero;
	}

	public int gettyoid() {
		return tyoid;
	}
	public void settyoid(int tyoid) {
		this.tyoid = tyoid;
	}

	public String gettyonnimi() {
		return tyonnimi;
	}
	public void settyonnimi(String tyonnimi) {
		this.tyonnimi = tyonnimi;
	}	
}