package com.stream_rabbitmq.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
//定义消息的推送管道，多个的时候   自己封装
public interface MySource {
    @Output("output1")
    MessageChannel output1();
    @Output("output2")
    MessageChannel output2();
}