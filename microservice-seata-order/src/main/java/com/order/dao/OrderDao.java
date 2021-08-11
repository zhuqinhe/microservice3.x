package com.order.dao;

import com.order.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wen.jie
 * @Classname OrderDao
 * @Description TODO
 * @Date 2020/9/9
 */
@Mapper
public interface OrderDao {
    void create(Order order);
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
