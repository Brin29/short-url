package com.project.shortening_url.repository;

import com.project.shortening_url.entities.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

    String getUrlByLongUrl(String longUrl);
}
