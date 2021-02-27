package com.adnane.web;

import java.util.Date;

public class ConfTheme {
    private String adresse;
    private String title;
    private String description;
    private Date endDate;
    private Date startDate;
    private Date paperSubmissionlimitDate;
    private int nbrPlaces;
    private Long idTheme;

    public ConfTheme(String adresse, String title, String description,
                     Date endDate, Date startDate,
                     Date paperSubmissionlimitDate, int nbrPlaces, Long theme) {
        this.adresse = adresse;
        this.title = title;
        this.description = description;
        this.endDate = endDate;
        this.startDate = startDate;
        this.paperSubmissionlimitDate = paperSubmissionlimitDate;
        this.nbrPlaces = nbrPlaces;
        this.idTheme = theme;
    }

    public ConfTheme() {
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getPaperSubmissionlimitDate() {
        return paperSubmissionlimitDate;
    }

    public void setPaperSubmissionlimitDate(Date paperSubmissionlimitDate) {
        this.paperSubmissionlimitDate = paperSubmissionlimitDate;
    }

    public int getNbrPlaces() {
        return nbrPlaces;
    }

    public void setNbrPlaces(int nbrPlaces) {
        this.nbrPlaces = nbrPlaces;
    }

    public Long getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(Long theme) {
        this.idTheme = theme;
    }
}


