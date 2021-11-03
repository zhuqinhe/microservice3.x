package com.stream_rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

/**
 * @author wen.jie
 * @Classname StreamMQMain8802
 * @Description TODO
 * @Date 2020/9/7
 */
@SpringBootApplication
//@EnableBinding({ Source.class, Sink.class })
public class StreamMQConsumer2App {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQConsumer2App.class,args);
    }
}
