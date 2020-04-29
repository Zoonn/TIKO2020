package com.sample.postgress.service;

import java.util.List;

import com.sample.postgress.entity.Tarvikkeet;

public interface TarvikkeetService {
	List<Tarvikkeet> findAll();

	void insertTarvikkeet(Tarvikkeet tarvikkeet);

	void updateTarvikkeet(Tarvikkeet tarvikkeet);

	void executeUpdateTarvikkeet(Tarvikkeet tarvikkeet);

	void deleteTarvikkeet(int tarvikeid);

	Tarvikkeet findTarvikeById(int tarvikeid);
	
}
