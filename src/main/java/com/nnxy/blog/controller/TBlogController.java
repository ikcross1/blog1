package com.nnxy.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nnxy.blog.entity.*;
import com.nnxy.blog.service.TBlogService;
import com.nnxy.blog.service.TTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (TBlog)表控制层
 *
 * @author makejava
 * @since 2020-08-10 16:05:30
 */
@Controller
@RequestMapping("tBlog")
public class TBlogController {
    /**
     * 服务对象
     */
    @Resource
    private TBlogService tBlogService;

    @Autowired
    private TTypeService tTypeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TBlog selectOne(Long id) {
        return this.tBlogService.queryById(id);
    }

    //跳转到博客页面
    @RequestMapping("admin_blogs")
    public String admin_blogs(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        String orderBy = "update_time desc";
        PageHelper.startPage(pageNum, 5, orderBy);
        List<BlogQuery> list = tBlogService.getAllBlog();
        PageInfo<BlogQuery> pageInfo = new PageInfo<BlogQuery>(list);
        model.addAttribute("types", tTypeService.getAllType());
        model.addAttribute("blogs", pageInfo.getList());
        model.addAttribute("pageInfo", pageInfo);
        return "admin_blogs";

    }

    //跳转到博客新增页面
    @RequestMapping("admin_blogsInputs")
    public String admin_blogsInputs(Model model) {
        model.addAttribute("types", tTypeService.getAllType());
        model.addAttribute("blog", new TBlog());
        return "admin_blogsInputs";
    }

    //删除博客
    @RequestMapping("deleteBlogs/{id}")
    public String deleteBlogs(@PathVariable Long id, RedirectAttributes attributes) {
        boolean t1 = tBlogService.deleteById(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/tBlog/admin_blogs";
    }

    //编辑修改分类
    @RequestMapping("updateBlogs/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        TBlog tBlog = tBlogService.queryById(id);
        System.out.println(tBlog.getFirstPicture());
        List<TType> allType = tTypeService.getAllType();
        model.addAttribute("blog", tBlog);
        model.addAttribute("types", allType);
        return "admin_editInput";
    }

    //编辑修改文章
    @RequestMapping("updateBlog/{id}")
    public String updateBlog(@PathVariable Long id, String flag, String title, String content, String firstPicture, String description, Long typeId, RedirectAttributes attributes) {
        TBlog tBlog = tBlogService.queryById(id);
        ShowBlog showBlog = new ShowBlog();
        showBlog.setFlag(flag);
        showBlog.setTitle(title);
        showBlog.setContent(content);
        showBlog.setFirstPicture(firstPicture);
        showBlog.setDescription(description);
        showBlog.setRecommend(tBlog.getRecommend());
        showBlog.setShareStatement(tBlog.getShareStatement());
        showBlog.setAppreciation(tBlog.getAppreciation());
        showBlog.setCommentabled(tBlog.getCommentabled());
        showBlog.setTypeId(typeId);
        showBlog.setPublished(tBlog.getPublished());
        showBlog.setId(id);
        int b = tBlogService.updateBlog(showBlog);
        if (b == 0) {
            System.out.println("修改失败");
            attributes.addFlashAttribute("message", "修改失败");
        } else {
            System.out.println("修改成功");
            attributes.addFlashAttribute("message", "修改成功");
        }
        return "redirect:/tBlog/admin_blogs";

    }


    //新增分类
    @RequestMapping("saveBlogs")
    public String saveBlogs(String flag, String title, String content, String firstPicture, String description
            , Boolean recommend, Boolean shareStatement, Boolean appreciation, Boolean commentabled, Long typeId, RedirectAttributes attributes) {
        TBlog tBlog = new TBlog();
        tBlog.setPublished(true);
        tBlog.setFlag(flag);
        tBlog.setTitle(title);
        tBlog.setContent(content);
        tBlog.setFirstPicture(firstPicture);
        tBlog.setDescription(description);
        tBlog.setUserId((long) 1);
        if (recommend == null) {
            recommend = false;
        }
        tBlog.setRecommend(recommend);
        if (shareStatement == null) {
            shareStatement = false;
        }
        tBlog.setShareStatement(shareStatement);
        if (appreciation == null) {
            appreciation = false;
        }
        tBlog.setAppreciation(appreciation);
        if (commentabled == null) {
            commentabled = false;
        }
        tBlog.setCommentabled(commentabled);
        tBlog.setTypeId(typeId);
        System.out.println(flag + title + content + firstPicture + description + recommend + shareStatement + appreciation + commentabled);
        int b = tBlogService.saveBlog(tBlog);
        if (b == 0) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/tBlog/admin_blogs";

    }


}