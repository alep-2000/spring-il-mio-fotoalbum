package org.lessons.java.controller;



import java.util.List;

import org.lessons.java.db.pojo.Foto;
import org.lessons.java.db.service.CategoriaService;
import org.lessons.java.db.service.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	private String saveFoto(Model model,
			@Valid @ModelAttribute Foto foto) {
		
		System.out.println("Pizza:\n" + foto);
		System.out.println("\n---------------\n");
//		System.out.println("Error:\n" + bindingResult);
		
//		if (bindingResult.hasErrors()) {
//			
//			model.addAttribute("pizza", pizza);
//			return "pizza-form";
//		}
		
		fotoService.save(foto);
	
		return "redirect:/";
	}
}
