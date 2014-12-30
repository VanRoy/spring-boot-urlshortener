package com.ekino.handson.springboot.urlshortener.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletRequest;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpHead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ekino.handson.springboot.urlshortener.config.Configuration;
import com.ekino.handson.springboot.urlshortener.model.ShortLink;
import com.ekino.handson.springboot.urlshortener.ws.LinkWebService;

/**
 * @author: Julien Roy
 * @version: $Id$
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    LinkWebService linkService;

    @Autowired
    private Configuration configuration;

    @Autowired
    private HttpClient httpClient;

    @ModelAttribute
    public void global(ModelMap map) {
        map.addAttribute("backgroundColor", configuration.getBackgroundColor());
    }

    @RequestMapping(method = RequestMethod.GET)
    String index() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    ModelAndView generate(@ModelAttribute("originalUrl") String originalUrl, ServletRequest request) throws IOException {

        // Add Original URL validation
        if(httpClient.execute(new HttpHead(originalUrl)).getStatusLine().getStatusCode() != 200) {
            throw new IllegalArgumentException();
        }

        ShortLink link = linkService.createLink(originalUrl);

        return new ModelAndView("index", "shortLink", relocateUrl(link.getShortUri(), request));
    }

    @RequestMapping(value="{shortUri}",method = RequestMethod.GET)
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
