package com.example.URLShortenerService.Controller;


import com.example.URLShortenerService.DTOs.ShortenUrlRequest;
import com.example.URLShortenerService.DTOs.ShortenUrlResponse;
import com.example.URLShortenerService.URLService.URLService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class URLController {

    private final URLService  urlService;
    @PostMapping("/getUrl/shorten")
    public ResponseEntity<ShortenUrlResponse> shortenUrl(@Valid @RequestBody ShortenUrlRequest  shortenUrlRequest){
        String shortUrl=urlService.shortenurl(shortenUrlRequest.getUrl());
        return ResponseEntity.ok(new ShortenUrlResponse(shortUrl));
    }
    @GetMapping("/r/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode){
        String originalUrl=urlService.getOriginalUrl(shortCode);
        HttpHeaders  headers=new HttpHeaders();
        headers.setLocation(URI.create(originalUrl));
        return new ResponseEntity<>(headers,HttpStatus.FOUND);
    }



}
