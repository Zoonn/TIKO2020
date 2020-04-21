package com.sample.postgress.dao;

import java.util.List;

import com.sample.postgress.entity.Tarvikkeet;

public interface TarvikkeetDao {

	List<Tarvikkeet> findAll();

	void insertTarvikkeet(Tarvikkeet emp);

	void updateTarvikkeet(Tarvikkeet emp);

	void executeUpdateTarvikkeet(Tarvikkeet emp);

	public void deleteTarvikkeet(Tarvikkeet emp);
}
