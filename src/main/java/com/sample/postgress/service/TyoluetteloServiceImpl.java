package com.sample.postgress.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sample.postgress.dao.TyoluetteloDao;
import com.sample.postgress.entity.Tyoluettelo;
@Component
public class TyoluetteloServiceImpl implements TyoluetteloService{
	@Resource 
	TyoluetteloDao TyoluetteloDao;
	@Override
	public List<Tyoluettelo> findAll() {
		return TyoluetteloDao.findAll();
	}
	@Override
	public void insertTyoluettelo(Tyoluettelo emp) {
		TyoluetteloDao.insertTyoluettelo(emp);
		
	}
	@Override
	public void updateTyoluettelo(Tyoluettelo emp) {
		TyoluetteloDao.updateTyoluettelo(emp);
		
	}
	@Override
	public void executeUpdateTyoluettelo(Tyoluettelo emp) {
		TyoluetteloDao.executeUpdateTyoluettelo(emp);
		
	}

	@Override
	public void deleteTyoluettelo(Tyoluettelo emp) {
		TyoluetteloDao.deleteTyoluettelo(emp);
		
	}
}
