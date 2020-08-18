package com.nnxy.blog.service.impl;

import com.nnxy.blog.dao.TMessageDao;
import com.nnxy.blog.entity.TMessage;
import com.nnxy.blog.service.TMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TMessage)表服务实现类
 *
 * @author makejava
 * @since 2020-08-11 11:33:09
 */
@Service("tMessageService")
public class TMessageServiceImpl implements TMessageService {
    @Resource
    private TMessageDao tMessageDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TMessage queryById(Long id) {
        return this.tMessageDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TMessage> queryAllByLimit(int offset, int limit) {
        return this.tMessageDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tMessage 实例对象
     * @return 实例对象
     */
    @Override
    public TMessage insert(TMessage tMessage) {
        this.tMessageDao.insert(tMessage);
        return tMessage;
    }

    /**
     * 修改数据
     *
     * @param tMessage 实例对象
     * @return 实例对象
     */
    @Override
    public TMessage update(TMessage tMessage) {
        this.tMessageDao.update(tMessage);
        return this.queryById(tMessage.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tMessageDao.deleteById(id) > 0;
    }
}