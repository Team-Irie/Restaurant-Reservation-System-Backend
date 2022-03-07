package com.gryffindor.services;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import org.springframework.stereotype.Service;

@Service
public class SearchYelpService {
        public SearchYelpService() {}

        public static String searchYelp(String term, String location) {
        // create url with query parameters
        String url = "https://api.yelp.com/v3/businesses/search?term=" + term + "&location=" + location + "&limit=10";

        // create headers
        HttpHeaders headers = new HttpHeaders();
        String yelpApiKey = System.getenv("YELP_API_KEY");
        headers.setBearerAuth("bMx1mn0VIIbcJVkKJllggO7mkp-U6rZT7z0I_MiJC4u11bJFpO1A6-565tZLrRwk7pM5wDk8SfGlR9HbgC7tQ5UM1gQ1VyoOltFXZbPNmrgXMFKcbhztvbDaRBkUYnYx");

        // create request
        HttpEntity<?> request = new HttpEntity<>(headers);

        // make a request
        ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.GET, request, String.class);

        // get JSON response
        String json = response.getBody();

        System.out.println(json);
        return json;
    }
}
