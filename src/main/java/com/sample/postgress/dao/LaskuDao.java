package com.sample.postgress.dao;

import java.util.List;

import com.sample.postgress.entity.Lasku;

public interface LaskuDao {

	List<Lasku> findAll();

	void insertLasku(Lasku emp);

	void updateLasku(Lasku emp);

	void executeUpdateLasku(Lasku emp);

	public void deleteLasku(Lasku emp);
}
