package com.github.vanroy.springboot.urlshortener.model;

import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.DigestUtils;

/**
 * @author Julien Roy
 */
@Getter
@Setter
public class ShortLink {

    private String id;
    private String originalUrl;
    private String shortUri;
    private Date creationDate;

    public ShortLink(String originalUrl) {
        this.id = UUID.randomUUID().toString();
        this.originalUrl = originalUrl;
        this.shortUri = encore(originalUrl);
        this.creationDate = new Date();
    }

    private String encore(String s) {
        return  DigestUtils.md5DigestAsHex(s.getBytes()).substring(0, 8);
    }
}
