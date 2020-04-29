package com.sample.postgress.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sample.postgress.dao.LaskuDao;
import com.sample.postgress.entity.Lasku;
@Component
public class LaskuServiceImpl implements LaskuService{
	@Resource 
	LaskuDao LaskuDao;
	@Override
	public List<Lasku> findAll() {
		return LaskuDao.findAll();
	}
	@Override
	public void insertLasku(Lasku lasku) {
		LaskuDao.insertLasku(lasku);
		
	}
	@Override
	public void updateLasku(Lasku lasku) {
		LaskuDao.updateLasku(lasku);
		
	}
	@Override
	public void executeUpdateLasku(Lasku lasku) {
		LaskuDao.executeUpdateLasku(lasku);
		
	}

	@Override
	public void deleteLasku(int laskuid) {
		LaskuDao.deleteLasku(laskuid);
		
	}

	@Override
	public Lasku findLaskuById(int laskuid) {
	    return LaskuDao.findLaskuById(laskuid);
	}

}
