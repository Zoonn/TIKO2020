package com.sample.postgress.dao;

import java.util.List;

import com.sample.postgress.entity.Lasku;

public interface LaskuDao {

	List<Lasku> findAll();

	void insertLasku(Lasku lasku);

	void updateLasku(Lasku lasku);

	void executeUpdateLasku(Lasku lasku);

	public void deleteLasku(Lasku lasku);
}
