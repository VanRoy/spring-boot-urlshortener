package com.github.vanroy.springboot.urlshortener.ws;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.github.vanroy.springboot.urlshortener.model.ShortLink;
import com.github.vanroy.springboot.urlshortener.repository.LinkRepository;

/**
 * @author Julien Roy
 */
@RestController
@RequestMapping("/link")
@RequiredArgsConstructor
public class LinkWebService {

    final LinkRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShortLink createLink(@RequestBody String originalUrl) {
        ShortLink exist = repository.findOneByOriginalUrl(originalUrl);
        if(exist != null) {
            return exist;
        }
        return repository.save(new ShortLink(originalUrl));
    }

    @GetMapping
    public Iterable<ShortLink> allLinks() {
        return repository.findAll();
    }

    @GetMapping("{shortUri}")
    public ShortLink getLink(@PathVariable String shortUri) {
        return repository.findOneByShortUri(shortUri);
    }

    @DeleteMapping("{shortUri}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteLink(@PathVariable String shortUri) {
        repository.deleteByShortUri(shortUri);
    }
}
