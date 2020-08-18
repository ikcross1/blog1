package com.nnxy.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nnxy.blog.entity.TType;
import com.nnxy.blog.entity.TUser;
import com.nnxy.blog.service.TBlogService;
import com.nnxy.blog.service.TTypeService;
import com.nnxy.blog.service.TUserService;
import com.nnxy.blog.utils.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * (TUser)表控制层
 *
 * @author makejava
 * @since 2020-08-08 17:58:32
 */
@Controller
public class TUserController {
    /**
     * 服务对象
     */
    @Resource
    private TUserService tUserService;
    @Autowired
    TBlogService tBlogService;
    @Autowired
    TTypeService tTypeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TUser selectOne(Long id) {
        return this.tUserService.queryById(id);
    }

    @RequestMapping("testindex")
    public String testindex() {
        return "admin_index";
    }


    @RequestMapping("admin_login")
    public String admin_login() {
        return "admin_login";
    }

    @RequestMapping("login")
    public String login(String username, String password,
                        Map<String, Object> map, HttpSession session,
                        RedirectAttributes attributes) {
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try{
            //获取数据传递对象
            Subject currentUser = SecurityUtils.getSubject();
            //数据(令牌)传递
            currentUser.login(token);
            System.out.println("登录成功");
            return "admin_index";
        }catch(AuthenticationException e){
            e.printStackTrace();
            System.out.println("登录异常");
        }
            return "admin_login";


    }
    //博客信息统计
    @RequestMapping("/footer/blogmessage")
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


}