package com.nnxy.blog.controller;

import com.nnxy.blog.entity.TFriend;
import com.nnxy.blog.service.TFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class FriendsShowController {
    @Autowired
    private TFriendService tFriendService;

    @RequestMapping("/friends")
    public String friends(Model model) {
        List<TFriend> list =tFriendService.getAllFriendLinks();
        model.addAttribute("friendlinks",list);
        return "friends";
    }
}
