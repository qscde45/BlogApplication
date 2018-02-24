package com.tianmaying.controller;

import com.tianmaying.model.User;
import com.tianmaying.service.BlogService;
import com.tianmaying.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String getByPage(@PathVariable("username") String username,
                            @PageableDefault(size = 15, direction = Sort.Direction.DESC, sort = "id") Pageable pageable,
                            Model model) {
        User user = userService.findByName(username);
        model.addAttribute("blogs", blogService.findBlogs(user, pageable));
        model.addAttribute("user", user);
        return "list";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

}
