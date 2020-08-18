package com.nnxy.blog.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (TFriend)实体类
 *
 * @author makejava
 * @since 2020-08-15 09:32:31
 */
public class TFriend implements Serializable {
    private static final long serialVersionUID = 497499376384834305L;

    private Long id;

    private String blogaddress;

    private String blogname;

    private Date createTime;

    private String pictureaddress;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlogaddress() {
        return blogaddress;
    }

    public void setBlogaddress(String blogaddress) {
        this.blogaddress = blogaddress;
    }

    public String getBlogname() {
        return blogname;
    }

    public void setBlogname(String blogname) {
        this.blogname = blogname;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPictureaddress() {
        return pictureaddress;
    }

    public void setPictureaddress(String pictureaddress) {
        this.pictureaddress = pictureaddress;
    }

}