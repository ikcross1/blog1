package com.nnxy.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MusicShowController {

    @RequestMapping("/music")
    public String about() {
        return "music";
    }

}
