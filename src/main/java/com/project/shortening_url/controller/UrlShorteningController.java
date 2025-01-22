package com.project.shortening_url.controller;


import com.project.shortening_url.entities.Url;
import com.project.shortening_url.service.UrlServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/url")
public class UrlShorteningController {

    @Autowired
    private UrlServiceImpl service;


    @GetMapping("/{id}")
    public ResponseEntity<Url> getUrlById(@PathVariable Long id){
        Optional<Url> url = service.getUrlId(id);
        return url.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Url> getAllUrls(){
        return service.getAllUrls();
    }

    @PostMapping
    public Url createUrl(@RequestBody Url url) throws IOException {
        return service.saveUrl(url);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Url> updateUrl(@PathVariable Long id, @RequestBody Url url) throws IOException{
        Optional<Url> existingUrl = service.getUrlId(id);

        if (existingUrl.isPresent()){
            url.setId(id);
            return ResponseEntity.ok(service.saveUrl(url));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUrl(@PathVariable Long id){
        Optional<Url> url = service.getUrlId(id);
        if (url.isPresent()){
            service.deleteUrl(id);
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    /*
    @GetMapping("/{id}")
    public ResponseEntity<String> getProductById(@PathVariable long id){
        repository.findById(id);
        return ResponseEntity.ok("Usuario");
    }

     */



    /*
    @PostMapping("/generate")
    public String generateShortLink(@RequestBody Url url) throws IOException {
        return urlService.getShortUrl(url.getLongUrl());
    }
    */





}
