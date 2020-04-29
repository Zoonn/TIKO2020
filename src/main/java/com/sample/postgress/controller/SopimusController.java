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

import com.sample.postgress.entity.Sopimus;
import com.sample.postgress.service.SopimusService;

@RestController
@RequestMapping("/sopimus")
public class SopimusController {

	@Resource 
	SopimusService SopimusService;
	
	@GetMapping(value = "/list")
	public List<Sopimus> getSopimus() {
		return SopimusService.findAll();
	
	}

	@RequestMapping(value= {"/", "/lista"}, method=RequestMethod.GET)
	public ModelAndView getAsiakkaat() {
	ModelAndView model = new ModelAndView();
	List<Sopimus> list = SopimusService.findAll();
	
	model.addObject("sopimus_list", list);
	model.setViewName("list");
	return model;
	}

	@RequestMapping(value="/update/{Sopimusid}", method=RequestMethod.GET)
	public ModelAndView editSopimus(@PathVariable int Sopimusid) {
	ModelAndView model = new ModelAndView();
	
	Sopimus Sopimus = SopimusService.findSopimusById(Sopimusid);
	model.addObject("SopimusForm", Sopimus);
	
	model.setViewName("sopimus_form");
	return model;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addSopimus() {
	ModelAndView model = new ModelAndView();
	
	Sopimus Sopimus = new Sopimus();
	System.out.println("new Sopimus made:"+ Sopimus + Sopimus.getsopimusid());
	model.addObject("SopimusForm", Sopimus);
	
	model.setViewName("sopimus_form");
	return model;
	}
	
	@RequestMapping(value="/save_new", method=RequestMethod.POST)
	public ModelAndView saveOrUpdate(@ModelAttribute("SopimusForm") Sopimus Sopimus) {
		SopimusService.insertSopimus(Sopimus);

		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView savenew(@ModelAttribute("SopimusForm") Sopimus Sopimus) {
	    SopimusService.updateSopimus(Sopimus);
	
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/delete/{sopimusid}", method=RequestMethod.GET)
	public ModelAndView deleteSopimus(@PathVariable("sopimusid") int sopimusid) {
	SopimusService.deleteSopimus(sopimusid);
	
	return new ModelAndView("redirect:/");
 }
}