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
	public void insertTarvikeluettelo(Tarvikeluettelo tarvikeluettelo) {
		TarvikeluetteloDao.insertTarvikeluettelo(tarvikeluettelo);
		
	}
	@Override
	public void updateTarvikeluettelo(Tarvikeluettelo tarvikeluettelo) {
		TarvikeluetteloDao.updateTarvikeluettelo(tarvikeluettelo);
		
	}
	@Override
	public void executeUpdateTarvikeluettelo(Tarvikeluettelo tarvikeluettelo) {
		TarvikeluetteloDao.executeUpdateTarvikeluettelo(tarvikeluettelo);
		
	}

	@Override
	public void deleteTarvikeluettelo(int sopimusid) {
		TarvikeluetteloDao.deleteTarvikeluettelo(sopimusid);
		
	}

	@Override
	public Tarvikeluettelo findTarvikeluetteloById(int tarvikeid) {
	    return TarvikeluetteloDao.findTarvikeluetteloById(tarvikeid);
	}
}

