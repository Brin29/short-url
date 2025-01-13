package com.project.shortening_url.controller;

import com.project.shortening_url.entities.UrlRequest;
import com.project.shortening_url.service.UrlServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class UrlShorteningController {

    @Autowired
    private UrlServiceImpl urlService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateShortLink(@RequestBody UrlRequest urlRequest) throws IOException {

        String shortUrl = urlService.getShortUrl(urlRequest.getLongUrl());

        return ResponseEntity.ok(shortUrl);
    }
}
