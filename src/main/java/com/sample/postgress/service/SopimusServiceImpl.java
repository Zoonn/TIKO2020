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
	public void insertSopimus(Sopimus sopimus) {
		SopimusDao.insertSopimus(sopimus);
		
	}
	@Override
	public void updateSopimus(Sopimus sopimus) {
		SopimusDao.updateSopimus(sopimus);
		
	}
	@Override
	public void executeUpdateSopimus(Sopimus sopimus) {
		SopimusDao.executeUpdateSopimus(sopimus);
		
	}

	@Override
	public void deleteSopimus(int sopimusid) {
		SopimusDao.deleteSopimus(sopimusid);
		
	}

	@Override
	public Sopimus findSopimusById(int sopimusid) {
	    return SopimusDao.findSopimusById(sopimusid);
	}
}

