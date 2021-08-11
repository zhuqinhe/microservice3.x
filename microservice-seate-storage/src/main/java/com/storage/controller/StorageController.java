package com.storage.controller;

import com.storage.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wen.jie
 * @Classname OrdeController
 * @Description TODO
 * @Date 2020/9/9
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping("/storage/decrease")
    public Map decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count){
        storageService.decrease(productId, count);
        Map<String,Object> result=new HashMap<>();
        result.put("code",200);
        result.put("message","扣减库存成功!");
        return result;
    }

}
