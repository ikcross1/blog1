package com.nnxy.blog.service;

import com.nnxy.blog.entity.TFriend;

import java.util.List;

/**
 * (TFriend)表服务接口
 *
 * @author makejava
 * @since 2020-08-15 09:32:33
 */
public interface TFriendService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TFriend queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TFriend> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tFriend 实例对象
     * @return 实例对象
     */
    TFriend insert(TFriend tFriend);

    /**
     * 修改数据
     *
     * @param tFriend 实例对象
     * @return 实例对象
     */
    TFriend update(TFriend tFriend);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    List<TFriend> getAllFriendLinks();

    int saveFriendLink(TFriend friend);

    int updateFriendsLinks(TFriend tFriend);

    List<TFriend> listFriendLink();
}