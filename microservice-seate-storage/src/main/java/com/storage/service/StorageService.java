package com.storage.service;

import org.springframework.stereotype.Component;

/**
 * @author wen.jie
 * @Classname StorageService
 * @Description TODO
 * @Date 2020/9/9
 */
@Component
public interface StorageService {

    public void decrease(Long productId, Integer count);
}
