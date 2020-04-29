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

import com.sample.postgress.entity.Asiakas;
import com.sample.postgress.service.AsiakasService;

@RestController
@RequestMapping("/asiakas")
public class AsiakasController {

	@Resource 
	AsiakasService AsiakasService;
	
	@GetMapping(value = "/list")
	public List<Asiakas> getAsiakas() {
		return AsiakasService.findAll();
	
	}

	@RequestMapping(value= {"/", "/lista"}, method=RequestMethod.GET)
	public ModelAndView getAsiakkaat() {
	ModelAndView model = new ModelAndView();
	List<Asiakas> list = AsiakasService.findAll();
	
	model.addObject("asiakas_list", list);
	model.setViewName("list");
	return model;
	}

	@RequestMapping(value="/update/{asiakasid}", method=RequestMethod.GET)
	public ModelAndView editAsiakas(@PathVariable int asiakasid) {
	ModelAndView model = new ModelAndView();
	
	Asiakas asiakas = AsiakasService.findAsiakasById(asiakasid);
	model.addObject("asiakasForm", asiakas);
	
	model.setViewName("asiakas_form");
	return model;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addAsiakas() {
	ModelAndView model = new ModelAndView();
	
	Asiakas asiakas = new Asiakas();
	System.out.println("new asiakas made:"+ asiakas + asiakas.getasiakasid());
	model.addObject("asiakasForm", asiakas);
	
	model.setViewName("asiakas_form");
	return model;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView saveOrUpdate(@ModelAttribute("asiakasForm") Asiakas asiakas) {
	if (asiakas.getasiakasid() == ""){
		System.out.println("\n!!! ASIAKASID not found. Creating new asiakas...\n");
		AsiakasService.insertAsiakas(asiakas);
		}
	else if(asiakas.getasiakasid() != null) {
	    System.out.println("\n!!! ASIAKASID found. Updating asiakas...\n"+ asiakas+ " id:"+asiakas.getasiakasid());
	    AsiakasService.updateAsiakas(asiakas);
	} 
	else{
		System.out.println("ERROR");
	  }
	
	
	return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/delete/{asiakasid}", method=RequestMethod.GET)
	public ModelAndView deleteAsiakas(@PathVariable("asiakasid") int asiakasid) {
	AsiakasService.deleteAsiakas(asiakasid);
	
	return new ModelAndView("redirect:/");
 }
}