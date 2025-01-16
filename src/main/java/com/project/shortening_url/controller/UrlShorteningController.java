package com.project.shortening_url.controller;

import com.project.shortening_url.entities.Url;
import com.project.shortening_url.service.UrlServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UrlShorteningController {

    @Autowired
    private UrlServiceImpl urlService;

    @PostMapping("/generate")
    public String generateShortLink(@RequestBody Url url) throws IOException {
        return urlService.getShortUrl(url.getLongUrl());
    }


}
