package com.nnxy.blog.controller;

import com.nnxy.blog.entity.TComment;
import com.nnxy.blog.service.TCommentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (TComment)表控制层
 *
 * @author makejava
 * @since 2020-08-11 11:30:59
 */
@RestController
@RequestMapping("tComment")
public class TCommentController {
    /**
     * 服务对象
     */
    @Resource
    private TCommentService tCommentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TComment selectOne(Long id) {
        return this.tCommentService.queryById(id);
    }

}