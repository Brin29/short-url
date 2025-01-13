package com.project.shortening_url.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
public class Url {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String shortLink;

    @Column(nullable = false)
    private String longUrl;

    private LocalDateTime creationDate;

    private LocalDateTime expirationDate;

    public Url() {
    }

    public Url(long id, String shortLink, String longUrl, LocalDateTime creationDate, LocalDateTime expirationDate) {
        this.id = id;
        this.shortLink = shortLink;
        this.longUrl = longUrl;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
    }

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }
}
