package com.project.shortening_url.repository;

import com.project.shortening_url.entities.Url;

import java.util.Map;

public interface RedisRepository {
    Map<Long, Url> findAll();
    Url findById(Long id);
    void save(Url url);
    void delete(Long id);
    String getUrlByLongUrl(String longUrl);
}
