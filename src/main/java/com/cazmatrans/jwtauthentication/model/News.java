package com.cazmatrans.jwtauthentication.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDate datum;
    @NotBlank
    private String title;

    private boolean isActive;
    @NotBlank
    private String context;
    @NotBlank
    private String href;


    public News(Long id, LocalDate datum, String title, boolean isActive, String context, String href) {
        super();
        this.id = id;
        this.datum = datum;
        this.title = title;
        this.isActive = isActive;
        this.context = context;
        this.href = href;
    }

    public News(){
        super();
    }

    @PrePersist
    public void onPrePersist() {
        this.datum = datum.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}