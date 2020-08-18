package com.nnxy.blog.dao;

import com.nnxy.blog.entity.TMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TMessage)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-11 11:33:08
 */
@Mapper
public interface TMessageDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TMessage queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TMessage> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tMessage 实例对象
     * @return 对象列表
     */
    List<TMessage> queryAll(TMessage tMessage);

    /**
     * 新增数据
     *
     * @param tMessage 实例对象
     * @return 影响行数
     */
    int insert(TMessage tMessage);

    /**
     * 修改数据
     *
     * @param tMessage 实例对象
     * @return 影响行数
     */
    int update(TMessage tMessage);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}