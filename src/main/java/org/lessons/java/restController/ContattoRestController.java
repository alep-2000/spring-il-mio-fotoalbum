package org.lessons.java.restController;

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
public class ContattoRestController {

	@Autowired
	private ContattoService contattoService;
	
	@GetMapping("/api/contatti")
	public String getContatti(Model model) {
		
		List<Contatto> contatti = contattoService.findAll();
		
		model.addAttribute("contatti", contatti);
		
		return "contatti";
	}
	
	@GetMapping("/api/contatti/{id}")
	public String getContatto(Model model, @PathVariable int id) {
		
		Contatto contatto = contattoService.findById(id);
		
		model.addAttribute("contatto", contatto);
		
		return "contatto";
	}
	
	@PostMapping("/api/contatti/delete/{id}")
	public String deleteContatto(@PathVariable int id) {
		
		Contatto contatto = contattoService.findById(id);
		
		contattoService.delete(contatto);
		
		System.out.println(contatto);
		
		return "redirect:/contatti";
	}
}
