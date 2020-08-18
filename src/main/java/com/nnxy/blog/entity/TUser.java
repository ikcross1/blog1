package com.nnxy.blog.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (TUser)实体类
 *
 * @author makejava
 * @since 2020-08-08 17:58:27
 */
public class TUser implements Serializable {
    private static final long serialVersionUID = 521772613323797081L;

    private Long id;

    private String avatar;

    private Date createTime;

    private String email;

    private String nickname;

    private String password;

    private Integer type;

    private Date updateTime;

    private String username;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "TUser{" +
                "id=" + id +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", updateTime=" + updateTime +
                ", username='" + username + '\'' +
                '}';
    }
}