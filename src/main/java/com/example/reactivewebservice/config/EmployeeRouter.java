package com.example.reactivewebservice.config;

import com.example.reactivewebservice.service.EmployeeHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration(proxyBeanMethods = false)
public class EmployeeRouter {

  @Bean
  public RouterFunction<ServerResponse> route(EmployeeHandler employeeHandler) {

    return RouterFunctions
        .route()
        .POST("/employee/{name}", employeeHandler::save)
        .GET("/employee/findById/{id}", employeeHandler::findById)
        .build();
  }
}
