package com.sample.postgress.dao;

import java.util.List;

import com.sample.postgress.entity.Tyoluettelo;

public interface TyoluetteloDao {

	List<Tyoluettelo> findAll();

	void insertTyoluettelo(Tyoluettelo tyoluettelo);

	void updateTyoluettelo(Tyoluettelo tyoluettelo);

	void executeUpdateTyoluettelo(Tyoluettelo tyoluettelo);

	public void deleteTyoluettelo(Tyoluettelo tyoluettelo);
}
