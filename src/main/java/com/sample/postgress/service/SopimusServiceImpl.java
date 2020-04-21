package com.sample.postgress.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sample.postgress.dao.SopimusDao;
import com.sample.postgress.entity.Sopimus;
@Component
public class SopimusServiceImpl implements SopimusService{
	@Resource 
	SopimusDao SopimusDao;
	@Override
	public List<Sopimus> findAll() {
		return SopimusDao.findAll();
	}
	@Override
	public void insertSopimus(Sopimus emp) {
		SopimusDao.insertSopimus(emp);
		
	}
	@Override
	public void updateSopimus(Sopimus emp) {
		SopimusDao.updateSopimus(emp);
		
	}
	@Override
	public void executeUpdateSopimus(Sopimus emp) {
		SopimusDao.executeUpdateSopimus(emp);
		
	}

	@Override
	public void deleteSopimus(Sopimus emp) {
		SopimusDao.deleteSopimus(emp);
		
	}
}
