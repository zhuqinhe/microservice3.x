package com.stream_rabbitmq.controller;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hoob
 */
@EnableBinding(Sink.class)
@RestController
public class ReceiveMessageListenerController {


    @StreamListener(value = Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消息:"+message.getPayload()+"--->consumer1");
    }

}
