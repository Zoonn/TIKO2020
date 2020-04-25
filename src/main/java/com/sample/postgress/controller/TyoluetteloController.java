package com.sample.postgress.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sample.postgress.entity.Tyoluettelo;
import com.sample.postgress.service.TyoluetteloService;

@RestController
@RequestMapping("/tyoluettelo")
public class TyoluetteloController {

    @Resource 
	TyoluetteloService TyoluetteloService;
	
	@GetMapping(value = "/TyoluetteloList")
	public List<Tyoluettelo> getTyoluettelo() {
		return TyoluetteloService.findAll();
	
	}
	
	@PostMapping(value = "/createTyoluettelo")
	public void createTyoluettelo(@RequestBody Tyoluettelo tyoluettelo) {
		 TyoluetteloService.insertTyoluettelo(tyoluettelo);
	
	}
	@PutMapping(value = "/updateTyoluettelo")
	public void updateTyoluettelo(@RequestBody Tyoluettelo tyoluettelo) {
		 TyoluetteloService.updateTyoluettelo(tyoluettelo);
	
	}
	@PutMapping(value = "/executeUpdateTyoluettelo")
	public void executeUpdateTyoluettelo(@RequestBody Tyoluettelo tyoluettelo) {
		 TyoluetteloService.executeUpdateTyoluettelo(tyoluettelo);
	
	}
	
	@DeleteMapping(value = "/deleteTyoluetteloById")
	public void deleteTyoluettelo(@RequestBody Tyoluettelo tyoluettelo) {
		 TyoluetteloService.deleteTyoluettelo(tyoluettelo);
	
    } 
}