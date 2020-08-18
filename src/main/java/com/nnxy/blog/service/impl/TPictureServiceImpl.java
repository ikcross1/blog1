package com.nnxy.blog.service.impl;

import com.nnxy.blog.dao.TPictureDao;
import com.nnxy.blog.entity.TPicture;
import com.nnxy.blog.service.TPictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TPicture)表服务实现类
 *
 * @author makejava
 * @since 2020-08-15 11:49:02
 */
@Service("tPictureService")
public class TPictureServiceImpl implements TPictureService {
    @Resource
    private TPictureDao tPictureDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TPicture queryById(Long id) {
        return this.tPictureDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TPicture> queryAllByLimit(int offset, int limit) {
        return this.tPictureDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tPicture 实例对象
     * @return 实例对象
     */
    @Override
    public TPicture insert(TPicture tPicture) {
        this.tPictureDao.insert(tPicture);
        return tPicture;
    }

    /**
     * 修改数据
     *
     * @param tPicture 实例对象
     * @return 实例对象
     */
    @Override
    public TPicture update(TPicture tPicture) {
        this.tPictureDao.update(tPicture);
        return this.queryById(tPicture.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tPictureDao.deleteById(id) > 0;
    }

    @Override
    public List<TPicture> getAllPictures() {
        return tPictureDao.getAllPictures();
    }

    @Override
    public int savePictures(TPicture tPicture) {
        return tPictureDao.savePictures(tPicture);
    }

    @Override
    public int updatePicture(TPicture tPicture) {
        return tPictureDao.updatePicture(tPicture);
    }

    @Override
    public List<TPicture> listPicture() {
        return tPictureDao.listPicture();
    }
}