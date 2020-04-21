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
public class ApplicationController {

	@Resource 
	AsiakasService AsiakasService;
	
	@GetMapping(value = "/AsiakasList")
	public List<Asiakas> getAsiakass() {
		return AsiakasService.findAll();
	
	}
	
	@PostMapping(value = "/createEmp")
	public void createAsiakas(@RequestBody Asiakas emp) {
		 AsiakasService.insertAsiakas(emp);
	
	}
	@PutMapping(value = "/updateEmp")
	public void updateAsiakas(@RequestBody Asiakas emp) {
		 AsiakasService.updateAsiakas(emp);
	
	}
	@PutMapping(value = "/executeUpdateEmp")
	public void executeUpdateAsiakas(@RequestBody Asiakas emp) {
		 AsiakasService.executeUpdateAsiakas(emp);
	
	}
	
	@DeleteMapping(value = "/deleteEmpById")
	public void deleteAsiakas(@RequestBody Asiakas emp) {
		 AsiakasService.deleteAsiakas(emp);
	
	}
	
	
}
