package com.example.reactivewebservice.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

@Component
public class MyWebSocketHandler implements WebSocketHandler {

  private final WebSocketBroadcastService webSocketBroadcastService;

  @Autowired
  public MyWebSocketHandler(WebSocketBroadcastService webSocketBroadcastService) {
    this.webSocketBroadcastService = webSocketBroadcastService;
  }

  @Override
  public Mono<Void> handle(WebSocketSession session) {
    webSocketBroadcastService.addSession(session);
    return session.receive()
        .doFinally(signalType -> webSocketBroadcastService.removeSession(session)).then();

  }
}
