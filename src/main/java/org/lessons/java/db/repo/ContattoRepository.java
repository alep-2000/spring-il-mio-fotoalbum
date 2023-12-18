package org.lessons.java.db.repo;

import org.lessons.java.db.pojo.Contatto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContattoRepository extends JpaRepository<Contatto, Integer>{

}
