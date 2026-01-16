package com.example.URLShortenerService.URLService;


import com.example.URLShortenerService.URLEntity.UrlMapping;
import com.example.URLShortenerService.URLRepositories.URLRepository;
import com.example.URLShortenerService.Utility.ShortCodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class URLService {

    private final URLRepository urlRepository;
    private static final String BASE_URL = "http://localhost:8080/r/";

    public String shortenurl(String originalUrl){
        return urlRepository.findByOrigurl(originalUrl)
                .map(UrlMapping ->BASE_URL+ UrlMapping.getShortcode())
                .orElseGet(()->createAndSaveShortUrl(originalUrl));
    }
    public String createAndSaveShortUrl(String originalUrl){
        String shortcode;
        do{
            shortcode= ShortCodeGenerator.generateShortCode();
        }while(urlRepository.existsByshortcode(shortcode));
        UrlMapping urlmap= UrlMapping.builder()
                .origurl(originalUrl)
                .shortcode(shortcode)
                .created_at(LocalDateTime.now())
                .build();
        urlRepository.save(urlmap);
        return BASE_URL+shortcode;

    }

    public String getOriginalUrl(String shortcode) {
        return urlRepository.findByshortcode(shortcode)
                .orElseThrow(()-> new RuntimeException("Url not found"))
                .getOrigurl();
    }
}
