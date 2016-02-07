package com.github.vanroy.springboot.starters.httpclient;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Julien Roy
 */
@ConfigurationProperties(prefix = "spring.httpclient")
public class HttpClientProperties {

    private Integer maxConn;

    public Integer getMaxConn() {
        return maxConn;
    }

    public void setMaxConn(Integer maxConn) {
        this.maxConn = maxConn;
    }
}
