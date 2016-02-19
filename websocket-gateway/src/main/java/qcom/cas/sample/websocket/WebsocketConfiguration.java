package qcom.cas.sample.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import qcom.cas.sample.websocket.handler.DeviceDataHandler;

@Configuration
@EnableWebSocket
public class WebsocketConfiguration implements WebSocketConfigurer {

    @Autowired
    private DeviceDataHandler deviceDataHandler;

    public void registerWebSocketHandlers( WebSocketHandlerRegistry registry ) {
        registry.addHandler(deviceDataHandler, "/device").setAllowedOrigins("*");

    }

}
