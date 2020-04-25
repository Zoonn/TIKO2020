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

import com.sample.postgress.entity.Sopimus;
import com.sample.postgress.service.SopimusService;

@RestController
@RequestMapping("/sopimus")
public class SopimusController {

    @Resource 
	SopimusService SopimusService;
	
	@GetMapping(value = "/SopimusList")
	public List<Sopimus> getSopimus() {
		return SopimusService.findAll();
	
	}
	
	@PostMapping(value = "/createSopimus")
	public void createSopimus(@RequestBody Sopimus sopimus) {
		 SopimusService.insertSopimus(sopimus);
	
	}
	@PutMapping(value = "/updateSopimus")
	public void updateSopimus(@RequestBody Sopimus sopimus) {
		 SopimusService.updateSopimus(sopimus);
	
	}
	@PutMapping(value = "/executeUpdateSopimus")
	public void executeUpdateSopimus(@RequestBody Sopimus sopimus) {
		 SopimusService.executeUpdateSopimus(sopimus);
	
	}
	
	@DeleteMapping(value = "/deleteSopimusById")
	public void deleteSopimus(@RequestBody Sopimus sopimus) {
		 SopimusService.deleteSopimus(sopimus);
	
    }
}