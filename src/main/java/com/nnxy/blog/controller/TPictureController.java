package com.nnxy.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nnxy.blog.entity.TFriend;
import com.nnxy.blog.entity.TPicture;
import com.nnxy.blog.service.TPictureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TPicture)表控制层
 *
 * @author makejava
 * @since 2020-08-15 11:49:02
 */
@Controller
@RequestMapping("tPicture")
public class TPictureController {
    /**
     * 服务对象
     */
    @Resource
    private TPictureService tPictureService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TPicture selectOne(Long id) {
        return this.tPictureService.queryById(id);
    }

    //跳转到图片页面
    @RequestMapping("admin_pictures")
    public String admin_pictures(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 5);
        List<TPicture> pictureList = tPictureService.getAllPictures();
        PageInfo<TPicture> pageInfo = new PageInfo<TPicture>(pictureList);
        model.addAttribute("pictures", pageInfo.getList());
        model.addAttribute("pageInfo", pageInfo);

        return "admin_pictures";
    }

    //跳转到图片输入页面
    @RequestMapping("admin_picturesInputs")
    public String admin_picturesInputs() {
        return "admin_picturesInputs";
    }

    //保存图片
    @RequestMapping("savePictures")
    public String savePictures(RedirectAttributes attributes, String picturename, String picturetime, String pictureaddress, String picturedescription) {
        TPicture tPicture = new TPicture();
        tPicture.setPictureaddress(pictureaddress);
        tPicture.setPicturetime(picturetime);
        tPicture.setPicturename(picturename);
        tPicture.setPicturedescription(picturedescription);
        int P = tPictureService.savePictures(tPicture);
        if (P == 0) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/tPicture/admin_pictures";
    }

    //删除分类
    @RequestMapping("deletePictures/{id}")
    public String deletePictures(@PathVariable Long id, RedirectAttributes attributes) {
        boolean p = tPictureService.deleteById(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/tPicture/admin_pictures";
    }

    //编辑修改分类
    @RequestMapping("updatePicture/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("picture", tPictureService.queryById(id));
        return "admin_editPictures";
    }

    @RequestMapping("updatePictures/{id}")
    public String updatePictures(RedirectAttributes attributes, @PathVariable Long id,String picturename, String picturetime, String pictureaddress, String picturedescription){
        TPicture tPicture  = new TPicture();
        tPicture.setId(id);
        tPicture.setPictureaddress(pictureaddress);
        tPicture.setPicturetime(picturetime);
        tPicture.setPicturename(picturename);
        tPicture.setPicturedescription(picturedescription);
        int P = tPictureService.updatePicture(tPicture);
        if (P == 0 ) {
            attributes.addFlashAttribute("message", "编辑失败");
        } else {
            attributes.addFlashAttribute("message", "编辑成功");
        }
        return "redirect:/tPicture/admin_pictures";
    }
}