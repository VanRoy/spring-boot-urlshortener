package com.ekino.handson.springboot.urlshortener.model;

import java.util.Date;
import java.util.UUID;

import org.springframework.util.DigestUtils;

/**
 * @author: Julien Roy
 * @version: $Id$
 */
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortUri() {
        return shortUri;
    }

    public void setShortUri(String shortUri) {
        this.shortUri = shortUri;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    private String encore(String s) {
        return  DigestUtils.md5DigestAsHex(s.getBytes()).substring(0, 8);
    }
}
