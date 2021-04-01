package com.example.firstone.mq;

import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

//@Component
//@RocketMQMessageListener(consumerGroup = "MyConsumerGroup",topic = "testTopic",consumeMode = ConsumeMode.CONCURRENTLY )
//public class SpringConsumer implements RocketMQListener<String> {
//    @Override
//    public void onMessage(String message) {
//
//    }
//}
