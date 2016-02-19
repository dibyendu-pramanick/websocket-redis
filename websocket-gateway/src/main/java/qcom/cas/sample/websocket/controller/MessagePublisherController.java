package qcom.cas.sample.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import qcom.cas.sample.redis.publisher.service.RedisPublisher;

@RestController
@RequestMapping("publish")
public class MessagePublisherController {

    @Autowired
    private RedisPublisher redisPublisher;

    @RequestMapping(value = "/{topic}/{message}")
    public void publish( @PathVariable String topic, @PathVariable String message ) {
        redisPublisher.publish(topic, message);
    }
}
