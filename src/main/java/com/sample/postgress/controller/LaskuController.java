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

import com.sample.postgress.entity.Lasku;
import com.sample.postgress.service.LaskuService;

@RestController
@RequestMapping("/postgressApp")
public class LaskuController {

    @Resource 
	LaskuService LaskuService;
	
	@GetMapping(value = "/LaskuList")
	public List<Lasku> getLasku() {
		return LaskuService.findAll();
	
	}
	
	@PostMapping(value = "/createLasku")
	public void createLasku(@RequestBody Lasku lasku) {
		 LaskuService.insertLasku(lasku);
	
	}
	@PutMapping(value = "/updateLasku")
	public void updateLasku(@RequestBody Lasku lasku) {
		 LaskuService.updateLasku(lasku);
	
	}
	@PutMapping(value = "/executeUpdateLasku")
	public void executeUpdateLasku(@RequestBody Lasku lasku) {
		 LaskuService.executeUpdateLasku(lasku);
	
	}
	
	@DeleteMapping(value = "/deleteLaskuById")
	public void deleteLasku(@RequestBody Lasku lasku) {
		 LaskuService.deleteLasku(lasku);
	
    }
}