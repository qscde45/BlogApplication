package com.tianmaying.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/about")
    public String about() {
        return "about";
    }

}
