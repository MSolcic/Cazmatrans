package com.cazmatrans.jwtauthentication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "list")
public class List {
    @Id
    @GeneratedValue
    private Long id;

    private String image;

    private String newsHref;

    private boolean isActive;
    @NotEmpty(message = "Sadrzaj obavijesti je obavezan!")
    private String price;
    @NotBlank
    private String title;

    public List(Long id, String image, String newsHref, boolean isActive, String price, String title) {
        super();
        this.id = id;
        this.image = image;
        this.newsHref = newsHref;
        this.isActive = isActive;
        this.price = price;
        this.title = title;
    }

    public List(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNewsHref() {
        return newsHref;
    }

    public void setNewsHref(String newsHref) {
        this.newsHref = newsHref;
    }

    public boolean getActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
