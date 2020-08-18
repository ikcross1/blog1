package com.nnxy.blog.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * (TType)实体类
 *
 * @author makejava
 * @since 2020-08-11 10:20:29
 */
public class TType implements Serializable {
    private static final long serialVersionUID = 960066600245297348L;

    private Long id;

    private String name;

    private List<TBlog> blogs = new ArrayList<>();

    public TType() {
    }

    public TType(String name) {
        this.name = name;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<TBlog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<TBlog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "TType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", blogs=" + blogs +
                '}';
    }
}