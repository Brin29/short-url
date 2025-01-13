package com.project.shortening_url.dto;

import java.time.LocalDateTime;

public class UrlResponseDto {

    private String shortLink;
    private String longUrl;
    private LocalDateTime expirationDate;

    public UrlResponseDto() {
    }

    public UrlResponseDto(String shortLink, String longUrl, LocalDateTime expirationDate) {
        this.shortLink = shortLink;
        this.longUrl = longUrl;
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

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }
}
