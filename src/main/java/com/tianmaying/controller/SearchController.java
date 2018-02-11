package com.tianmaying.controller;

import com.tianmaying.model.Blog;
import com.tianmaying.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class SearchController {

    private final BlogService blogService;

    @Autowired
    public SearchController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/search")
    public String  search(@RequestParam("key") String key, Model model) {
        // Your code goes here
        List<Blog> list = blogService.findBlogsByKey(key);
        model.addAttribute("bloglists", list);
        return "list";
    }
}
