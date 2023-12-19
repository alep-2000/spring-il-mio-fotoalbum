package org.lessons.java.restController;


import org.lessons.java.db.pojo.Contatto;
import org.lessons.java.db.service.ContattoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/contatti")
public class ContattoRestController {

	@Autowired
	private ContattoService contattoService;

	@PostMapping
	public ResponseEntity<String> create(@RequestBody Contatto contatto){
		contattoService.save(contatto);
		return new ResponseEntity<>("Messaggio inviato con successo", HttpStatus.OK);
	}
}
