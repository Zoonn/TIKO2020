package com.sample.postgress.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sample.postgress.dao.TyoDao;
import com.sample.postgress.entity.Tyo;
@Component
public class TyoServiceImpl implements TyoService{
	@Resource 
	TyoDao TyoDao;
	@Override
	public List<Tyo> findAll() {
		return TyoDao.findAll();
	}
	@Override
	public void insertTyo(Tyo tyo) {
		TyoDao.insertTyo(tyo);
		
	}
	@Override
	public void updateTyo(Tyo tyo) {
		TyoDao.updateTyo(tyo);
		
	}
	@Override
	public void executeUpdateTyo(Tyo tyo) {
		TyoDao.executeUpdateTyo(tyo);
		
	}

	@Override
	public void deleteTyo(int tyoid) {
		TyoDao.deleteTyo(tyoid);
		
	}

	@Override
	public Tyo findTyoById(int tyoid) {
	    return TyoDao.findTyoById(tyoid);
	}

}
