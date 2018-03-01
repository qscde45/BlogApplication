package com.tianmaying.controller;

import com.tianmaying.model.Blog;
import com.tianmaying.model.Comment;
import com.tianmaying.model.User;
import com.tianmaying.service.BlogService;
import com.tianmaying.service.CommentService;
import com.tianmaying.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller

public class BlogController {

    private final BlogService blogService;
    private final CommentService commentService;
    private final UserService userService;

    @Autowired
    public BlogController(BlogService blogService, CommentService commentService, UserService userService) {
        this.blogService = blogService;
        this.commentService = commentService;
        this.userService= userService;
    }

    @RequestMapping("/blogs/{id}")
    public String get(@PathVariable("id") long id, Model model) {
        // Your Code goes here
        Blog blog = blogService.findBlog(id);
        model.addAttribute("blog", blog);
        List<Comment> comments = commentService.getCommentOfBlog(blog);


//
//        Comment empty = new Comment();
//        empty.setBlog(blog);
//        empty.setContent("dqwdqwdqw");
//        empty.setCommentor(userService.findByName("tianmaying"));
//        empty.setCreatedTime(new Date());
//        comments.add(empty);
//        model.addAttribute("comments", empty);

        model.addAttribute("comments", comments);
        return "item";
    }

    @PostMapping("/blogs/{id}/comments")
    public String getComments(@PathVariable("id") long id, HttpSession session,
                              @RequestParam("content") String content){
        Blog blog = blogService.findBlog(id);
        User user = (User)session.getAttribute("CURRENT_USER");

        Comment comment = new Comment();
        comment.setCommentor(user);
        comment.setContent(content);
        comment.setCreatedTime(new Date());
        comment.setBlog(blog);
        commentService.createComment(comment);

        if (commentService.getCommentOfBlog(blog) == null) {
            List<Comment> l = new ArrayList<>();
            l.add(comment);
            blog.setComments(l);
        }
        else
            commentService.getCommentOfBlog(blog).add(comment);

        return "redirect:/blogs/" + String.valueOf(id);
    }
}