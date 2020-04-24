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

import com.sample.postgress.entity.Tyo;
import com.sample.postgress.service.TyoService;

@RestController
@RequestMapping("/postgressApp")
public class TyoController {

    @Resource 
	TyoService TyoService;
	
	@GetMapping(value = "/TyoList")
	public List<Tyo> getTyo() {
		return TyoService.findAll();
	
	}
	
	@PostMapping(value = "/createTyo")
	public void createTyo(@RequestBody Tyo tyo) {
		 TyoService.insertTyo(tyo);
	
	}
	@PutMapping(value = "/updateTyo")
	public void updateTyo(@RequestBody Tyo tyo) {
		 TyoService.updateTyo(tyo);
	
	}
	@PutMapping(value = "/executeUpdateTyo")
	public void executeUpdateTyo(@RequestBody Tyo tyo) {
		 TyoService.executeUpdateTyo(tyo);
	
	}
	
	@DeleteMapping(value = "/deleteTyoById")
	public void deleteTyo(@RequestBody Tyo tyo) {
		 TyoService.deleteTyo(tyo);
	
    }
}