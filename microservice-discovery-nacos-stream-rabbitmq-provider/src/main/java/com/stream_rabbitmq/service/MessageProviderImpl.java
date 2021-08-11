package com.wj.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.wj.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author wen.jie
 * @Classname MessageProvider
 * @Description TODO
 * @Date 2020/9/7
 */
@EnableBinding(Source.class)//定义消息的推送管道
public class MessageProvider implements IMessageProvider {

    @Autowired
    private MessageChannel output;

    @Override
    public String send() {
        String serial = IdUtil.simpleUUID();
        System.out.println(serial+"============");
        output.send(MessageBuilder.withPayload(serial).build());
        return serial;
    }
}
