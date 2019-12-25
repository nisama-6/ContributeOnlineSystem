package com.contribute.demo.tools;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @ClassName : WebSocketConfig
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/11/12
 **/

@Configuration
@EnableWebSocketMessageBroker  //注解开启STOMP协议来传输基于代理的消息，此时控制器支持使用@MessageMapping
@MessageMapping
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/expert","/user");//topic用来广播，user用来实现p2p
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/webServer").setAllowedOrigins("*").withSockJS();
        registry.addEndpoint("/queueServer").withSockJS();//注册两个STOMP的endpoint，分别用于广播和点对点
    }
//    @Bean
//    public ServerEndpointExporter serverEndpointExporter(){
//        return new ServerEndpointExporter();
//    }


}