package iu.edu.sjpagano.ducksservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public static String greetings() {
        return "Welcome to the ducks service!";
    }
}
