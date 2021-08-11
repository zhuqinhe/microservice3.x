package com.order.controller;

import com.order.model.Order;
import com.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wen.jie
 * @Classname OrdeController
 * @Description TODO
 * @Date 2020/9/9
 */
@Slf4j
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public Map createOrder(Order order){
        order=new Order(1l,1l,1l,1,new BigDecimal(99),1);
        orderService.create(order);
        Map<String,Object> result=new HashMap<>();
        result.put("code",200);
        result.put("message","创建成功!");
        return result;
    }
}
