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
	public void insertTyoluettelo(Tyoluettelo tyoluettelo) {
		TyoluetteloDao.insertTyoluettelo(tyoluettelo);
		
	}
	@Override
	public void updateTyoluettelo(Tyoluettelo tyoluettelo) {
		TyoluetteloDao.updateTyoluettelo(tyoluettelo);
		
	}
	@Override
	public void executeUpdateTyoluettelo(Tyoluettelo tyoluettelo) {
		TyoluetteloDao.executeUpdateTyoluettelo(tyoluettelo);
		
	}

	@Override
	public void deleteTyoluettelo(int sopimusid) {
		TyoluetteloDao.deleteTyoluettelo(sopimusid);
		
	}

	@Override
	public Tyoluettelo findTyoluetteloById(int tyoid) {
	    return TyoluetteloDao.findTyoluetteloById(tyoid);
	}
}

