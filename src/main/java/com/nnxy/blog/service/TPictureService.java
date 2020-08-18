package com.nnxy.blog.service;

import com.nnxy.blog.entity.TPicture;

import java.util.List;

/**
 * (TPicture)表服务接口
 *
 * @author makejava
 * @since 2020-08-15 11:49:02
 */
public interface TPictureService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TPicture queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TPicture> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tPicture 实例对象
     * @return 实例对象
     */
    TPicture insert(TPicture tPicture);

    /**
     * 修改数据
     *
     * @param tPicture 实例对象
     * @return 实例对象
     */
    TPicture update(TPicture tPicture);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    List<TPicture> getAllPictures();

    int savePictures(TPicture tPicture);

    int updatePicture(TPicture tPicture);

    List<TPicture> listPicture();
}