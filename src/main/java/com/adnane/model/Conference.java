package com.adnane.model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import java.util.Set;
import javax.persistence.*;

@Entity
public class Conference implements Serializable{
   
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    
    private String description;
    
    private String adresse;
    
    private int nbrPlaces;
    
    @OneToOne
    private Theme theme;

    @OneToOne
    private Audience audience;
    @Temporal(TemporalType.DATE)
    private Date creationDate=new Date();

    private File photo;
    
    @ManyToMany
    @JoinTable(name = "conference_comitte",
            joinColumns = {@JoinColumn(name="idConference")},
            inverseJoinColumns = {@JoinColumn(name="idUser")})
    private List<AppUser> committe = new ArrayList<AppUser>();
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Temporal(TemporalType.DATE)
    private Date paperSubmissionlimitDate;

    @OneToMany(mappedBy = "conference")
    private List<Session> sessions = new ArrayList<Session>();

    public Conference(String title, String adresse, String description, int nbrPlaces, Theme theme, Audience audienceLevel, Date creationDate, AppUser creator, List<AppUser> committe, Date startDate, Date endDate, Date paperSubmissionlimitDate, List<Session> sessions) {
        this.title = title;
        this.description = description;
        this.adresse = adresse;
        this.setNbrPlaces(nbrPlaces);
        this.theme = theme;
        this.creationDate = creationDate;
        this.committe = committe;
        this.startDate = startDate;
        this.endDate = endDate;
        this.paperSubmissionlimitDate = paperSubmissionlimitDate;
        this.sessions = sessions;
    }

    public Conference(String title, String adresse, String description,Date startDate, Date endDate, Date paperSubmissionlimitDate, int nbrPlaces, Theme theme,Audience audience) {
        this.title = title;
        this.description = description;
        this.adresse = adresse;
        this.setNbrPlaces(nbrPlaces);
        this.theme = theme;
        this.audience=audience;
        //this.creationDate = new Date();
        this.startDate = startDate;
        this.endDate = endDate;
        this.paperSubmissionlimitDate = paperSubmissionlimitDate;
    }

    public Conference() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public Audience getAudience() {
        return audience;
    }

    public void setAudience(Audience audience) {
        this.audience = audience;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }


    public List<AppUser> getCommitte() {
        return committe;
    }

    public void setCommitte(List<AppUser> committe) {
        this.committe = committe;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getPaperSubmissionlimitDate() {
        return paperSubmissionlimitDate;
    }

    public void setPaperSubmissionlimitDate(Date paperSubmissionlimitDate) {
        this.paperSubmissionlimitDate = paperSubmissionlimitDate;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;   
    }

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getNbrPlaces() {
		return nbrPlaces;
	}

	public void setNbrPlaces(int nbrPlaces) {
		this.nbrPlaces = nbrPlaces;
	}
    @Transient
	private Long idTheme;

    public Long getIdTheme() {
        return idTheme;
    }
    @Transient
    private Long idAudience;

    public Long getIdAudience() {
        return idAudience;
    }

    @Transient
    private List<String> list;

    public List<String> getList() {
        return list;
    }

    /*@Transient
    private Conference conference;

    public Conference getConference() {
        return conference;
    }*/
}
