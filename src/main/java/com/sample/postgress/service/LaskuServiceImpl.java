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
	public void insertLasku(Lasku emp) {
		LaskuDao.insertLasku(emp);
		
	}
	@Override
	public void updateLasku(Lasku emp) {
		LaskuDao.updateLasku(emp);
		
	}
	@Override
	public void executeUpdateLasku(Lasku emp) {
		LaskuDao.executeUpdateLasku(emp);
		
	}

	@Override
	public void deleteLasku(Lasku emp) {
		LaskuDao.deleteLasku(emp);
		
	}
}
