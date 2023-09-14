package com.example.rrprep3.web;

import com.example.rrprep3.service.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {/*
    private final PostService postService;

    public HomeController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping("/")
    public String index(HttpSession httpSession, Model model){
        if(httpSession.getAttribute("user") == null){
            return "index";
        }

        model.addAttribute("userPosts", postService.findAllPostsByUsername());

        return  "home";
    }*/
}
