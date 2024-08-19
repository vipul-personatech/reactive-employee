package com.example.reactivewebservice.controller;

import com.example.reactivewebservice.controller.types.ApiEmployee;
import com.example.reactivewebservice.data.Employee;
import com.example.reactivewebservice.service.EmployeeService;
import com.example.reactivewebservice.websocket.WebSocketBroadcastService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping(value = "/employee/findByName/{name}")
  public Flux<Employee> findByName(@PathVariable String name) {
    return employeeService.findByName(name);
  }

  @GetMapping(value = "/employee/findAll")
  public Flux<ApiEmployee> findAll() {
    return employeeService.findAll().map(ApiEmployee::new);
  }

  @PostMapping("/employee/update/{id}")
  public Mono<Employee> update(@PathVariable Long id, @RequestBody String name) {
    return employeeService.update(id, name);
  }
}
