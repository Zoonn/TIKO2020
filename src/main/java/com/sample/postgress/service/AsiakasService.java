package com.sample.postgress.service;

import java.util.List;

import com.sample.postgress.entity.Asiakas;

public interface AsiakasService {
	List<Asiakas> findAll();

	void insertAsiakas(Asiakas asiakas);

	void updateAsiakas(Asiakas asiakas);

	void executeUpdateAsiakas(Asiakas asiakas);

	void deleteAsiakas(Asiakas asiakas);
	
}
