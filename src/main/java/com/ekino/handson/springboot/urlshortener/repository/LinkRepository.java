package com.ekino.handson.springboot.urlshortener.repository;

import org.springframework.data.repository.CrudRepository;

import com.ekino.handson.springboot.urlshortener.model.ShortLink;

/**
 * @author: Julien Roy
 * @version: $Id$
 */
public interface LinkRepository extends CrudRepository<ShortLink, Long> {

    ShortLink findOneByShortUri(String shortUri);

    ShortLink findOneByOriginalUrl(String originalUrl);

    String deleteByShortUri(String shortUri);

}
