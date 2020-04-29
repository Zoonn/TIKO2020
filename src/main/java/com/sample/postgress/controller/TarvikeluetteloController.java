package com.sample.postgress.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.sample.postgress.entity.Tarvikeluettelo;
import com.sample.postgress.service.TarvikeluetteloService;

@RestController
@RequestMapping("/tarvikeluettelo")
public class TarvikeluetteloController {

	@Resource 
	TarvikeluetteloService TarvikeluetteloService;
	
	@GetMapping(value = "/list")
	public List<Tarvikeluettelo> getTarvikeluettelo() {
		return TarvikeluetteloService.findAll();
	
	}

	@RequestMapping(value= {"/", "/lista"}, method=RequestMethod.GET)
	public ModelAndView getTarvikkeet() {
	ModelAndView model = new ModelAndView();
	List<Tarvikeluettelo> list = TarvikeluetteloService.findAll();
	
	model.addObject("tarvikeluettelo_list", list);
	model.setViewName("list");
	return model;
	}

	@RequestMapping(value="/update/{tarvikeid}", method=RequestMethod.GET)
	public ModelAndView editTarvikeluettelo(@PathVariable int tarvikeid) {
	ModelAndView model = new ModelAndView();
	
	Tarvikeluettelo tarvikeluettelo = TarvikeluetteloService.findTarvikeluetteloById(tarvikeid);
	model.addObject("TarvikeluetteloForm", tarvikeluettelo);
	
	model.setViewName("tarvikeluettelo_form");
	return model;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addTarvikeluettelo() {
	ModelAndView model = new ModelAndView();
	
	Tarvikeluettelo Tarvikeluettelo = new Tarvikeluettelo();
	System.out.println("new Tarvikeluettelo made:"+ Tarvikeluettelo +"id:"+ Tarvikeluettelo.getsopimusid());
	model.addObject("TarvikeluetteloForm", Tarvikeluettelo);
	
	model.setViewName("tarvikeluettelo_form");
	return model;
	}
	
	@RequestMapping(value="/save_new", method=RequestMethod.POST)
	public ModelAndView saveOrUpdate(@ModelAttribute("TarvikeluetteloForm") Tarvikeluettelo tarvikeluettelo) {
		TarvikeluetteloService.insertTarvikeluettelo(tarvikeluettelo);

		return new ModelAndView("redirect:/");
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView savenew(@ModelAttribute("TarvikeluetteloForm") Tarvikeluettelo tarvikeluettelo) {
		TarvikeluetteloService.updateTarvikeluettelo(tarvikeluettelo);

		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/delete/{sopimusid}", method=RequestMethod.GET)
	public ModelAndView deleteTarvikeluettelo(@PathVariable("sopimusid") int sopimusid) {
	TarvikeluetteloService.deleteTarvikeluettelo(sopimusid);
	
	return new ModelAndView("redirect:/");
 }
}