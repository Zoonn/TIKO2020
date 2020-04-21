package com.sample.postgress.dao;

import java.util.List;

import com.sample.postgress.entity.Sopimus;

public interface SopimusDao {

	List<Sopimus> findAll();

	void insertSopimus(Sopimus emp);

	void updateSopimus(Sopimus emp);

	void executeUpdateSopimus(Sopimus emp);

	public void deleteSopimus(Sopimus emp);
}
