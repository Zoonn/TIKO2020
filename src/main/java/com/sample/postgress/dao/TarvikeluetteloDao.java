package com.sample.postgress.dao;

import java.util.List;

import com.sample.postgress.entity.Tarvikeluettelo;

public interface TarvikeluetteloDao {

	List<Tarvikeluettelo> findAll();

	void insertTarvikeluettelo(Tarvikeluettelo emp);

	void updateTarvikeluettelo(Tarvikeluettelo emp);

	void executeUpdateTarvikeluettelo(Tarvikeluettelo emp);

	public void deleteTarvikeluettelo(Tarvikeluettelo emp);
}
