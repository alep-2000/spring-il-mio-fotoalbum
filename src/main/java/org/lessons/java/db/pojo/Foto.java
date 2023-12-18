package org.lessons.java.db.pojo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Foto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 60)
	@Length(min=3, max=60, message = "Il titolo deve essere compreso tra 3 e 60 caratteri")
	@NotBlank(message = "Il titolo non può essere nullo")
	private String titolo;
	
	@Column(columnDefinition = "TEXT")
	@Length(min = 3, message = "La descrizione non può essere nulla")
	private String descrizione;
	
	@URL(protocol = "https")
	@NotBlank(message = "Url non può essere nullo")
	private String url;
	
	@Column(nullable=false)
	private boolean visibile;
	
	@ManyToMany
	private List<Categoria> categorie;
	
	public Foto() {}
	public Foto(String titolo, String descrizione, String url, boolean visibile, Categoria...categorie) {
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
	
	public List<Categoria> getCategorie() {
		return categorie;
	}
	public void setCategorie(List<Categoria> categorie) {
		this.categorie = categorie;
	}
	
	public void setCategorie(Categoria... categorie) {
		setCategorie(Arrays.asList(categorie));
	}
	@Override
	public String toString() {
		return "[" + getId() + "] " + getTitolo() + " - " 
				+ getDescrizione() + " - " + getUrl() + " - "
				+ isVisibile();
	}
}
