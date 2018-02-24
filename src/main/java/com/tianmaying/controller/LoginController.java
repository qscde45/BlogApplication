package com.tianmaying.controller;

import com.tianmaying.model.User;
import com.tianmaying.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String get() {
        return "login";
    }

    @PostMapping
    public String post(User user) {

//        String username = "";
//        for (User u : userService.getUsers()) {
//            if (u.getEmail().equals(user.getEmail()))
//                username = u.getName();
//        }
        User u = userService.login(user.getEmail(), user.getPassword());
        return "redirect:/" + u.getName();
    }

}
