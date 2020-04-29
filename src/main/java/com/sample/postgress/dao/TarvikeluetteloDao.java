package com.sample.postgress.dao;

import java.util.List;

import com.sample.postgress.entity.Tarvikeluettelo;

public interface TarvikeluetteloDao {

	List<Tarvikeluettelo> findAll();

	void insertTarvikeluettelo(Tarvikeluettelo tarvikeluettelo);

	void updateTarvikeluettelo(Tarvikeluettelo tarvikeluettelo);

	void executeUpdateTarvikeluettelo(Tarvikeluettelo tarvikeluettelo);

	void deleteTarvikeluettelo(int sopimusid);

	Tarvikeluettelo findTarvikeluetteloById(int tarvikeid);
}
