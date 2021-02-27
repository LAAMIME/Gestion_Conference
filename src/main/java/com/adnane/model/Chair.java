package com.adnane.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Chair implements Serializable {
	
  
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChair;
    @OneToOne
    private AppUser user;
    @OneToOne
    private Conference conference;


    public Chair(AppUser user, Conference conf) {
        this.user=user;
        conference=conf;
    }
    public Chair() {

    }

    public Long getIdChair() {
        return idChair;
    }

    public void setIdChair(Long idChair) {
        this.idChair = idChair;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    @Override
    public String toString() {
        return "Chair{" +
                "idChair=" + idChair +
                ", user=" + user +
                ", conference=" + conference +
                '}';
    }
}
