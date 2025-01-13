package com.project.shortening_url.service;

import com.google.common.hash.Hashing;
import com.project.shortening_url.dto.UrlDto;
import com.project.shortening_url.entities.Url;
import com.project.shortening_url.repository.UrlRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Component
public class UrlServiceImpl implements IUrlService{

    @Autowired
    private UrlRepository repository;

    @Override
    public Url generateShortLink(UrlDto urlDto){

        if (StringUtils.isNotEmpty(urlDto.getUrl())){
            String encodedUrl = encodeUrl(urlDto.getUrl());
            Url urlToPersist =  new Url();
            urlToPersist.setCreationDate(LocalDateTime.now());
            urlToPersist.setLongUrl(urlDto.getUrl());
            urlToPersist.setShortLink(encodedUrl);
            urlToPersist.setExpirationDate(getExpirationDate(urlDto.getExpirationDate(), urlToPersist.getCreationDate()));
            Url urlToRet = persistShortLink(urlToPersist);

        if (urlToRet != null)
            return urlToRet;

        return null;
        }
        return null;

    }

    private LocalDateTime getExpirationDate(String expirationDate, LocalDateTime creationDate) {

        if(StringUtils.isBlank(expirationDate)){
            return creationDate.plusSeconds(60);
        }

        LocalDateTime expirationDateToRet = LocalDateTime.parse(expirationDate);
        return expirationDateToRet;

    }

    private String encodeUrl(String url){

        String encodedUrl = "";
        LocalDateTime time = LocalDateTime.now();
        encodedUrl = Hashing.murmur3_32_fixed()
                .hashString(url.concat(time.toString()), StandardCharsets.UTF_8)
                .toString();

        return encodedUrl;
    }

    @Override
    public Url persistShortLink(Url url){
        Url urlToRet = repository.save(url);
        return urlToRet;
    }

    @Override
    public Url getEncodedUrl(String url) {
        Url urlToRet = repository.findByShortLink(url);
        return urlToRet;
    }

    @Override
    public void deleteShortLink(Url url){
        repository.delete(url);
    }
}
