package com.tianmaying.controller;

import com.tianmaying.model.Blog;
import com.tianmaying.model.User;
import com.tianmaying.service.BlogService;
import com.tianmaying.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateBlogController {

    private final UserService userService;
    private final BlogService blogService;

    @Autowired
    public CreateBlogController(UserService userService, BlogService blogService) {
        this.userService = userService;
        this.blogService = blogService;
    }

    @GetMapping("/blogs/create")
    public String get() {
        return "create";
    }

//    @PostMapping("/blogs")
//    public String post(Blog blog) {
//        blog.setAuthor(userService.findByName("tianmaying"));
//        blogService.createBlog(blog);
//        //model.addAttribute("blog", blog);
//
//        return "redirect:/blogs/" + blog.getId();
//    }

    @PostMapping("/blogs/create")
    public String post(@RequestParam("title") String title,
                       @RequestParam("content") String content) {
        Blog blog = blogService.createBlog(new Blog(title, content,userService.findByName("tianmaying")));

        //model.addAttribute("blog", blog);

        return "redirect:/blogs/" + blog.getId();
    }
}
