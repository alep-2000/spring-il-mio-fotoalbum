package org.lessons.java.db.service;

import java.util.List;

import org.lessons.java.db.pojo.Categoria;
import org.lessons.java.db.repo.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
	
	public Categoria findById(int id) {
		return categoriaRepository.findById(id).get();
	}
	
	public void save(Categoria categoria) {
		categoriaRepository.save(categoria);
	}
	
	public void delete(Categoria categoria) {
		categoriaRepository.delete(categoria);
	}
	
	public void deleteById(int id) {
		categoriaRepository.deleteById(id);
	}
}
