package com.stream_rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

/**
 * @author hoob
 */
@SpringBootApplication
//@EnableBinding({ Source.class, Sink.class })
public class StreamMQProviderApp1 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQProviderApp1.class,args);
    }
}
