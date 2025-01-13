package com.project.shortening_url.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UrlRequest {

    @Id
    @GeneratedValue
    private long id;

    private String longUrl;

    public UrlRequest(){
    }

    public UrlRequest(String longUrl){
        this.longUrl = longUrl;
    }


    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }
}