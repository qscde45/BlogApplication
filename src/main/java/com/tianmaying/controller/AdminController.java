package com.tianmaying.controller;

import com.tianmaying.model.User;
import com.tianmaying.service.BlogService;
import com.tianmaying.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


/**
 * Created by Hao on 2/26/18.
 */
@Controller
public class AdminController {

    //private UserService userService;
    private BlogService blogService;

    @Autowired
    public AdminController(BlogService blogService) {
        //this.userService = userService;
        this.blogService = blogService;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(@PageableDefault org.springframework.data.domain.Pageable pageable, Model model,
                        @ModelAttribute("message") String message, HttpSession session) {
        User user = (User)session.getAttribute("CURRENT_USER");
        model.addAttribute("blogs", blogService.findBlogs(user, pageable));
        //model.addAttribute("user", user);
        return "admin";
    }

}
