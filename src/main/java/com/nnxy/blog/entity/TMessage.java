package com.nnxy.blog.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (TMessage)实体类
 *
 * @author makejava
 * @since 2020-08-11 11:33:08
 */
public class TMessage implements Serializable {
    private static final long serialVersionUID = -95238131548617362L;

    private Long id;

    private String nickname;

    private String email;

    private String content;

    private String avatar;

    private Date createTime;

    private Long parentMessageId;

    private Object adminMessage;


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

    public Long getParentMessageId() {
        return parentMessageId;
    }

    public void setParentMessageId(Long parentMessageId) {
        this.parentMessageId = parentMessageId;
    }

    public Object getAdminMessage() {
        return adminMessage;
    }

    public void setAdminMessage(Object adminMessage) {
        this.adminMessage = adminMessage;
    }

}