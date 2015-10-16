package spring.tutorial.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by Robert on 10/15/2015.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/game");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/nextTurn").withSockJS();
        registry.addEndpoint("/joinGame").withSockJS();
        registry.addEndpoint("/getAllRooms").withSockJS();
        registry.addEndpoint("/createNewGame/{roomId}").withSockJS();
        registry.addEndpoint("/rematch").withSockJS();
        registry.addEndpoint("/createNewUser").withSockJS();
    }
}
