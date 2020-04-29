package com.sample.postgress.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sample.postgress.dao.TarvikkeetDao;
import com.sample.postgress.entity.Tarvikkeet;
@Component
public class TarvikkeetServiceImpl implements TarvikkeetService{
	@Resource 
	TarvikkeetDao TarvikkeetDao;
	@Override
	public List<Tarvikkeet> findAll() {
		return TarvikkeetDao.findAll();
	}
	@Override
	public void insertTarvikkeet(Tarvikkeet tarvikkeet) {
		TarvikkeetDao.insertTarvikkeet(tarvikkeet);
		
	}
	@Override
	public void updateTarvikkeet(Tarvikkeet tarvikkeet) {
		TarvikkeetDao.updateTarvikkeet(tarvikkeet);
		
	}
	@Override
	public void executeUpdateTarvikkeet(Tarvikkeet tarvikkeet) {
		TarvikkeetDao.executeUpdateTarvikkeet(tarvikkeet);
		
	}

	@Override
	public void deleteTarvikkeet(int tarvikeid) {
		TarvikkeetDao.deleteTarvikkeet(tarvikeid);
		
	}

	@Override
	public Tarvikkeet findTarvikeById(int tarvikeid) {
	    return TarvikkeetDao.findTarvikkeetById(tarvikeid);
	}
}

