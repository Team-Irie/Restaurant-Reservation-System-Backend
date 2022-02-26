package com.gryffindor.application;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    //test
    @GetMapping("/test")
    public String test() {
        return "There's an unequal amount of good and bad in most things. The trick is to figure out the ratio and act accordingly.";
    }
}
