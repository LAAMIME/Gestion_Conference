package com.adnane.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Profil implements Serializable{
    
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String label;

    public Profil(String label) {
        this.label = label;
    }

    public Profil() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

	@Override
	public String toString() {
		return "Profil [id=" + id + ", label=" + label + "]";
	}
    
    
    
}
