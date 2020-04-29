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
	public void insertAsiakas(Asiakas asiakas) {
		AsiakasDao.insertAsiakas(asiakas);
		
	}
	@Override
	public void updateAsiakas(Asiakas asiakas) {
		AsiakasDao.updateAsiakas(asiakas);
		
	}
	@Override
	public void executeUpdateAsiakas(Asiakas asiakas) {
		AsiakasDao.executeUpdateAsiakas(asiakas);
		
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
