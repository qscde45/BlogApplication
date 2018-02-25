package com.tianmaying.controller;

import com.tianmaying.model.Blog;
import com.tianmaying.model.Tag;
import com.tianmaying.model.User;
import com.tianmaying.service.BlogService;
import com.tianmaying.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public String post(Blog blog) {



        Blog newBlog = new Blog();
        newBlog.setTitle(blog.getTitle());
        newBlog.setContent(blog.getContent());
        newBlog.setAuthor(userService.findByName("tianmaying"));
        newBlog.setCreatedTime(new Date());
        blogService.createBlog(newBlog);

        //Blog tmp = new Blog(title, content,userService.findByName("tianmaying"));
//        List<Tag> list = new ArrayList<>();
//        list.add(new Tag(tags));
//        tmp.setTags(list);
        //Blog blog = blogService.createBlog(tmp);

        return "redirect:/blogs/" + newBlog.getId();
    }
}
