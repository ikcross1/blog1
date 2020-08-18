package com.nnxy.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nnxy.blog.entity.TBlog;
import com.nnxy.blog.entity.TFriend;
import com.nnxy.blog.entity.TType;
import com.nnxy.blog.service.TFriendService;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (TFriend)表控制层
 *
 * @author makejava
 * @since 2020-08-15 09:32:33
 */
@Controller
@RequestMapping("tFriend")
public class TFriendController {
    /**
     * 服务对象
     */
    @Resource
    private TFriendService tFriendService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TFriend selectOne(Long id) {
        return this.tFriendService.queryById(id);
    }

    //跳转到友情链接页面
    @RequestMapping("admin_friendsLinks")
    public String admin_friendLinks(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<TFriend> listFriendLink = tFriendService.getAllFriendLinks();
        for(TFriend friend :listFriendLink){
            System.out.println(friend);
        }
        PageInfo<TFriend> pageInfo = new PageInfo<TFriend>(listFriendLink);
        model.addAttribute("links",pageInfo.getList());
        model.addAttribute("pageInfo",pageInfo);

        return "admin_friendsLinks";
    }
    //编辑修改分类
    @RequestMapping("updateFriendsLinks/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        TFriend tFriend = tFriendService.queryById(id);
        model.addAttribute("tFriend", tFriend);
        return "admin_editFriends";
    }

    //跳转到友情链接新增页面
    @RequestMapping("admin_friendsInputs")
    public String admin_friendsInputs(Model model){
        model.addAttribute("types",tFriendService.getAllFriendLinks());
        model.addAttribute("friendLinks", new TFriend());
        return "admin_friendsInputs";
    }

    //删除友情链接
    @RequestMapping("deleteFriendsLinks/{id}")
    public String deleteFriendsLinks(@PathVariable Long id,RedirectAttributes attributes){
        boolean t1 = tFriendService.deleteById(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/tFriend/admin_friendsLinks";
    }


    @RequestMapping("updateFriendsLinks/{id}")
    public String updateFriendsLinks(RedirectAttributes attributes, @PathVariable Long id,String blogname,String blogaddress,String pictureaddress  ){
            TFriend tFriend=tFriendService.queryById(id);
            tFriend.setId(id);
            tFriend.setBlogname(blogname);
            tFriend.setBlogaddress(blogaddress);
            tFriend.setPictureaddress(pictureaddress);
            int f = tFriendService.updateFriendsLinks(tFriend);
            if(f == 0){
                System.out.println("修改失败");
                attributes.addFlashAttribute("message", "修改失败");
            }else {
                System.out.println("修改成功");
                attributes.addFlashAttribute("message", "修改成功");
            }
        return "redirect:/tFriend/admin_friendsLinks";
    }


    //保存友情链接
    @RequestMapping("saveFriendsLinks")
    public String saveFriendsLinks(RedirectAttributes attributes,String blogname,String blogaddress,String pictureaddress ){
        TFriend friend = new TFriend();
        List<TFriend> tFriendList = tFriendService.getAllFriendLinks();
        for(TFriend tFriend : tFriendList){
            if(blogaddress.equals(tFriend.getBlogaddress())){
                attributes.addFlashAttribute("message", "不能添加相同的网址");
                return "redirect:/tFriend/admin_friendsInputs";
            }
        }
        friend.setBlogname(blogname);
        friend.setBlogaddress(blogaddress);
        friend.setPictureaddress(pictureaddress);
        friend.setCreateTime(new Date());
        int F = tFriendService.saveFriendLink(friend);
        if (F == 0 ) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/tFriend/admin_friendsLinks";
    }




}
