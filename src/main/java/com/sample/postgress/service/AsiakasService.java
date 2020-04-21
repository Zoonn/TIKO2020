package com.sample.postgress.service;

import java.util.List;

import com.sample.postgress.entity.Asiakas;

public interface AsiakasService {
	List<Asiakas> findAll();

	void insertAsiakas(Asiakas emp);

	void updateAsiakas(Asiakas emp);

	void executeUpdateAsiakas(Asiakas emp);

	void deleteAsiakas(Asiakas emp);
	
}
