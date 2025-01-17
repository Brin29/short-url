package com.project.shortening_url.controller;

import com.project.shortening_url.entities.Url;
import com.project.shortening_url.repository.UrlRepository;
import com.project.shortening_url.service.UrlServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UrlShorteningController {

    @Autowired
    private UrlServiceImpl urlService;

    @Autowired
    private UrlRepository repository;

    /*
    @PostMapping("/generate")
    public String generateShortLink(@RequestBody Url url) throws IOException {
        return urlService.getShortUrl(url.getLongUrl());
    }
    */

    @GetMapping("/url")
    public Map<Long, Url> findAll() {
        return repository.findAll();
    }

    @GetMapping("/url/{id}")
    public Url findById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping("/url")
    public void createStudent(@RequestBody Url url) {
        repository.save(url);
    }

    @DeleteMapping("/url/{id}")
    public void deleteStudent(@PathVariable Long id) {
        repository.delete(id);
    }




}
