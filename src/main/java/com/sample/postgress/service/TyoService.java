package com.sample.postgress.service;

import java.util.List;

import com.sample.postgress.entity.Tyo;

public interface TyoService {
	List<Tyo> findAll();

	void insertTyo(Tyo emp);

	void updateTyo(Tyo emp);

	void executeUpdateTyo(Tyo emp);

	void deleteTyo(Tyo emp);
	
}
