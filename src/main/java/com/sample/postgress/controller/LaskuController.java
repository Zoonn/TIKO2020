/* package com.sample.postgress.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.sample.postgress.entity.Lasku;
import com.sample.postgress.service.LaskuService;

@RestController
@RequestMapping("/lasku")
public class LaskuController {

	@Resource 
	LaskuService laskuService;
	
	@GetMapping(value = "/list")
	public List<Lasku> getLasku() {
		return LaskuService.findAll();
	
	}

	@RequestMapping(value= {"/", "/lista"}, method=RequestMethod.GET)
	public ModelAndView getAsiakkaat() {
	ModelAndView model = new ModelAndView();
	List<Lasku> list = LaskuService.findAll();
	
	model.addObject("lasku_list", list);
	model.setViewName("lasku_list");
	return model;
	}

	@RequestMapping(value="/update/{laskuid}", method=RequestMethod.GET)
	public ModelAndView editlasku(@PathVariable int laskuid) {
	ModelAndView model = new ModelAndView();
	
	Lasku lasku = LaskuService.findLaskuById(laskuid);
	model.addObject("laskuForm", lasku);
	
	model.setViewName("lasku_form");
	return model;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addlasku() {
	ModelAndView model = new ModelAndView();
	
	Lasku lasku = new Lasku();
	System.out.println("new lasku made:"+ lasku + lasku.getlaskuid());
	model.addObject("laskuForm", lasku);
	
	model.setViewName("lasku_form");
	return model;
	}
	
	@RequestMapping(value="/save_new", method=RequestMethod.POST)
	public ModelAndView saveOrUpdate(@ModelAttribute("laskuForm") Lasku lasku) {

		LaskuService.insertlasku(lasku);
		return new ModelAndView("redirect:/lasku/lista");
	}

	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView saveOrUpdate(@ModelAttribute("laskuForm") Lasku lasku) {

	    LaskuService.updateLasku(lasku);
		return new ModelAndView("redirect:/lasku/lista");
	}
	
	@RequestMapping(value="/delete/{laskuid}", method=RequestMethod.GET)
	public ModelAndView deletelasku(@PathVariable("laskuid") int laskuid) {
	LaskuService.deleteLasku(laskuid);
	
	return new ModelAndView("redirect:/lasku/lista");
 }
} */