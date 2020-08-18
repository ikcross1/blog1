package com.nnxy.blog.service.impl;

import com.nnxy.blog.dao.TFriendDao;
import com.nnxy.blog.entity.TFriend;
import com.nnxy.blog.service.TFriendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TFriend)表服务实现类
 *
 * @author makejava
 * @since 2020-08-15 09:32:33
 */
@Service("tFriendService")
public class TFriendServiceImpl implements TFriendService {
    @Resource
    private TFriendDao tFriendDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TFriend queryById(Long id) {
        return this.tFriendDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TFriend> queryAllByLimit(int offset, int limit) {
        return this.tFriendDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tFriend 实例对象
     * @return 实例对象
     */
    @Override
    public TFriend insert(TFriend tFriend) {
        this.tFriendDao.insert(tFriend);
        return tFriend;
    }

    /**
     * 修改数据
     *
     * @param tFriend 实例对象
     * @return 实例对象
     */
    @Override
    public TFriend update(TFriend tFriend) {
        this.tFriendDao.update(tFriend);
        return this.queryById(tFriend.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tFriendDao.deleteById(id) > 0;
    }

    @Override
    public List<TFriend> getAllFriendLinks() {
        return tFriendDao.getAllFriendLinks();
    }

    @Override
    public int saveFriendLink(TFriend friend) {
        return tFriendDao.saveFriendLink(friend);
    }

    @Override
    public int updateFriendsLinks(TFriend tFriend) {
        return tFriendDao.updateFriendsLinks(tFriend);
    }

    @Override
    public List<TFriend> listFriendLink() {
        return tFriendDao.listFriendLink();
    }
}