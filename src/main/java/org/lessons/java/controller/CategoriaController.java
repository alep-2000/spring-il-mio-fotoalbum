package org.lessons.java.controller;

import java.util.List;

import org.lessons.java.db.pojo.Categoria;
import org.lessons.java.db.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;


@Controller
public class CategoriaController {
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("fotos/categorie")
	public String getCategorie(Model model) {
		
		List<Categoria> index = categoriaService.findAll();
		
		model.addAttribute("categorie" ,index);
		return "categorie";
	}
	
	private String saveCategoria(Model model,
			@Valid @ModelAttribute Categoria categoria) {
		
		System.out.println("Ingrediente:\n" + categoria);
		System.out.println("\n---------------\n");
//		System.out.println("Error:\n" + bindingResult);
		
//		if (bindingResult.hasErrors()) {
//			
//			model.addAttribute("ingrediente", ingrediente);
//			return "ingrediente-form";
//		}
		
		categoriaService.save(categoria);
	
		return "redirect:/";
	}
}
