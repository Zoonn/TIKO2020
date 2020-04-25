package com.sample.postgress.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sample.postgress.dao.AsiakasDao;
import com.sample.postgress.entity.Asiakas;
@Component
public class AsiakasServiceImpl implements AsiakasService{
	@Resource 
	AsiakasDao AsiakasDao;
	@Override
	public List<Asiakas> findAll() {
		return AsiakasDao.findAll();
	}
	@Override
	public void insertAsiakas(Asiakas emp) {
		AsiakasDao.insertAsiakas(emp);
		
	}
	@Override
	public void updateAsiakas(Asiakas emp) {
		AsiakasDao.updateAsiakas(emp);
		
	}
	@Override
	public void executeUpdateAsiakas(Asiakas emp) {
		AsiakasDao.executeUpdateAsiakas(emp);
		
	}

	@Override
	public void deleteAsiakas(int asiakasid) {
		AsiakasDao.deleteAsiakas(asiakasid);
		
	}

	@Override
	public Asiakas findAsiakasById(int asiakasid) {
	    return AsiakasDao.findAsiakasById(asiakasid);
	}
}
