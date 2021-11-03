package com.stream_rabbitmq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * @author hoob
 */
@EnableBinding(Source.class)//定义消息的推送管道，单个的时候
public class MessageProviderImpl implements MessageProvider {

    @Autowired
    private MessageChannel output;// 获取name为output的binding

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        System.out.println(serial+"---->provider");
        boolean tt=  output.send(MessageBuilder.withPayload(serial).build());
        return serial;
    }
}
