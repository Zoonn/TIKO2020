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

import com.sample.postgress.entity.Tarvikeluettelo;
import com.sample.postgress.service.TarvikeluetteloService;

@RestController
@RequestMapping("/tarvikeluettelo")
public class TarvikeluetteloController {

    @Resource 
	TarvikeluetteloService TarvikeluetteloService;
	
	@GetMapping(value = "/TarvikeluetteloList")
	public List<Tarvikeluettelo> getTarvikeluettelo() {
		return TarvikeluetteloService.findAll();
	
	}
	
	@PostMapping(value = "/createTarvikeluettelo")
	public void createTarvikeluettelo(@RequestBody Tarvikeluettelo tarvikeluettelo) {
		 TarvikeluetteloService.insertTarvikeluettelo(tarvikeluettelo);
	
	}
	@PutMapping(value = "/updateTarvikeluettelo")
	public void updateTarvikeluettelo(@RequestBody Tarvikeluettelo tarvikeluettelo) {
		 TarvikeluetteloService.updateTarvikeluettelo(tarvikeluettelo);
	
	}
	@PutMapping(value = "/executeUpdateTarvikeluettelo")
	public void executeUpdateTarvikeluettelo(@RequestBody Tarvikeluettelo tarvikeluettelo) {
		 TarvikeluetteloService.executeUpdateTarvikeluettelo(tarvikeluettelo);
	
	}
	
	@DeleteMapping(value = "/deleteTarvikeluetteloById")
	public void deleteTarvikeluettelo(@RequestBody Tarvikeluettelo tarvikeluettelo) {
		 TarvikeluetteloService.deleteTarvikeluettelo(tarvikeluettelo);
	
    }
}