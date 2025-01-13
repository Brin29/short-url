package com.project.shortening_url.dto;

public class UrlErrorResponseDto {

    private String status;

    private String error;

    public UrlErrorResponseDto() {
    }

    public UrlErrorResponseDto(String status, String error) {
        this.status = status;
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setError(String error) {
        this.error = error;
    }
}
