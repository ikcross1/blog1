package com.nnxy.blog.dao;

import com.nnxy.blog.entity.TFriend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TFriend)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-15 09:32:32
 */
@Mapper
public interface TFriendDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TFriend queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TFriend> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tFriend 实例对象
     * @return 对象列表
     */
    List<TFriend> queryAll(TFriend tFriend);

    /**
     * 新增数据
     *
     * @param tFriend 实例对象
     * @return 影响行数
     */
    int insert(TFriend tFriend);

    /**
     * 修改数据
     *
     * @param tFriend 实例对象
     * @return 影响行数
     */
    int update(TFriend tFriend);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    List<TFriend> getAllFriendLinks();

    int saveFriendLink(TFriend friend);

    int updateFriendsLinks(TFriend tFriend);

    List<TFriend> listFriendLink();
}