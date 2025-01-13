package com.project.shortening_url.service;

import com.project.shortening_url.dto.UrlDto;
import com.project.shortening_url.entities.Url;

public interface IUrlService {

    public Url generateShortLink(UrlDto urlDto);

    public Url persistShortLink(Url url);

    public Url getEncodedUrl(String url);

    public void deleteShortLink(Url url);

}
