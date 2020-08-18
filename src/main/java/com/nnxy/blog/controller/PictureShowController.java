package com.nnxy.blog.controller;

import com.nnxy.blog.entity.TPicture;
import com.nnxy.blog.service.TPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PictureShowController {
    @Autowired
    private TPictureService tPictureService;



    @RequestMapping("/picture")
    public String friends(Model model) {
        List<TPicture> list=tPictureService.listPicture();
        model.addAttribute("pictures",list);
        return "picture";
    }

}
