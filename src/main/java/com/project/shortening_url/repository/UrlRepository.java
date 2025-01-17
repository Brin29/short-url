package com.project.shortening_url.repository;

import com.project.shortening_url.entities.Url;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;

@Repository
public class UrlRepository implements RedisRepository {

    @Autowired
    private RedisTemplate<Long, Url> redisTemplate;

    // Ejecuta las operaciones por medio de la base de datos
    private HashOperations hashOperations;

    private static final String KEY = "url";

    public UrlRepository(RedisTemplate<Long, Url> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<Long, Url> findAll() {
        return hashOperations.entries(KEY);
    }

    @Override
    public Url findById(Long id) {
        return (Url) hashOperations.get(KEY, id);
    }

    @Override
    public void save(Url url) {
        hashOperations.put(KEY, UUID.randomUUID().toString(), url);
    }

    @Override
    public void delete(Long id) {
        hashOperations.delete(KEY, id);
    }

    @Override
    public String getUrlByLongUrl(String longUrl) {
        return "";
    }
}
