package com.project.shortening_url.service;

import com.opsmatters.bitly.Bitly;
import com.opsmatters.bitly.api.model.v4.CreateBitlinkResponse;
import com.project.shortening_url.entities.Url;
import com.project.shortening_url.repository.UrlRepository;
import jakarta.annotation.PostConstruct;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UrlServiceImpl implements IUrlService{

    @Value("${BITLY_TOKEN}")
    String BITLY_TOKEN;

    private Bitly client;

    @Autowired
    private UrlRepository repository;

    @PostConstruct
    public void setup(){
        client = new Bitly(BITLY_TOKEN);
    }

    @Cacheable(value = "url", key = "#id")
    public Optional<Url> getUrlId(Long id){
        return repository.findById(id);
    }

    @CachePut(value = "url", key = "#url.id")
    public Url saveUrl(Url url) throws IOException {
        String shortUrl = getShortUrl(url.getLongUrl());
        url.setShortUrl(shortUrl);
        return repository.save(url);
    }

    @CacheEvict(value = "url", key = "#id")
    public void deleteUrl(Long id){
        repository.deleteById(id);
    }

    public List<Url> getAllUrls(){
        return repository.findAll();
    }


    private String getShortUrl(String longUrl) throws IOException {
        CreateBitlinkResponse response = client.bitlinks().shorten(longUrl).get();
        String link = response.getLink();
        return link;
    }
}
