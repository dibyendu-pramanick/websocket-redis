package qcom.cas.sample.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import qcom.cas.sample.redis.configuration.service.JedisConnectionFactoryService;
import qcom.cas.sample.websocket.redis.subscriber.RedisMessageListener;
import qcom.cas.sample.websocket.service.SessionHandlerService;

@Configuration
public class RedisSubscriberConfiguration {

    @Value("${redis.topic}")
    private String topic;

    @Autowired
    private JedisConnectionFactoryService jedisConnectionFactoryService;

    @Autowired
    private SessionHandlerService sessionHandlerService;

    @Bean
            MessageListenerAdapter messageListener() {
        return new MessageListenerAdapter(new RedisMessageListener(sessionHandlerService));
    }

    @Bean
            RedisMessageListenerContainer redisContainer() {
        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();

        container.setConnectionFactory(jedisConnectionFactoryService.getJedisConnectionFactory());
        container.addMessageListener(messageListener(), new PatternTopic(topic));

        return container;
    }
}
