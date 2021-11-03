package com.stream_rabbitmq.controller;

import com.stream_rabbitmq.service.MessageProvider;
import com.stream_rabbitmq.service.MySourceSend;
import com.stream_rabbitmq.service.ProducerRunner;
import com.stream_rabbitmq.service.RocketmqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hoob
 */
@RestController
public class SendController {

    @Autowired
    private MessageProvider messageProvider;
    @Autowired
    private ProducerRunner producerRunner;
    @Autowired
    private RocketmqProducer rocketmqProducer;
    @Autowired
    private MySourceSend mySourceSend;
    @GetMapping("sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }
    @GetMapping("sendMessage1")
    public String sendMessage1() throws Exception {
         producerRunner.run();
        return "success";
    }
    @GetMapping("sendMessage2")
    public String sendMessage2() throws Exception {
        rocketmqProducer.send("hoobtest");
        return "success";
    }
    @GetMapping("sendMessage3")
    public String sendMessage3() throws Exception {
        mySourceSend.MySourceSend();
        return "success";
    }
}
