package com.tianmaying.controller;

import com.tianmaying.model.User;
import com.tianmaying.model.Blog;
import com.tianmaying.service.BlogService;
import com.tianmaying.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class IndexController {

    private final BlogService blogService;
    private final UserService userService;

    @Autowired
    public IndexController(BlogService blogService, UserService userService) {
        this.blogService = blogService;
        this.userService = userService;
    }



    @GetMapping("/{username}")
    //使用@RequestParam获取参数
    public String get(@PathVariable("username") String username, Model model) {
        // Your Code goes here
        // 渲染模板list.html
        User user = userService.findByName(username);
        List<Blog> bloglists = blogService.findBlogs(user);
        model.addAttribute("bloglists", bloglists);
        return "list";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

}
