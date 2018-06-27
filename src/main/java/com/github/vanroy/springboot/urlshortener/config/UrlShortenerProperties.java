package com.github.vanroy.springboot.urlshortener.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Julien Roy
 */
@Configuration
@ConfigurationProperties(prefix = "app")
public class UrlShortenerProperties {

    private String backgroundColor = "#00a5ba";

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
