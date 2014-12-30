package com.ekino.handson.springboot.starters.httpclient;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by julien on 30/12/14.
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
