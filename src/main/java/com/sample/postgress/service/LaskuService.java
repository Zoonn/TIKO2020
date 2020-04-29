package com.sample.postgress.service;

import java.util.List;

import com.sample.postgress.entity.Lasku;

public interface LaskuService {
	List<Lasku> findAll();

	void insertLasku(Lasku lasku);

	void updateLasku(Lasku lasku);

	void executeUpdateLasku(Lasku lasku);

	void deleteLasku(int laskuid);

	Lasku findLaskuById(int laskuid);
	
}
