package com.nnxy.blog.service.impl;

import com.nnxy.blog.dao.TBlogDao;
import com.nnxy.blog.entity.*;
import com.nnxy.blog.service.TBlogService;
import com.nnxy.blog.utils.MarkdownUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (TBlog)表服务实现类
 *
 * @author makejava
 * @since 2020-08-10 16:05:30
 */
@Service("tBlogService")
public class TBlogServiceImpl implements TBlogService {
    @Resource
    private TBlogDao tBlogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TBlog queryById(Long id) {
        return this.tBlogDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TBlog> queryAllByLimit(int offset, int limit) {
        return this.tBlogDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tBlog 实例对象
     * @return 实例对象
     */
    @Override
    public TBlog insert(TBlog tBlog) {
        this.tBlogDao.insert(tBlog);
        return tBlog;
    }

    /**
     * 修改数据
     *
     * @param tBlog 实例对象
     * @return 实例对象
     */
    @Override
    public TBlog update(TBlog tBlog) {
        this.tBlogDao.update(tBlog);
        return this.queryById(tBlog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tBlogDao.deleteById(id) > 0;
    }

    @Override
    public int saveBlog(TBlog tBlog) {
        tBlog.setCreateTime(new Date());
        tBlog.setUpdateTime(new Date());
        tBlog.setViews(0);
        tBlog.setCommentCount(0);
        return tBlogDao.saveBlog(tBlog);
    }

    @Override
    public List<BlogQuery> getAllBlog() {
        return tBlogDao.getAllBlog();
    }

    @Override
    public ShowBlog getBlogById(Long id) {
        return tBlogDao.getBlogById(id);
    }

    @Override
    public int updateBlog(ShowBlog showBlog) {
        showBlog.setUpdateTime(new Date());
        return tBlogDao.updateBlog(showBlog);
    }

    @Override
    public List<FirstPageBlog> getAllFirstPageBlog() {
        return tBlogDao.getAllFirstPageBlog();
    }

    @Override
    public List<RecommendBlog> getRecommendedBlog() {
        return tBlogDao.getRecommendedBlog();
    }

    @Override
    public int getBlogTotal() {
        return tBlogDao.getBlogTotal();
    }

    @Override
    public int getBlogViewTotal() {
        return tBlogDao.getBlogViewTotal();
    }

    @Override
    public int getBlogCommentTotal() {
        return tBlogDao.getBlogCommentTotal();
    }

    @Override
    public int getBlogMessageTotal() {
        return tBlogDao.getBlogMessageTotal();
    }

    @Override
    public DetailedBlog getDetailedBlog(Long id) {
        DetailedBlog detailedBlog = tBlogDao.getDetailedBlog(id);
        if (detailedBlog == null) {
           // throw new NotFoundException("该博客不存在");
        }
        String content = detailedBlog.getContent();
        detailedBlog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        //文章访问数量自增
        tBlogDao.updateViews(id);
        //文章评论数量更新
        tBlogDao.getCommentCountById(id);
        return detailedBlog;

    }

    @Override
    public List<FirstPageBlog> getByTypeId(Long typeId) {
        return tBlogDao.getByTypeId(typeId);
    }
}