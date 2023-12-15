package org.lessons.java.db.service;

import java.util.List;

import org.lessons.java.db.pojo.Foto;
import org.lessons.java.db.repo.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FotoService {

	@Autowired
	private FotoRepository fotoRepository;
	
	public List<Foto> findAll(){
		return fotoRepository.findAll();
	}
	
	public Foto findById(int id) {
		return fotoRepository.findById(id).get();
	}
	
	public List<Foto> findByTitolo(String query){
		return fotoRepository.findByTitoloContainingIgnoreCase(query);
	}
	
	public void save(Foto foto) {
		fotoRepository.save(foto);
	}
	
	public void delete(Foto foto) {
		fotoRepository.delete(foto);
	}
	
	public void deleteById(int id) {
		fotoRepository.deleteById(id);
	}
}
