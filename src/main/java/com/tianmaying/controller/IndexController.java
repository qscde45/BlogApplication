package com.tianmaying.controller;

import com.tianmaying.model.Blog;
import com.tianmaying.service.BlogService;
import com.tianmaying.service.UserService;
import com.tianmaying.service.impl.BlogServiceImpl;
import com.tianmaying.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tianmaying.model.User;

import java.util.List;


@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/{username:[a-z0-9_]+}")
    @ResponseBody
    public List<Blog> ss (@PathVariable String username){
        User user = userService.findByName(username);
        return blogService.findBlogs(user);
    }

}
