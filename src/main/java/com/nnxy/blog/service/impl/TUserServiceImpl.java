package com.nnxy.blog.service.impl;

import com.nnxy.blog.dao.TUserDao;
import com.nnxy.blog.entity.TUser;
import com.nnxy.blog.service.TUserService;
import com.nnxy.blog.utils.MD5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TUser)表服务实现类
 *
 * @author makejava
 * @since 2020-08-08 17:58:31
 */
@Service("tUserService")
public class TUserServiceImpl implements TUserService {
    @Resource
    private TUserDao tUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TUser queryById(Long id) {
        return this.tUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TUser> queryAllByLimit(int offset, int limit) {
        return this.tUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tUser 实例对象
     * @return 实例对象
     */
    @Override
    public TUser insert(TUser tUser) {
        this.tUserDao.insert(tUser);
        return tUser;
    }

    /**
     * 修改数据
     *
     * @param tUser 实例对象
     * @return 实例对象
     */
    @Override
    public TUser update(TUser tUser) {
        this.tUserDao.update(tUser);
        return this.queryById(tUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tUserDao.deleteById(id) > 0;
    }

    @Override
    public List<TUser> selectAll() {
        return tUserDao.selectAll();
    }

    @Override
    public TUser checkUser(String username, String password) {
        TUser user = tUserDao.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}