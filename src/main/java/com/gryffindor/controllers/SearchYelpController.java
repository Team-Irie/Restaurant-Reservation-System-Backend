package com.gryffindor.controllers;

import org.springframework.web.bind.annotation.*;
import com.gryffindor.services.SearchYelpService;

@RestController
@CrossOrigin("*")
public class SearchYelpController {


    @GetMapping("/search")
    public String searchYelp(@RequestParam String term, @RequestParam String location) {
        return SearchYelpService.searchYelp(term, location);
    }
}