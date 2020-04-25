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

import com.sample.postgress.entity.Tarvikkeet;
import com.sample.postgress.service.TarvikkeetService;

@RestController
@RequestMapping("/tarvikkeet")
public class TarvikkeetController {

    @Resource 
	TarvikkeetService TarvikkeetService;
	
	@GetMapping(value = "/TarvikkeetList")
	public List<Tarvikkeet> getTarvikkeet() {
		return TarvikkeetService.findAll();
	
	}
	
	@PostMapping(value = "/createTarvikkeet")
	public void createTarvikkeet(@RequestBody Tarvikkeet tarvikkeet) {
		 TarvikkeetService.insertTarvikkeet(tarvikkeet);
	
	}
	@PutMapping(value = "/updateTarvikkeet")
	public void updateTarvikkeet(@RequestBody Tarvikkeet tarvikkeet) {
		 TarvikkeetService.updateTarvikkeet(tarvikkeet);
	
	}
	@PutMapping(value = "/executeUpdateTarvikkeet")
	public void executeUpdateTarvikkeet(@RequestBody Tarvikkeet tarvikkeet) {
		 TarvikkeetService.executeUpdateTarvikkeet(tarvikkeet);
	
	}
	
	@DeleteMapping(value = "/deleteTarvikkeetById")
	public void deleteTarvikkeet(@RequestBody Tarvikkeet tarvikkeet) {
		 TarvikkeetService.deleteTarvikkeet(tarvikkeet);
	
    }
}