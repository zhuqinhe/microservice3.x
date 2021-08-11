package com.stream_rabbitmq.service;

import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;

@EnableBinding(MySource.class)
public class MySourceSend {
    @Autowired
    private MySource source;
    public void MySourceSend() throws Exception {
        source.output1().send(MessageBuilder.withPayload("output1").build());
        source.output2().send(MessageBuilder.withPayload("output2").build());
        sendWithTags("sendWithTags","tagStr" );
    }

    public void sendWithTags(String msg, String tag) {
        Message message = MessageBuilder.withPayload(msg)
                .setHeader(RocketMQHeaders.TAGS, tag)
                .build();
        source.output1().send(message);
    }
    /**
     * 发送对象
     * */
    public <T> void sendObject(T msg, String tag) {
        Message message = MessageBuilder.withPayload(msg)
                .setHeader(RocketMQHeaders.TAGS, tag)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build();
        source.output2().send(message);
    }
}
