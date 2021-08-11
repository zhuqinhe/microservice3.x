package com.acount.service;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author wen.jie
 * @Classname StorageService
 * @Description TODO
 * @Date 2020/9/9
 */
@Component
public interface AccountService {

    public void decrease(Long productId, BigDecimal money);
}
