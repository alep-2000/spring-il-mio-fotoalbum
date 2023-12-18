package org.lessons.java.db.repo;

import java.util.List;

import org.lessons.java.db.pojo.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Integer>{
	List<Foto> findByTitoloContainingIgnoreCase(String titolo);
	
	List<Foto> findByVisibileTrue();
}


