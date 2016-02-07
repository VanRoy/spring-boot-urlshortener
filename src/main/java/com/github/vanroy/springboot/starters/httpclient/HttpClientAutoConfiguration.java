package com.github.vanroy.springboot.starters.httpclient;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Julien Roy
 */
@Configuration
@ConditionalOnMissingBean(HttpClient.class)
@ConditionalOnProperty(prefix = "spring.httpclient", name = "enabled", matchIfMissing = true)
@EnableConfigurationProperties(HttpClientProperties.class)
public class HttpClientAutoConfiguration {

    @Autowired
    private HttpClientProperties properties;

    @Bean
    public HttpClient httpClient() {
        return HttpClientBuilder.create()
                .setMaxConnTotal(properties.getMaxConn())
            .build();
    }
}
