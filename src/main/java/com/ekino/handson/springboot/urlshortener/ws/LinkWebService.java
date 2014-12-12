package com.ekino.handson.springboot.urlshortener.ws;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ekino.handson.springboot.urlshortener.model.ShortLink;

/**
 * @author: Julien Roy
 * @version: $Id$
 */
@RestController
public class LinkWebService {

    @RequestMapping(value = "/link", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ShortLink createLink(@RequestBody String originalUrl) {
        return new ShortLink(originalUrl);
    }

    @RequestMapping(value = "/link/all", method = RequestMethod.GET)
    public List<ShortLink> allLinks() {
        List<ShortLink> sl = new ArrayList<>();
        sl.add(new ShortLink("http://original1"));
        sl.add(new ShortLink("http://original2"));
        sl.add(new ShortLink("http://original3"));
        return sl;
    }

    @RequestMapping(value = "/link/{shortUri}", method = RequestMethod.GET)
    public ShortLink getLink(@PathVariable String shortUri) {
        return new ShortLink("originalUrl");
    }

    @RequestMapping(value = "/link/{shortUri}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteLink(@PathVariable String shortUri) {

    }
}
