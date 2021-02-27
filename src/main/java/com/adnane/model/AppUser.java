package com.adnane.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="AppUsers")
public class AppUser implements Serializable{
    
   
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
        
    private String firstName;
    
    private String lastName;
   // @Column(unique = true)
    private String username;
     
    private String email;
    
    private boolean estProf;
    
    private String photo;
    
    private String universite;
    
    private Long telephone;
    
    @OneToOne
    private Theme themePréferer;
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "AppUser_roles",
            joinColumns = {@JoinColumn(name="id_AppUser")},
            inverseJoinColumns = {@JoinColumn(name="id_role")})
    private List<AppRole> roles = new ArrayList<AppRole>();

    
    public AppUser(String firstName, String lastName, String username, String email, boolean estProf,
			String photo, String universite, Long telephone, String password) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.setEstProf(estProf);
		this.photo = photo;
		this.setUniversite(universite);
		this.setTelephone(telephone);
		this.password = password;
	}

	public AppUser(String firstName, String lastName, String username, String email, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
    
    public AppUser(String firstName, String lastName, String username, String email, String password,
			List<AppRole> roles) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}
    
    public AppUser(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public AppUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<AppRole> getRoles() {
		return roles;
	}

	public void setRoles(List<AppRole> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "AppUser [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", email=" + email + ", password=" + password + ", roles=" + roles + "]";
	}

	public boolean isEstProf() {
		return estProf;
	}

	public void setEstProf(boolean estProf) {
		this.estProf = estProf;
	}

	public String getUniversite() {
		return universite;
	}

	public void setUniversite(String universite) {
		this.universite = universite;
	}

	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}
        
    
    
}
