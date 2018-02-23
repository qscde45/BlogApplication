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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.Inet4Address;
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



    //@GetMapping("/{username}")
    //使用@RequestParam获取参数
    @GetMapping("/{username}")
    public String get(@PathVariable("username") String username,
                      @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                      @RequestParam(name = "size", required = false, defaultValue = "10") int size, Model model) {
        // Your Code goes here
        // 渲染模板list.html
        int first = (page - 1) * size;
        User user = userService.findByName(username);
        List<Blog> bloglists = blogService.findBlogs(user).subList(first, first + size);
        model.addAttribute("bloglists", bloglists);
        return "list";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

}
