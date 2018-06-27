package com.github.vanroy.springboot.urlshortener.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletRequest;

import lombok.RequiredArgsConstructor;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpHead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.github.vanroy.springboot.urlshortener.config.UrlShortenerProperties;
import com.github.vanroy.springboot.urlshortener.model.ShortLink;
import com.github.vanroy.springboot.urlshortener.ws.LinkWebService;

/**
 * @author Julien Roy
 */
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

    final LinkWebService linkService;
    final UrlShortenerProperties properties;
    final HttpClient httpClient;

    @ModelAttribute
    public void global(ModelMap map) {
        map.addAttribute("backgroundColor", properties.getBackgroundColor());
    }

    @GetMapping
    String index() {
        return "index";
    }

    @PostMapping
    ModelAndView generate(@ModelAttribute("originalUrl") String originalUrl, ServletRequest request) throws IOException {

        // Add Original URL validation
        if(httpClient.execute(new HttpHead(originalUrl)).getStatusLine().getStatusCode() != 200) {
            throw new IllegalArgumentException();
        }

        ShortLink link = linkService.createLink(originalUrl);

        return new ModelAndView("index", "shortLink", relocateUrl(link.getShortUri(), request));
    }

    @GetMapping("{shortUri}")
    String shortUri(@PathVariable String shortUri) {
        return "redirect:"+linkService.getLink(shortUri).getOriginalUrl();
    }

    /**
     * Return shortUri with baseUrl ( ex: http://localhost/... )
     */
    private String relocateUrl(String shortUri, ServletRequest request) {
        try {
            URL baseUrl = new URL(request.getScheme(), request.getServerName(), request.getServerPort(), "/");
            return baseUrl + shortUri;
        } catch (MalformedURLException e) {
            return shortUri;
        }
    }

}
