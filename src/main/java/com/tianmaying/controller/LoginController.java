package com.tianmaying.controller;

import com.tianmaying.model.User;
import com.tianmaying.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String loginPage(@RequestParam("next") Optional<String> next) {
        return "login";
    }

    @PostMapping
    public String login(@RequestParam("next") Optional<String> next, User user, HttpSession session) {
        // Get User instance
        //return request.getHeader("referer");

        User u = userService.login(user.getEmail(), user.getPassword());
        session.setAttribute("CURRENT_USER", u); // If u is null, then no (key, value) will be added to the session.
        return "redirect:".concat(next.orElse("/"));
    }

}
