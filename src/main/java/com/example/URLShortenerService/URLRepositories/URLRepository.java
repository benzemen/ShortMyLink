package com.example.URLShortenerService.URLRepositories;

import com.example.URLShortenerService.URLEntity.UrlMapping;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface URLRepository extends MongoRepository<UrlMapping, String> {
    Optional<UrlMapping> findByshortcode(String shortcode);
    Optional<UrlMapping> findByOrigurl(String url);
    Boolean existsByshortcode(String shortcode);

}
