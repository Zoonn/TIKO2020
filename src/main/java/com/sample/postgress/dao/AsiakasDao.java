package com.sample.postgress.dao;

import java.util.List;

import com.sample.postgress.entity.Asiakas;

public interface AsiakasDao {

	List<Asiakas> findAll();

	void insertAsiakas(Asiakas emp);

	void updateAsiakas(Asiakas emp);

	void executeUpdateAsiakas(Asiakas emp);

	public void deleteAsiakas(Asiakas emp);
}
