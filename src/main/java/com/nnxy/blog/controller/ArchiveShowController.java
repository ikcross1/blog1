package com.nnxy.blog.controller;

import com.nnxy.blog.entity.BlogQuery;
import com.nnxy.blog.service.TBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ArchiveShowController {
    @Autowired
    private TBlogService tBlogService;

    @RequestMapping("/archives")
    public String archive(Model model){
        List<BlogQuery> blogs = tBlogService.getAllBlog();
        model.addAttribute("blogs", blogs);
        return "archives";
    }

}
