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

import com.sample.postgress.entity.Tarvikkeet;
import com.sample.postgress.service.TarvikkeetService;

@RestController
@RequestMapping("/tarvikkeet")
public class TarvikkeetController {

	@Resource 
	TarvikkeetService TarvikkeetService;
	
	@GetMapping(value = "/list")
	public List<Tarvikkeet> getTarvike() {
		return TarvikkeetService.findAll();
	
	}

	@RequestMapping(value= {"/", "/lista"}, method=RequestMethod.GET)
	public ModelAndView getTarvikkeet() {
	ModelAndView model = new ModelAndView();
	List<Tarvikkeet> list = TarvikkeetService.findAll();
	
	model.addObject("tarvike_list", list);
	model.setViewName("list");
	return model;
	}

	@RequestMapping(value="/update/{tarvikkeetid}", method=RequestMethod.GET)
	public ModelAndView editTarvikkeet(@PathVariable int tarvikeid) {
	ModelAndView model = new ModelAndView();
	
	Tarvikkeet Tarvikkeet = TarvikkeetService.findTarvikeById(tarvikeid);
	model.addObject("tarvikkeetForm", Tarvikkeet);
	
	model.setViewName("tarvike_form");
	return model;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addTarvikkeet() {
	ModelAndView model = new ModelAndView();
	
	Tarvikkeet tarvikkeet = new Tarvikkeet();
	System.out.println("new Tarvikkeet made:"+ tarvikkeet +"id: "+ tarvikkeet.gettarvikeid());
	model.addObject("tarvikkeetForm", tarvikkeet);
	
	model.setViewName("tarvike_form");
	return model;
	}
	
	@RequestMapping(value="/save_new", method=RequestMethod.POST)
	public ModelAndView saveOrUpdate(@ModelAttribute("TarvikeForm") Tarvikkeet tarvikkeet) {

		TarvikkeetService.insertTarvikkeet(tarvikkeet);
		return new ModelAndView("redirect:/");
	}
		
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView savenew(@ModelAttribute("TarvikeForm") Tarvikkeet tarvikkeet) {

		TarvikkeetService.updateTarvikkeet(tarvikkeet);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/delete/{tarvikeid}", method=RequestMethod.GET)
	public ModelAndView deleteTarvikkeet(@PathVariable("tarvikeid") int tarvikeid) {
	TarvikkeetService.deleteTarvikkeet(tarvikeid);
	
	return new ModelAndView("redirect:/");
 }
}