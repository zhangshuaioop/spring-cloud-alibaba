package com.example.commoncomponets.base;

import com.github.pagehelper.Page;

import java.util.List;


/**
 * DAO基础接口
 */
public interface BaseMapper<T> {


    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加
     *
     * @param t
     * @return
     */
    int insertSelective(T t);

    /**
     * 根据id获取对象
     *
     * @param id
     * @return
     */
    T selectByPrimaryKey(Long id);


    /**
     * 更新
     *
     * @param t
     * @return
     */
    int updateByPrimaryKeySelective(T t);


    /**
     * 查询所有数据
     *
     * @return
     */
    List<T> selectAll(T t);

    /**
     * 分页查询
     *
     * @param t
     * @return
     */
    Page<T> findPage(T t);

    /**
     * 批量删除
     *
     * @param ids
     */
    void delete(Long[] ids);


    /**
     * 批量删除
     *
     * @param ids
     */
    void deletes(String ids);
}
