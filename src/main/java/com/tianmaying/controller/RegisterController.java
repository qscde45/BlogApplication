package com.tianmaying.controller;

import com.tianmaying.model.Blog;
import com.tianmaying.model.User;
import com.tianmaying.service.BlogService;
import com.tianmaying.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;
    private final BlogService blogService;

    @Autowired
    public RegisterController(UserService userService, BlogService blogService) {
        this.userService = userService;
        this.blogService = blogService;
    }

    @GetMapping
    public String get() {
        return "register";
    }

    @PostMapping
    public String post(@RequestParam("name") String name,
                       @RequestParam("password") String password,
                       @RequestParam("email") String email) {
        //Your code goes here
        User user = new User(name, email, password);
        userService.register(user);
        Blog blog = new Blog("First Blog", "Hello World", user);
        blogService.createBlog(blog);
        return "redirect:/" + name;
    }

//    @RequestMapping(value = "/blogs", method = RequestMethod.POST)
//    public String create(Blog blog) {
//        //save title and content to repository
//        return "redirect:/blogs/" + blog.getId();  // 表示重定向到博客信息页面
//    }

}
