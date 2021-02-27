package com.adnane.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Auteur implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAuteur;
    @OneToOne
    private AppUser user;
	public Auteur(AppUser user) {

		this.user = user;
	}
    
    
}
