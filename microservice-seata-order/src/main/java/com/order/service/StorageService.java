package com.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author wen.jie
 * @Classname StorageService
 * @Description TODO
 * @Date 2020/9/9
 */
@Component
@FeignClient(value="seata-storage")
public interface StorageService {

    @PostMapping("/storage/decrease")
    Map decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
