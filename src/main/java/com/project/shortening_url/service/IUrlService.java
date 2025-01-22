package com.project.shortening_url.service;

import com.project.shortening_url.entities.Url;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IUrlService {

    Optional<Url> getUrlId(Long id);

    Url saveUrl(Url url) throws IOException;

    void deleteUrl(Long id);

    List<Url> getAllUrls();

}
