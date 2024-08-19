package com.example.reactivewebservice.service;

import com.example.reactivewebservice.data.Employee;
import com.example.reactivewebservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class EmployeeHandler {

  @Autowired
  private EmployeeService employeeService;

  public Mono<ServerResponse> save(ServerRequest request) {
    return ServerResponse.ok()
        .body(BodyInserters.fromPublisher(employeeService.save(request.pathVariable(
            "name")), Employee.class));
  }

  public Mono<ServerResponse> findById(ServerRequest request) {
    return ServerResponse.ok().body(
        BodyInserters.fromPublisher(employeeService.findById(Long.parseLong(request.pathVariable(
            "id"))), Employee.class));
  }
}
