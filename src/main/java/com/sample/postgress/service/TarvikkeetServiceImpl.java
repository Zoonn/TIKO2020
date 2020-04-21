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
	public void insertTarvikkeet(Tarvikkeet emp) {
		TarvikkeetDao.insertTarvikkeet(emp);
		
	}
	@Override
	public void updateTarvikkeet(Tarvikkeet emp) {
		TarvikkeetDao.updateTarvikkeet(emp);
		
	}
	@Override
	public void executeUpdateTarvikkeet(Tarvikkeet emp) {
		TarvikkeetDao.executeUpdateTarvikkeet(emp);
		
	}

	@Override
	public void deleteTarvikkeet(Tarvikkeet emp) {
		TarvikkeetDao.deleteTarvikkeet(emp);
		
	}
}
