package com.sample.postgress.service;

import java.util.List;

import com.sample.postgress.entity.Sopimus;

public interface SopimusService {
	List<Sopimus> findAll();

	void insertSopimus(Sopimus emp);

	void updateSopimus(Sopimus emp);

	void executeUpdateSopimus(Sopimus emp);

	void deleteSopimus(Sopimus emp);
	
}
