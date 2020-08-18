package com.nnxy.blog.dao;

import com.nnxy.blog.entity.FirstPageBlog;
import com.nnxy.blog.entity.TType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.lang.reflect.Type;
import java.util.List;

/**
 * (TType)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-11 10:20:30
 */
@Mapper
public interface TTypeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TType queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TType> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tType 实例对象
     * @return 对象列表
     */
    List<TType> queryAll(TType tType);

    /**
     * 新增数据
     *
     * @param tType 实例对象
     * @return 影响行数
     */
    int insert(TType tType);

    /**
     * 修改数据
     *
     * @param tType 实例对象
     * @return 影响行数
     */
    int update(TType tType);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);
    //查询所有分类
    List<TType> getAllType();
    ///根据分类名称查询分类
    Type getTypeByName(String name);

    int saveType(TType tType);
    //编辑分类
    int updateType(Type type);

    //查询所有分类
    List<TType> getAllTypeAndBlog();

}