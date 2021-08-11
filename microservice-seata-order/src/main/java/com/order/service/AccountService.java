package com.order.service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author wen.jie
 * @Classname AccountService
 * @Description TODO
 * @Date 2020/9/9
 */
@Component
@FeignClient(value="seata-account")
public interface AccountService {

    @PostMapping("/account/decrease")
    Map<String,Object> decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

}
