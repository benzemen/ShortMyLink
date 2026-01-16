package com.example.URLShortenerService.URLEntity;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;


@Document(collection = "urls")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UrlMapping {

    @Id
    private String Id;

    @Indexed(unique = true)
    private String shortcode;
    private String origurl;
    @CreatedBy
    private LocalDateTime  created_at;
    private LocalDateTime expires_at;



}
