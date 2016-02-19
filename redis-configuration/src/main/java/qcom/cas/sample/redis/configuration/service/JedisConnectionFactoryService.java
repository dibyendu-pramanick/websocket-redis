package qcom.cas.sample.redis.configuration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Service;

@Service
public class JedisConnectionFactoryService {

    private JedisConnectionFactory jedisConnectionFactory;

    @Autowired
    public JedisConnectionFactoryService(JedisConnectionFactory jedisConnectionFactory) {
        this.jedisConnectionFactory = jedisConnectionFactory;
    }

    public JedisConnectionFactory getJedisConnectionFactory() {
        return this.jedisConnectionFactory;
    }

}
