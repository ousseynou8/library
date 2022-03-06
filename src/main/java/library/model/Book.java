package library.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Book implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false, length = 12)
	private String titre;
	@Column(nullable = false, length = 500)
	private String description;
	@Column(nullable = false, length = 500)
	private String resume;
	@Column(nullable = false, length = 12)
	private String quantite;
	public Book() {
		super();
	}
	public Book(int id, String titre, String description, String resume, String quantite) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.resume = resume;
		this.quantite = quantite;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getQuantite() {
		return quantite;
	}
	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", titre=" + titre + ", description=" + description + ", resume=" + resume
				+ ", quantite=" + quantite + "]";
	}
	
	
	 
}
