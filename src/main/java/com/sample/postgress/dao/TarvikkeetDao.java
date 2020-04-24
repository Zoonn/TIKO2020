package com.sample.postgress.dao;

import java.util.List;

import com.sample.postgress.entity.Tarvikkeet;

public interface TarvikkeetDao {

	List<Tarvikkeet> findAll();

	void insertTarvikkeet(Tarvikkeet tarvikkeet);

	void updateTarvikkeet(Tarvikkeet tarvikkeet);

	void executeUpdateTarvikkeet(Tarvikkeet tarvikkeet);

	public void deleteTarvikkeet(Tarvikkeet tarvikkeet);
}
