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
	public void insertTyo(Tyo emp) {
		TyoDao.insertTyo(emp);
		
	}
	@Override
	public void updateTyo(Tyo emp) {
		TyoDao.updateTyo(emp);
		
	}
	@Override
	public void executeUpdateTyo(Tyo emp) {
		TyoDao.executeUpdateTyo(emp);
		
	}

	@Override
	public void deleteTyo(Tyo emp) {
		TyoDao.deleteTyo(emp);
		
	}
}
