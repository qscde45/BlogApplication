package com.tianmaying.controller;

import com.tianmaying.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    private final BlogService blogService;

    @Autowired
    public IndexController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/{username}")
    public String getByPage(@PathVariable("username") String username,
                                @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                @RequestParam(value = "size", required = false, defaultValue = "10") int size,
                                Model model) {
        // Your Code goes here
        // 渲染模板list.html
        return "list";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

}
