package com.project.shortening_url.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

public interface IUrlService {

    String getShortUrl(String longUrl) throws IOException;
}
