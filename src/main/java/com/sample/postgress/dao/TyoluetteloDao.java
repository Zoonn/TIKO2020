package com.sample.postgress.dao;

import java.util.List;

import com.sample.postgress.entity.Tyoluettelo;

public interface TyoluetteloDao {

	List<Tyoluettelo> findAll();

	void insertTyoluettelo(Tyoluettelo emp);

	void updateTyoluettelo(Tyoluettelo emp);

	void executeUpdateTyoluettelo(Tyoluettelo emp);

	public void deleteTyoluettelo(Tyoluettelo emp);
}
