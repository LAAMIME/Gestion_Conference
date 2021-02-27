package com.adnane.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
public class Article implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArticle;
    private String description;
    private String Contenu;
    private Date DateDoumission;
    private boolean Etat;
    @OneToOne
    private Conference conference;
    @OneToOne
    private Auteur auteur;
//    @ManyToOne
//    private ComiteProgramme comiteProgramme;
    
    
	public Article(String description, String contenu, Date dateDoumission, boolean etat,
			Conference conference, Auteur auteur) {

		this.description = description;
		Contenu = contenu;
		DateDoumission = dateDoumission;
		Etat = etat;
		this.conference = conference;
		this.auteur = auteur;
	}


	public Long getIdArticle() {
		return idArticle;
	}


	public void setIdArticle(Long idArticle) {
		this.idArticle = idArticle;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getContenu() {
		return Contenu;
	}


	public void setContenu(String contenu) {
		Contenu = contenu;
	}


	public Date getDateDoumission() {
		return DateDoumission;
	}


	public void setDateDoumission(Date dateDoumission) {
		DateDoumission = dateDoumission;
	}


	public boolean isEtat() {
		return Etat;
	}


	public void setEtat(boolean etat) {
		Etat = etat;
	}


	public Conference getConference() {
		return conference;
	}


	public void setConference(Conference conference) {
		this.conference = conference;
	}


	public Auteur getAuteur() {
		return auteur;
	}


	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}
    
    
}
