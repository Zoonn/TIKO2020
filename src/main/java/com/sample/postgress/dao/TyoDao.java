package com.sample.postgress.dao;

import java.util.List;

import com.sample.postgress.entity.Tyo;

public interface TyoDao {

	List<Tyo> findAll();

	void insertTyo(Tyo tyo);

	void updateTyo(Tyo tyo);

	void executeUpdateTyo(Tyo tyo);

	public void deleteTyo(Tyo tyo);
}
