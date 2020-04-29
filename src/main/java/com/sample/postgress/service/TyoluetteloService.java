package com.sample.postgress.service;

import java.util.List;

import com.sample.postgress.entity.Tyoluettelo;

public interface TyoluetteloService {
	List<Tyoluettelo> findAll();

	void insertTyoluettelo(Tyoluettelo tyoluettelo);

	void updateTyoluettelo(Tyoluettelo tyoluettelo);

	void executeUpdateTyoluettelo(Tyoluettelo tyoluettelo);

	void deleteTyoluettelo(int sopimusid);

	Tyoluettelo findTyoluetteloById(int tyoid);
	
}
