package com.gryffindor.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class SearchController {

    //test
    @GetMapping("/search")
    public String testSearch() {
        return "There's an unequal amount of good and bad in most things. The trick is to figure out the ratio and act accordingly.";
    }
}
