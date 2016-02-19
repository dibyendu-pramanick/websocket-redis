package qcom.cas.sample.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import qcom.cas.sample.redis.configuration.service.JedisConnectionFactoryService;
import qcom.cas.sample.redis.service.RedisMessageListener;

@Configuration
public class RedisSubscriberConfiguration {

    @Autowired
    private JedisConnectionFactoryService jedisConnectionFactoryService;

    @Bean
            MessageListenerAdapter messageListener() {
        return new MessageListenerAdapter(new RedisMessageListener());
    }

    @Bean
            RedisMessageListenerContainer redisContainer() {
        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();

        container.setConnectionFactory(jedisConnectionFactoryService.getJedisConnectionFactory());
        container.addMessageListener(messageListener(), new PatternTopic("test*"));

        return container;
    }

}
