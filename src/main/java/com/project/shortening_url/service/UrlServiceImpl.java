package com.project.shortening_url.service;

import com.opsmatters.bitly.Bitly;
import com.opsmatters.bitly.api.model.v4.CreateBitlinkResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UrlServiceImpl implements IUrlService{

    @Value("${BITLY_TOKEN}")
    String BITLY_TOKEN;

    private Bitly client;

    @PostConstruct
    public void setup(){
        client = new Bitly(BITLY_TOKEN);
    }

    public String getShortUrl(String longUrl) throws IOException {
        String link = "error";

        CreateBitlinkResponse response = client.bitlinks().shorten(longUrl).get();
        link = response.getLink();

        return link;
    }

}
