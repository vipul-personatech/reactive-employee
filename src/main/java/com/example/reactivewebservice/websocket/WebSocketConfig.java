package com.example.reactivewebservice.websocket;


import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;

@Configuration
public class WebSocketConfig {

  @Bean
  public HandlerMapping webSocketHandlerMapping(MyWebSocketHandler handler) {
    Map<String, WebSocketHandler> map = new HashMap<>();
    map.put("/ws/employee/updates", handler);

    return new SimpleUrlHandlerMapping(map, -1);
  }

  @Bean
  public WebSocketHandlerAdapter handlerAdapter() {
    return new WebSocketHandlerAdapter();
  }
}

