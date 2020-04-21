package com.sample.postgress.service;

import java.util.List;

import com.sample.postgress.entity.Tarvikeluettelo;

public interface TarvikeluetteloService {
	List<Tarvikeluettelo> findAll();

	void insertTarvikeluettelo(Tarvikeluettelo emp);

	void updateTarvikeluettelo(Tarvikeluettelo emp);

	void executeUpdateTarvikeluettelo(Tarvikeluettelo emp);

	void deleteTarvikeluettelo(Tarvikeluettelo emp);
	
}
