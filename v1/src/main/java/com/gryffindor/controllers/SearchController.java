package com.gryffindor.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class SearchController {

    @GetMapping("/search")
    public String testSearch() {
        // send GET request to yelp api and return results here
         return "yelp search results go here";
    }
}
