package com.tianmaying.controller;

import com.tianmaying.form.UserRegisterForm;
import com.tianmaying.model.Blog;
import com.tianmaying.model.User;
import com.tianmaying.service.BlogService;
import com.tianmaying.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
    public String get(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping
    public String post(@ModelAttribute("user") @Valid UserRegisterForm form, BindingResult result, HttpSession session,
                       final RedirectAttributes redirectAttributes){
        //Your code goes here
        if (result.hasErrors()) {
            return "register";
        }

        User user = form.ToUser();
        userService.register(user);
        session.setAttribute("SESSION_LOGGED_IN", true);
        redirectAttributes.addFlashAttribute("message", "Login Success");
        return "redirect:/admin";
    }

}
