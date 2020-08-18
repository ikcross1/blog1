package com.nnxy.blog.entity;

import java.io.Serializable;

/**
 * (TPicture)实体类
 *
 * @author makejava
 * @since 2020-08-15 11:49:01
 */
public class TPicture implements Serializable {
    private static final long serialVersionUID = -97664794327983583L;

    private Long id;

    private String pictureaddress;

    private String picturedescription;

    private String picturename;

    private String picturetime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPictureaddress() {
        return pictureaddress;
    }

    public void setPictureaddress(String pictureaddress) {
        this.pictureaddress = pictureaddress;
    }

    public String getPicturedescription() {
        return picturedescription;
    }

    public void setPicturedescription(String picturedescription) {
        this.picturedescription = picturedescription;
    }

    public String getPicturename() {
        return picturename;
    }

    public void setPicturename(String picturename) {
        this.picturename = picturename;
    }

    public String getPicturetime() {
        return picturetime;
    }

    public void setPicturetime(String picturetime) {
        this.picturetime = picturetime;
    }

}