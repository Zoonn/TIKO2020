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

import com.sample.postgress.entity.Asiakas;
import com.sample.postgress.service.AsiakasService;

@RestController
@RequestMapping("/postgressApp")
public class AsiakasController {

	@Resource 
	AsiakasService AsiakasService;
	
	@GetMapping(value = "/AsiakasList")
	public List<Asiakas> getAsiakas() {
		return AsiakasService.findAll();
	
	}
	
	@PostMapping(value = "/createAsiakas")
	public void createAsiakas(@RequestBody Asiakas asiakas) {
		 AsiakasService.insertAsiakas(asiakas);
	
	}
	@PutMapping(value = "/updateAsiakas")
	public void updateAsiakas(@RequestBody Asiakas asiakas) {
		 AsiakasService.updateAsiakas(asiakas);
	
	}
	@PutMapping(value = "/executeUpdateAsiakas")
	public void executeUpdateAsiakas(@RequestBody Asiakas asiakas) {
		 AsiakasService.executeUpdateAsiakas(asiakas);
	
	}
	
	@DeleteMapping(value = "/deleteAsiakasById")
	public void deleteAsiakas(@RequestBody Asiakas asiakas) {
		 AsiakasService.deleteAsiakas(asiakas);
	
    }
}