package com.example.reactivewebservice.config;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import com.example.reactivewebservice.utils.CountGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Configuration
class SseRouter {

  @Bean
  RouterFunction<ServerResponse> routes() {
    return route() //
        .GET("/sse/{count}", this::handleSse) //
        .build();
  }

  Mono<ServerResponse> handleSse(ServerRequest r) {
    var countPathVariable = Integer.parseInt(r.pathVariable("count"));

    Flux<String> publisher =
        CountGenerator.generate(countPathVariable)
            .doOnComplete(() -> System.out.println("Completed"));

    return ServerResponse //
        .ok() //
        .contentType(MediaType.TEXT_EVENT_STREAM).body(publisher, String.class);
  }
}
