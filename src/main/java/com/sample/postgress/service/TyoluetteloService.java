package com.sample.postgress.service;

import java.util.List;

import com.sample.postgress.entity.Tyoluettelo;

public interface TyoluetteloService {
	List<Tyoluettelo> findAll();

	void insertTyoluettelo(Tyoluettelo emp);

	void updateTyoluettelo(Tyoluettelo emp);

	void executeUpdateTyoluettelo(Tyoluettelo emp);

	void deleteTyoluettelo(Tyoluettelo emp);
	
}
