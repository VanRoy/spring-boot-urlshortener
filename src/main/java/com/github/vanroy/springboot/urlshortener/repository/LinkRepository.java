package com.github.vanroy.springboot.urlshortener.repository;

import org.springframework.data.repository.CrudRepository;
import com.github.vanroy.springboot.urlshortener.model.ShortLink;

/**
 * @author Julien Roy
 */
public interface LinkRepository extends CrudRepository<ShortLink, Long> {

    ShortLink findOneByShortUri(String shortUri);

    ShortLink findOneByOriginalUrl(String originalUrl);

    String deleteByShortUri(String shortUri);

}
