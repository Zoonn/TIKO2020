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

import com.sample.postgress.entity.Tyo;
import com.sample.postgress.service.TyoService;

@RestController
@RequestMapping("/tyo")
public class TyoController {

	@Resource 
	TyoService TyoService;
	
	@GetMapping(value = "/list")
	public List<Tyo> getTyo() {
		return TyoService.findAll();
	
	}

	@RequestMapping(value= {"/", "/lista"}, method=RequestMethod.GET)
	public ModelAndView getTyot() {
	ModelAndView model = new ModelAndView();
	List<Tyo> list = TyoService.findAll();
	
	model.addObject("tyo_list", list);
	model.setViewName("list");
	return model;
	}

	@RequestMapping(value="/update/{Tyoid}", method=RequestMethod.GET)
	public ModelAndView editTyo(@PathVariable int Tyoid) {
	ModelAndView model = new ModelAndView();
	
	Tyo Tyo = TyoService.findTyoById(Tyoid);
	model.addObject("tyoForm", Tyo);
	
	model.setViewName("tyo_form");
	return model;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addTyo() {
	ModelAndView model = new ModelAndView();
	
	Tyo Tyo = new Tyo();
	System.out.println("new Tyo made:"+ Tyo + Tyo.gettyoid());
	model.addObject("tyoForm", Tyo);
	
	model.setViewName("tyo_form");
	return model;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView saveOrUpdate(@ModelAttribute("tyoForm") Tyo Tyo) {
		System.out.println("\n!!! TyoID found. Updating Tyo...\n"+ Tyo+ " id:"+Tyo.gettyoid());
		TyoService.updateTyo(Tyo);
	
	return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/save_new", method=RequestMethod.POST)
	public ModelAndView saveNew(@ModelAttribute("tyoForm") Tyo Tyo) {
		TyoService.insertTyo(Tyo);
	
	return new ModelAndView("redirect:/");
	}


	@RequestMapping(value="/delete/{tyoid}", method=RequestMethod.GET)
	public ModelAndView deleteTyo(@PathVariable("tyoid") int tyoid) {
	TyoService.deleteTyo(tyoid);
	
	return new ModelAndView("redirect:/");
 }
}