package com.sample.postgress.service;

import java.util.List;

import com.sample.postgress.entity.Tarvikeluettelo;

public interface TarvikeluetteloService {
	List<Tarvikeluettelo> findAll();

	void insertTarvikeluettelo(Tarvikeluettelo tarvikeluettelo);

	void updateTarvikeluettelo(Tarvikeluettelo tarvikeluettelo);

	void executeUpdateTarvikeluettelo(Tarvikeluettelo tarvikeluettelo);

	void deleteTarvikeluettelo(int sopimusid);

	Tarvikeluettelo findTarvikeluetteloById(int sopimusid);
	
}
