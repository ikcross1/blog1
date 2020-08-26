package com.nnxy.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nnxy.blog.entity.TFriend;
import com.nnxy.blog.entity.TType;
import com.nnxy.blog.service.TTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.util.List;

/**
 * (TType)表控制层
 *
 * @author makejava
 * @since 2020-08-11 10:20:30
 */
@Controller
@RequestMapping("tType")
public class TTypeController {
    /**
     * 服务对象
     */
    @Resource
    private TTypeService tTypeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TType selectOne(Long id) {
        return this.tTypeService.queryById(id);
    }

    //跳转到分类管理输入页面
    @RequestMapping("admin_typesInputs")
    public String admin_typesInputs() {
        return "admin_typesInputs";
    }

    //分页查询分类列表   跳转到分类管理页面
    @RequestMapping("/admin_types")
    public String list(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        String orderBy = "id asc";
        PageHelper.startPage(pageNum, 5, orderBy);
        List<TType> list = tTypeService.getAllType();
        PageInfo<TType> pageInfo = new PageInfo<TType>(list);
//        model.addAttribute("pageNum",pageInfo.getPageNum());//当前页码
//        model.addAttribute("pageSize",pageInfo.getPageSize());//当前页查询记录
//        model.addAttribute("isFirstPage",pageInfo.isIsFirstPage());//是否是第一页
//        model.addAttribute("totalPages",pageInfo.getPages());//获得总页数
//        model.addAttribute("isLastPage",pageInfo.isIsLastPage());//是否是最后一页
        model.addAttribute("types", pageInfo.getList());
        model.addAttribute("pageInfo", pageInfo);
        return "admin_types";
    }

    //新增分类
    @RequestMapping("saveTypes")
    public String saveTypes(String typeName, RedirectAttributes attributes) {
        List<TType> list = tTypeService.getAllType();
        for (TType type : list) {
            if (type.getName().equals(typeName)) {
                System.out.println("不能添加重复的分类");
                attributes.addFlashAttribute("message", "不能添加重复的分类");
                return "redirect:/tType/admin_typesInputs";
            }
        }
        int t = tTypeService.saveType(new TType(typeName));
        if (t == 0) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/tType/admin_types";
    }

    //删除分类
    @RequestMapping("deleteTypes/{id}")
    public String deleteTypesById(@PathVariable Long id, RedirectAttributes attributes) {
        boolean t1 = tTypeService.deleteById(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/tType/admin_types";
    }



}