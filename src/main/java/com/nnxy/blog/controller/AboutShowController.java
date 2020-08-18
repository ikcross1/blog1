package com.nnxy.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutShowController {

    @RequestMapping("/about")
    public String about() {
        return "about";
    }

}
