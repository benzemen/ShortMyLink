package com.example.URLShortenerService.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShortenUrlRequest {
    @NotBlank(message = "URL cannot be empty")
    @Pattern(
            regexp = "^(http|https)://.*$",
            message = "URL must start with http or https"
    )
    private String url;

}
