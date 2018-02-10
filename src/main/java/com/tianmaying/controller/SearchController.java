package com.tianmaying.controller;

import com.tianmaying.model.Blog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    @GetMapping("/search")
    public List<Blog> search(@RequestParam("key") String key) {
        // Your code goes here
        return null;
    }
}
