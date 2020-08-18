package com.nnxy.blog.controller;

import com.nnxy.blog.entity.TMessage;
import com.nnxy.blog.service.TMessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;

/**
 * (TMessage)表控制层
 *
 * @author makejava
 * @since 2020-08-11 11:33:09
 */
@Controller
@RequestMapping("tMessage")
public class TMessageController {
    /**
     * 服务对象
     */
    @Resource
    private TMessageService tMessageService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TMessage selectOne(Long id) {
        return this.tMessageService.queryById(id);
    }

    @RequestMapping("message")
    public String message(){
        return "message";
    }

}