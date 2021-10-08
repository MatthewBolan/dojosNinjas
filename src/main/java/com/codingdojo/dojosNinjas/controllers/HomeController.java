package com.codingdojo.dojosNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.dojosNinjas.models.Dojo;
import com.codingdojo.dojosNinjas.models.Ninja;
import com.codingdojo.dojosNinjas.services.DojoService;
import com.codingdojo.dojosNinjas.services.NinjaService;



@Controller
public class HomeController {

	@Autowired
	
	NinjaService ninjaServ;
	
	DojoService dojoServ;


	 public HomeController(DojoService dojoServ) { 
		 
		 this.dojoServ = dojoServ;
		 
	 }
	 
	
	 
	@RequestMapping("/")
	
	public String index(Model model) {

		List<Ninja> allNinjas = ninjaServ.allNinjas();
		
		List<Dojo> allDojo = dojoServ.allDojo();

		
		model.addAttribute("ninjas", allNinjas);
		
		model.addAttribute("dojos", allDojo);

		return "index.jsp";
		
	}

	
	
	@RequestMapping("/newNinjas")
	
	public String newNinjas(@ModelAttribute("ninj") Ninja ninja, Model model) {
		
		List<Dojo> allDojo = dojoServ.allDojo();
		
		model.addAttribute("dojos", allDojo);
		
		return "newNinjas.jsp";
		
	}

	
	
	@RequestMapping("/newDojo")
	
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		
		return "newDojo.jsp";
		
	}

	
	
	@RequestMapping(value = "/createNinj", method = RequestMethod.POST)
	
	public String create(@Valid @ModelAttribute("Ninj") Ninja ninja, BindingResult result) {
		
		if (result.hasErrors()) {
			
			return "newNinja.jsp";
			
		}
		
		ninjaServ.create(ninja);
		
		return "redirect:/";
	}
	

		
	@RequestMapping(value = "/createDojo", method = RequestMethod.POST)
	
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		
		if (result.hasErrors()) {
			
			return "newDojo.jsp";
			
		}
		
		dojoServ.create(dojo);
		
		return "redirect:/";
		
	}

	
	
	@RequestMapping("/editNinja/{id}")
	
	public String editNinja(@PathVariable("id") Long id, Model model) {
		
		Ninja ninj = ninjaServ.oneNinja(id);
		
		model.addAttribute("ninj", ninj);
		
		List<Dojo> allDojo = dojoServ.allDojo();
		
		model.addAttribute("dojos", allDojo);
		
		return "editNinja.jsp";
		
	}

	

	@RequestMapping(value = "/editNinja/{id}", method = RequestMethod.PUT)
	
	public String editingNinja(@Valid @ModelAttribute("ninj") Ninja ninja, BindingResult result) {
		
		if (result.hasErrors()) {
			
			return "editNinja.jsp";
			
		} 
		
		else {
			
			ninjaServ.updateNinj(ninja);
			
			return "redirect:/";
			
		}
		
	}

	
	
	@RequestMapping("/oneNinja/{id}")
	
	public String oneNinja(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("ninj", ninjaServ.oneNinja(id));
		
		return "oneNinja.jsp";
		
	}
	
	
	
	@RequestMapping("oneDojo/{id}")
	
	public String oneDojo(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("dojo", dojoServ.oneDojo(id));
		
		return "oneDojo.jsp";
		
	}

	
	@RequestMapping("/destroy/{id}")
	
	public String destroy(@PathVariable("id") Long id) {
		
		ninjaServ.destroy(id);
		
		return "redirect:/";
		
	}

}
