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

import com.sample.postgress.entity.Tyoluettelo;
import com.sample.postgress.service.TyoluetteloService;

@RestController
@RequestMapping("/tyoluettelo")
public class TyoluetteloController {

	@Resource 
	TyoluetteloService TyoluetteloService;
	
	@GetMapping(value = "/list")
	public List<Tyoluettelo> getTyoluettelo() {
		return TyoluetteloService.findAll();
	
	}

	@RequestMapping(value= {"/", "/lista"}, method=RequestMethod.GET)
	public ModelAndView getTyot() {
	ModelAndView model = new ModelAndView();
	List<Tyoluettelo> list = TyoluetteloService.findAll();
	
	model.addObject("tyoluettelo_list", list);
	model.setViewName("list");
	return model;
	}

	@RequestMapping(value="/update/{tyoid}", method=RequestMethod.GET)
	public ModelAndView editTyoluettelo(@PathVariable int tyoid) {
	ModelAndView model = new ModelAndView();
	
	Tyoluettelo tyoluettelo = TyoluetteloService.findTyoluetteloById(tyoid);
	model.addObject("tyoluetteloForm", tyoluettelo);
	
	model.setViewName("tyoluettelo_form");
	return model;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addTyoluettelo() {
	ModelAndView model = new ModelAndView();
	
	Tyoluettelo Tyoluettelo = new Tyoluettelo();
	System.out.println("new Tyoluettelo made:"+ Tyoluettelo +"id: "+ Tyoluettelo.getsopimusid());
	model.addObject("tyoluetteloForm", Tyoluettelo);
	
	model.setViewName("tyoluettelo_form");
	return model;
	}
	
	@RequestMapping(value="/save_new", method=RequestMethod.POST)
	public ModelAndView saveOrUpdate(@ModelAttribute("TyoluetteloForm") Tyoluettelo Tyoluettelo) {
		TyoluetteloService.insertTyoluettelo(Tyoluettelo);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView savenew(@ModelAttribute("TyoluetteloForm") Tyoluettelo Tyoluettelo) {
	    TyoluetteloService.updateTyoluettelo(Tyoluettelo);
	
	return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/delete/{sopimusid}", method=RequestMethod.GET)
	public ModelAndView deleteTyoluettelo(@PathVariable("sopimusid") int sopimusid) {
	TyoluetteloService.deleteTyoluettelo(sopimusid);
	
	return new ModelAndView("redirect:/");
 }
}