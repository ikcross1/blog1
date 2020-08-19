package com.nnxy.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nnxy.blog.entity.DetailedBlog;
import com.nnxy.blog.entity.FirstPageBlog;
import com.nnxy.blog.entity.RecommendBlog;
import com.nnxy.blog.service.TBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    TBlogService tBlogService;


    @RequestMapping("/")
    public String myindex(RedirectAttributes attributes){
        return "redirect:/index";
    }
    //分页查询博客列表
    @RequestMapping("/index")
    public String index(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, RedirectAttributes attributes){
        PageHelper.startPage(pageNum,10);
        List<FirstPageBlog> allFirstPageBlog = tBlogService.getAllFirstPageBlog();
        for(FirstPageBlog firstPageBlog : allFirstPageBlog){
            System.out.println(firstPageBlog);
        }
        List<RecommendBlog> recommendedBlog = tBlogService.getRecommendedBlog();

        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(allFirstPageBlog);
        System.out.println("pageInfo:" +pageInfo);
        model.addAttribute("blogs",pageInfo.getList());
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("recommendedBlogs", recommendedBlog);
        return "index";
    }

    //博客信息统计
    @RequestMapping("/footer/indexblogmessage")
    public String blogMessage(Model model){
        int blogTotal = tBlogService.getBlogTotal();
        int blogViewTotal = tBlogService.getBlogViewTotal();
        int blogCommentTotal = tBlogService.getBlogCommentTotal();
        int blogMessageTotal = tBlogService.getBlogMessageTotal();

        model.addAttribute("blogTotal",blogTotal);
        model.addAttribute("blogViewTotal",blogViewTotal);
        model.addAttribute("blogCommentTotal",blogCommentTotal);
        model.addAttribute("blogMessageTotal",blogMessageTotal);
        return "index :: blogMessage";
    }

    //跳转博客详情页面
    @RequestMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model) {
        DetailedBlog detailedBlog = tBlogService.getDetailedBlog(id);
        model.addAttribute("blog", detailedBlog);
        return "blog";
    }



}
