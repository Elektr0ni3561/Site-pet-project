package ru.elektr0ni3561.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/")
    public String mainListener()
    {
        return "index";
    }

    @GetMapping("/search")
    public String searchListener()
    {
        return "search";
    }
}
