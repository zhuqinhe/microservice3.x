package com.storage.service;

import com.storage.dao.StorageDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wen.jie
 * @Classname OrderServiceImpl
 * @Description TODO
 * @Date 2020/9/9
 */
@Slf4j
@Service
public class StorageServiceImpl implements StorageService {


    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        //log.info("----> StorageService中扣减库存");
        storageDao.decrease(productId, count);
        //log.info("----> StorageService中扣减库存完成");
    }
}
