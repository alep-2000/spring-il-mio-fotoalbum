package org.lessons.java.controller;

import java.util.List;

import org.lessons.java.db.pojo.Categoria;
import org.lessons.java.db.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@GetMapping("/fotos/categorie{id}")
	public String getCategoria(Model model,
			@PathVariable int id) {
		
		Categoria categoria = categoriaService.findById(id);
		model.addAttribute("categoria", categoria);
		
		return "categorie";
	}
	
	@GetMapping("/fotos/categorie/create")
	public String createCategorie(Model model) {
		
		Categoria categoria = new Categoria();
		
		model.addAttribute("categoria", categoria);
		
		return "categoria-form";
	}
	
	@PostMapping("/fotos/categorie/create")
	public String storeCategoria(
			Model model,
			@Valid @ModelAttribute Categoria categoria, 
			BindingResult bindingResult) {
			
		
		return saveCategoria(model, categoria, bindingResult);
	}
	
	@PostMapping("/fotos/categorie/delete/{id}")
	public String deleteCategoria(@PathVariable int id) {
		
		Categoria categoria = categoriaService.findById(id);
		categoriaService.delete(categoria);
		
		return "redirect:/";
	}
	
	private String saveCategoria(Model model,
			@Valid @ModelAttribute Categoria categoria,
			BindingResult bindingResult) {
		
		System.out.println("Categoria:\n" + categoria);
		System.out.println("\n---------------\n");
		System.out.println("Error:\n" + bindingResult);
		
		if (bindingResult.hasErrors()) {
			
		model.addAttribute("categoria", categoria);
			return "categoria-form";
	}
		
		categoriaService.save(categoria);
	
		return "redirect:/";
	}
}
