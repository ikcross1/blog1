package com.nnxy.blog.dao;

import com.nnxy.blog.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TBlog)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-10 16:05:30
 */
@Mapper
public interface TBlogDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TBlog queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TBlog> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tBlog 实例对象
     * @return 对象列表
     */
    List<TBlog> queryAll(TBlog tBlog);

    /**
     * 新增数据
     *
     * @param tBlog 实例对象
     * @return 影响行数
     */
    int insert(TBlog tBlog);

    /**
     * 修改数据
     *
     * @param tBlog 实例对象
     * @return 影响行数
     */
    int update(TBlog tBlog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    int saveBlog(TBlog tBlog);

    List<BlogQuery> getAllBlog();

    ShowBlog getBlogById(Long id);

    int updateBlog(ShowBlog showBlog);

    List<FirstPageBlog> getAllFirstPageBlog();

    List<RecommendBlog> getRecommendedBlog();

    int getBlogTotal();

    int getBlogViewTotal();

    int getBlogCommentTotal();

    int getBlogMessageTotal();
    //查询博客详情
    DetailedBlog getDetailedBlog(Long id);
    //文章访问更新
    void updateViews(Long id);
    //根据博客id查询出评论数量
    void getCommentCountById(Long id);
    //根据TypeId查询博客列表，显示在分类页面
    List<FirstPageBlog> getByTypeId(Long typeId);

}