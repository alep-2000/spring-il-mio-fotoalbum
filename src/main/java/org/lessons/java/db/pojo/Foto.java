package org.lessons.java.db.pojo;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Foto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 60)
	private String titolo;
	
	@Column(columnDefinition = "TEXT")
	private String descrizione;
	
	@URL(protocol = "https")
	private String url;
	
	private boolean visibile;
	
	private String categorie;
	
	public Foto() {}
	public Foto(String titolo, String descrizione, String url, boolean visibile, String categorie) {
		setTitolo(titolo);
		setDescrizione(descrizione);
		setUrl(url);
		setVisibile(visibile);
		setCategorie(categorie);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isVisibile() {
		return visibile;
	}
	public void setVisibile(boolean visibile) {
		this.visibile = visibile;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	@Override
	public String toString() {
		return "[" + getId() + "] " + getTitolo() + " - " 
				+ getDescrizione() + " - " + getUrl() + " - "
				+ isVisibile() + " - " + getCategorie();
	}
}
