package org.lessons.java.controller;



import java.util.List;

import org.lessons.java.db.pojo.Categoria;
import org.lessons.java.db.pojo.Foto;
import org.lessons.java.db.service.CategoriaService;
import org.lessons.java.db.service.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class FotoController {

	@Autowired 
	private FotoService fotoService;
	
	@Autowired 
	private CategoriaService categoriaService;
	
	@GetMapping
	public String getFotos(Model model, 
						@RequestParam(required = false) String f) {
		List<Foto> fotos = f == null
					? fotoService.findAll()
					: fotoService.findByTitolo(f);
		model.addAttribute("fotos", fotos);
		model.addAttribute("f", f == null ? "" : f);
		
		return "fotos";
	}
	
	@GetMapping("/fotos/{id}")
	public String getFoto(Model model,
			@PathVariable int id) {
		
		Foto foto = fotoService.findById(id);
		model.addAttribute("foto", foto);
		
		return "foto";
	}
	
	@GetMapping("/fotos/create")
	public String createFoto(Model model) {
		
		Foto foto = new Foto();
		
		List<Categoria> categorie = categoriaService.findAll();
		model.addAttribute("foto", foto);
		model.addAttribute("categorie", categorie);
		
		return "foto-form";
	}
	
	@PostMapping("/fotos/create")
	public String storeFoto(
			Model model,
			@Valid @ModelAttribute Foto foto, 
			BindingResult bindingResult) {
			
		return saveFoto(model, foto, bindingResult);
	}
	
	@GetMapping("/fotos/edit/{id}")
	public String editFoto(Model model,
			@PathVariable int id) {
		
		List<Categoria> categorie = categoriaService.findAll();
		Foto foto = fotoService.findById(id);
		model.addAttribute("foto", foto);
		model.addAttribute("categorie", categorie);
		
		return "foto-form";
	}
	@PostMapping("/fotos/edit/{id}")
	public String updateFoto(Model model,
			@Valid @ModelAttribute Foto foto, 
			BindingResult bindingResult) {
		
		return saveFoto(model, foto, bindingResult);
	}
	
	private String saveFoto(Model model,
			@Valid @ModelAttribute Foto foto,
			BindingResult bindingResult) {
		
		System.out.println("Pizza:\n" + foto);
		System.out.println("\n---------------\n");
		System.out.println("Error:\n" + bindingResult);
		
		if (bindingResult.hasErrors()) {
			
			model.addAttribute("foto", foto);
			return "foto-form";
		}
		
		fotoService.save(foto);
	
		return "redirect:/";
	}
}
