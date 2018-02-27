package com.tianmaying.controller;

import com.tianmaying.form.BlogCreateForm;
import com.tianmaying.model.Blog;
import com.tianmaying.model.User;
import com.tianmaying.service.BlogService;
import com.tianmaying.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String get() {
        return "create";
    }

    @PostMapping("/blogs")
    public String post(@Valid BlogCreateForm form) {

        User user = userService.findByName("tianmaying");//这里我们在数据初始化的时候添加了一个用户tianmaying,当然你也可以自行修改,使用别的用户
        Blog blog = form.toBlog(user);
        // Your Code goes here
        // 注意, form.toBlog方法需要传入一个User参数,现在你可以暂时使用一个临时的用户(在初始化时添加的)作为博客的创建者
        return "";
    }

}
