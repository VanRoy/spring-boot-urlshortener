package com.ekino.handson.springboot.urlshortener.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ekino.handson.springboot.urlshortener.model.ShortLink;
import com.ekino.handson.springboot.urlshortener.repository.LinkRepository;

/**
 * @author: Julien Roy
 * @version: $Id$
 */
@RestController
public class LinkWebService {

    @Autowired
    private LinkRepository repository;

    @RequestMapping(value = "/link", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ShortLink createLink(@RequestBody String originalUrl) {
        ShortLink exist = repository.findOneByOriginalUrl(originalUrl);
        if(exist != null) {
            return exist;
        }
        return repository.save(new ShortLink(originalUrl));
    }

    @RequestMapping(value = "/link/all", method = RequestMethod.GET)
    public Iterable<ShortLink> allLinks() {
        return repository.findAll();
    }

    @RequestMapping(value = "/link/{shortUri}", method = RequestMethod.GET)
    public ShortLink getLink(@PathVariable String shortUri) {
        return repository.findOneByShortUri(shortUri);
    }

    @RequestMapping(value = "/link/{shortUri}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteLink(@PathVariable String shortUri) {
        repository.deleteByShortUri(shortUri);
    }
}
