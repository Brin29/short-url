package com.project.shortening_url.entities;

import java.io.Serializable;

public class Url implements Serializable {

    private long id;

    private String longUrl;

    private String shortUrl;

    public Url(){
    }

    public Url(String longUrl, String shortUrl){
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }
}