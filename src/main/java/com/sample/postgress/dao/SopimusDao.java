package com.sample.postgress.dao;

import java.util.List;

import com.sample.postgress.entity.Sopimus;

public interface SopimusDao {

	List<Sopimus> findAll();

	void insertSopimus(Sopimus sopimus);

	void updateSopimus(Sopimus sopimus);

	void executeUpdateSopimus(Sopimus sopimus);

	void deleteSopimus(int sopimusid);

	Sopimus findSopimusById(int sopimusid);
}
