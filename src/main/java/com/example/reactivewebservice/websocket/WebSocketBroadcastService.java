package com.example.reactivewebservice.websocket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;

@Component
public class WebSocketBroadcastService {

  private final CopyOnWriteArrayList<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
  private final ObjectMapper objectMapper = new ObjectMapper(); // Use Jackson to serialize objects

  // Add new WebSocket session
  public void addSession(WebSocketSession session) {
    sessions.add(session);
  }

  // Remove WebSocket session
  public void removeSession(WebSocketSession session) {
    sessions.remove(session);
  }

  // Broadcast message to all connected clients
  public void broadcast(Object message) {
    sessions.forEach(session -> {
      try {
        WebSocketMessage webSocketMessage =
            session.textMessage(objectMapper.writeValueAsString(message));
        session.send(Flux.just(webSocketMessage)).subscribe();
      } catch (JsonProcessingException ignored) {

      }
    });
  }
}

