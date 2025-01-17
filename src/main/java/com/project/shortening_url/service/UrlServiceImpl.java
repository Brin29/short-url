package com.project.shortening_url.service;

import com.opsmatters.bitly.Bitly;
import com.opsmatters.bitly.api.model.v4.CreateBitlinkResponse;
import com.project.shortening_url.repository.UrlRepository;
import jakarta.annotation.PostConstruct;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

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

    public String getShortUrl(String longUrl) throws IOException {

        CreateBitlinkResponse response = client.bitlinks().shorten(longUrl).get();
        String link = response.getLink();
        
        return link;
    }
}
