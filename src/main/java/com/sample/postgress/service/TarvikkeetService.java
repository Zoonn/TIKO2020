package com.sample.postgress.service;

import java.util.List;

import com.sample.postgress.entity.Tarvikkeet;

public interface TarvikkeetService {
	List<Tarvikkeet> findAll();

	void insertTarvikkeet(Tarvikkeet emp);

	void updateTarvikkeet(Tarvikkeet emp);

	void executeUpdateTarvikkeet(Tarvikkeet emp);

	void deleteTarvikkeet(Tarvikkeet emp);
	
}
