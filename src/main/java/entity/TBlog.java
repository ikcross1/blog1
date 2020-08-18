package entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (TBlog)实体类
 *
 * @author makejava
 * @since 2020-08-10 16:04:50
 */
public class TBlog implements Serializable {
    private static final long serialVersionUID = 201980414227824129L;

    private Long id;

    private Object appreciation;

    private Object commentabled;

    private Object content;

    private Date createTime;

    private String description;

    private String firstPicture;

    private String flag;

    private Object published;

    private Object recommend;

    private Object shareStatement;

    private String title;

    private Date updateTime;

    private Integer views;

    private Long typeId;

    private Long userId;

    private Integer commentCount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(Object appreciation) {
        this.appreciation = appreciation;
    }

    public Object getCommentabled() {
        return commentabled;
    }

    public void setCommentabled(Object commentabled) {
        this.commentabled = commentabled;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Object getPublished() {
        return published;
    }

    public void setPublished(Object published) {
        this.published = published;
    }

    public Object getRecommend() {
        return recommend;
    }

    public void setRecommend(Object recommend) {
        this.recommend = recommend;
    }

    public Object getShareStatement() {
        return shareStatement;
    }

    public void setShareStatement(Object shareStatement) {
        this.shareStatement = shareStatement;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

}