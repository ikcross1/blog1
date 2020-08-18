package com.nnxy.blog.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (TComment)实体类
 *
 * @author makejava
 * @since 2020-08-11 11:30:58
 */
public class TComment implements Serializable {
    private static final long serialVersionUID = 782471529563763532L;

    private Long id;

    private String nickname;

    private String email;

    private String content;

    private String avatar;

    private Date createTime;

    private Long blogId;

    private Long parentCommentId;

    private Object adminComment;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public Long getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public Object getAdminComment() {
        return adminComment;
    }

    public void setAdminComment(Object adminComment) {
        this.adminComment = adminComment;
    }

}