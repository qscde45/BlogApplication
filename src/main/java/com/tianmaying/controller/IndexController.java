package com.tianmaying.controller;

import com.tianmaying.model.Blog;
import com.tianmaying.model.User;
import com.tianmaying.service.BlogService;
import com.tianmaying.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/{username:[a-z0-9_]+}")
    @ResponseBody
    public List<Blog> getByPage(@PathVariable("username") String username,
                                @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        //Your code goes here
        //User user = userService.findByName(username);
        int first = (page - 1) * size;
        List<Blog> lists = blogService.findBlogs().subList(first, first + size);
        return lists;
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

}
