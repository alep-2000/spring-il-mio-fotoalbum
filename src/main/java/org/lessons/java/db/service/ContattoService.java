package org.lessons.java.db.service;

import java.util.List;

import org.lessons.java.db.pojo.Contatto;
import org.lessons.java.db.repo.ContattoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContattoService {

	
	@Autowired
	private ContattoRepository contattoRepository;
	
	public List<Contatto> findAll() {
		
		return contattoRepository.findAll();
	}
	
	public Contatto findById(int id) {
		
		return contattoRepository.findById(id).get();
	}
	
	public void save(Contatto contatto) {
		
		contattoRepository.save(contatto);
	}
	
	public void delete(Contatto contatto) {
		
		contattoRepository.delete(contatto);
	}
}
