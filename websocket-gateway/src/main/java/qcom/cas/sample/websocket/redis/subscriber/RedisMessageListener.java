package qcom.cas.sample.websocket.redis.subscriber;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import qcom.cas.sample.websocket.service.SessionHandlerService;

public class RedisMessageListener implements MessageListener {

    private SessionHandlerService sessionHandlerService;

    public RedisMessageListener() {
    }

    public RedisMessageListener(SessionHandlerService sessionHandlerService) {
        this.sessionHandlerService = sessionHandlerService;
    }

    public void onMessage( Message message, byte[] pattern ) {
        sessionHandlerService.sendMessage(message);
    }
}
