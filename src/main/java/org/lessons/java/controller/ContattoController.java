package org.lessons.java.controller;

import java.util.List;

import org.lessons.java.db.pojo.Contatto;
import org.lessons.java.db.service.ContattoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/contatti/{id}")
	public String getContatti(Model model,
			@PathVariable int id) {
		
		Contatto contatto = contattoService.findById(id);
		model.addAttribute("contatto", contatto);
		
		return "contatto";
	}
	
	@PostMapping("/contatti/delete/{id}")
	public String deleteContatto(@PathVariable int id) {
		
		Contatto contatto = contattoService.findById(id);
		contattoService.delete(contatto);
		
		return "redirect:/";
	}
}