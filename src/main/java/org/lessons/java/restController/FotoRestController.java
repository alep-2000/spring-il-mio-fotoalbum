package org.lessons.java.restController;

import java.util.List;

import org.lessons.java.db.pojo.Foto;
import org.lessons.java.db.service.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/f1.0/fotos")
public class FotoRestController {

	@Autowired
	private FotoService fotoService;
	
	@GetMapping
	public ResponseEntity<List<Foto>> getIndex(){
		
		List<Foto> fotos = fotoService.findByVisibileTrue();
		
		return new ResponseEntity<>(fotos, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Foto> getFoto(@PathVariable int id) {
		
		Foto foto = fotoService.findById(id);
		
		if (foto == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(foto, HttpStatus.OK);
	}
}
