package com.nnxy.blog.service;

import com.nnxy.blog.entity.TType;

import java.lang.reflect.Type;
import java.util.List;

/**
 * (TType)表服务接口
 *
 * @author makejava
 * @since 2020-08-11 10:20:30
 */
public interface TTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TType queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TType> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tType 实例对象
     * @return 实例对象
     */
    TType insert(TType tType);

    /**
     * 修改数据
     *
     * @param tType 实例对象
     * @return 实例对象
     */
    TType update(TType tType);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);
    //查询所有分类
    List<TType> getAllType();

    Type getTypeByName(String name);
    //新增分类
    int saveType(TType tType);
    //编辑分类
    int updateType(Type type);
    //查询所有分类
    List<TType> getAllTypeAndBlog();
}