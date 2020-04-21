package com.sample.postgress.service;

import java.util.List;

import com.sample.postgress.entity.Lasku;

public interface LaskuService {
	List<Lasku> findAll();

	void insertLasku(Lasku emp);

	void updateLasku(Lasku emp);

	void executeUpdateLasku(Lasku emp);

	void deleteLasku(Lasku emp);
	
}
