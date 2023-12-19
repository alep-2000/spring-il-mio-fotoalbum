package org.lessons.java.db.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;

@Entity
public class Contatto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    
    @Email
    private String email;
    
    @Column(columnDefinition = "TEXT")
    private String messaggio;
    
    public Contatto() {}
    public Contatto(String nome, String email, String messaggio) {
    	setNome(nome);
    	setEmail(email);
    	setMessaggio(messaggio);
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessaggio() {
		return messaggio;
	}
	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}
    
    @Override
    public String toString() {
		return "[" + getId() + "] " + getNome();
	}
   }
