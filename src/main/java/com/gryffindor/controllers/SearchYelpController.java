package com.gryffindor.controllers;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin("*")
public class SearchYelpController {

    @GetMapping("/search")
    public String searchYelp(@RequestParam String term, @RequestParam String location) {
        // send GET request to yelp api and return results here
        // request - query parameters(term, location) and url
        String url = "https://api.yelp.com/v3/businesses/search?term=" + term + "&location=" + location + "&limit=1";

        // create headers
        HttpHeaders headers = new HttpHeaders();
        String yelpApiKey = System.getenv("YELP_API_KEY");
        headers.setBearerAuth(yelpApiKey);

        // create request
        HttpEntity<?> request = new HttpEntity<>(headers);

        // make a request
        ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.GET, request, String.class);

        // get JSON response
        String json = response.getBody();
        System.out.print(url);

        return json;
    }
}