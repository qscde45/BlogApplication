package com.tianmaying.controller;

import com.tianmaying.form.BlogCreateForm;
import com.tianmaying.model.Blog;
import com.tianmaying.model.Comment;
import com.tianmaying.model.User;
import com.tianmaying.service.BlogService;
import com.tianmaying.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CreateBlogController {

    private final BlogService blogService;

    private final UserService userService;

    @Autowired
    public CreateBlogController(BlogService blogService, UserService userService) {
        this.blogService = blogService;
        this.userService = userService;
    }

    @GetMapping("/blogs/create")
    public String get(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/blogs")
    public String post(@ModelAttribute("blog") @Valid BlogCreateForm form, BindingResult result) {

        if (result.hasErrors())
            return "create";

        User user = userService.findByName("tianmaying");//这里我们在数据初始化的时候添加了一个用户tianmaying,当然你也可以自行修改,使用别的用户
        Blog blog = form.toBlog(user);
        blog = blogService.createBlog(blog);
        return "redirect:/blogs/" + blog.getId();
    }

}
