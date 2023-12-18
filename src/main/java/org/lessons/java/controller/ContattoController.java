package org.lessons.java.controller;

import java.util.List;

import org.lessons.java.db.pojo.Contatto;
import org.lessons.java.db.service.ContattoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContattoController {

	@Autowired
	ContattoService contattoService;
	
	
	
	@GetMapping("/contatti")
	public String getContatti(Model model) {
		List<Contatto> contatti = contattoService.findAll();	
		model.addAttribute("contatti", contatti);
		
		return "/contatti";
	}
	
	@PostMapping("/back-home")
	public String updateConatti(Model model) {
	    List<Contatto> contatti = contattoService.findAll();
	    
	    for (Contatto contatto : contatti) {
	       
	        contattoService.save(contatto);
	    }

	    
	    return "redirect:/";
	}
}