package com.project.shortening_url.repository;

import com.project.shortening_url.entities.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, Long> {
}
