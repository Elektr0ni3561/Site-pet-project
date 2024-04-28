package ru.elektr0ni3561.controller;

import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class APIController {


    @GetMapping("/main")
    @ResponseStatus
    public HttpStatus mainAPIListener()
    {
        return HttpStatus.OK;
    }

    @GetMapping("/search")
    public Map<String, String> searchListener(@RequestParam("type") final String type, @RequestParam("url") final String url)
    {
        final Map<String, String> l = new HashMap<String, String>();
        final String _url = url.endsWith("/") ? url.substring(0,url.length()-1) : url;
        try{
            final Connection con = Jsoup.connect(_url);
            final Document doc = con.get();
            for (Element el : doc.select("a"))
            {
                String link = el.attr("href");
                if(link.startsWith("/") || link.startsWith("#"))
                {
                    link = _url.concat(link);
                }
                l.put(link, el.text());
            }
            return l;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
