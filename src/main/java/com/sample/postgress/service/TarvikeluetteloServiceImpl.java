package com.sample.postgress.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sample.postgress.dao.TarvikeluetteloDao;
import com.sample.postgress.entity.Tarvikeluettelo;
@Component
public class TarvikeluetteloServiceImpl implements TarvikeluetteloService{
	@Resource 
	TarvikeluetteloDao TarvikeluetteloDao;
	@Override
	public List<Tarvikeluettelo> findAll() {
		return TarvikeluetteloDao.findAll();
	}
	@Override
	public void insertTarvikeluettelo(Tarvikeluettelo emp) {
		TarvikeluetteloDao.insertTarvikeluettelo(emp);
		
	}
	@Override
	public void updateTarvikeluettelo(Tarvikeluettelo emp) {
		TarvikeluetteloDao.updateTarvikeluettelo(emp);
		
	}
	@Override
	public void executeUpdateTarvikeluettelo(Tarvikeluettelo emp) {
		TarvikeluetteloDao.executeUpdateTarvikeluettelo(emp);
		
	}

	@Override
	public void deleteTarvikeluettelo(Tarvikeluettelo emp) {
		TarvikeluetteloDao.deleteTarvikeluettelo(emp);
		
	}
}
