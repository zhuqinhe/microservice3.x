package com.order.service;

import com.order.dao.OrderDao;
import com.order.model.Order;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wen.jie
 * @Classname OrderServiceImpl
 * @Description TODO
 * @Date 2020/9/9
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private AccountService accountService;

    @Autowired
    private StorageService storageService;

    @Override
    @GlobalTransactional
    public void create(Order order) {
        log.info("---->开始新建订单");
        orderDao.create(order);
        log.info("---->订单微服务开始调用库存，做扣减");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("---->订单微服务开始调用账户，做扣减");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("---->修改订单状态");
        orderDao.update(order.getUserId(),0);
        log.info("下订单结束");
    }
}
