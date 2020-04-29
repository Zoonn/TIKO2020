package com.sample.postgress.service;

import java.util.List;

import com.sample.postgress.entity.Sopimus;

public interface SopimusService {
	List<Sopimus> findAll();

	void insertSopimus(Sopimus sopimusid);

	void updateSopimus(Sopimus sopimusid);

	void executeUpdateSopimus(Sopimus sopimusid);

	void deleteSopimus(int sopimusid);

	Sopimus findSopimusById(int sopimusid);
	
}
