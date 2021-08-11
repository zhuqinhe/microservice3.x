package com.wj.springcloud.controller;

import com.wj.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wen.jie
 * @Classname SendController
 * @Description TODO
 * @Date 2020/9/7
 */
@RestController
public class SendController {

    @Autowired
    private IMessageProvider messageProvider;

    @GetMapping("sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }
}
