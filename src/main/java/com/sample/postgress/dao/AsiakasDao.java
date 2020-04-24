package com.sample.postgress.dao;

import java.util.List;

import com.sample.postgress.entity.Asiakas;

public interface AsiakasDao {

	List<Asiakas> findAll();

	void insertAsiakas(Asiakas asiakas);

	void updateAsiakas(Asiakas asiakas);

	void executeUpdateAsiakas(Asiakas asiakas);

	public void deleteAsiakas(Asiakas asiakas);
}
