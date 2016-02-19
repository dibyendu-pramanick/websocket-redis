package qcom.cas.sample.redis.publisher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisPublisher {

    private final RedisTemplate<String, Object> template;

    @Autowired
    public RedisPublisher(final RedisTemplate<String, Object> template) {
        this.template = template;
    }

    public void publish( String topic, String message ) {
        template.convertAndSend(topic, message);
    }

}
