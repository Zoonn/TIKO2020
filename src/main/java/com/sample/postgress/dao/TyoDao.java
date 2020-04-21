package com.sample.postgress.dao;

import java.util.List;

import com.sample.postgress.entity.Tyo;

public interface TyoDao {

	List<Tyo> findAll();

	void insertTyo(Tyo emp);

	void updateTyo(Tyo emp);

	void executeUpdateTyo(Tyo emp);

	public void deleteTyo(Tyo emp);
}
