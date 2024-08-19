package com.example.reactivewebservice.service;

import com.example.reactivewebservice.controller.types.ApiEmployee;
import com.example.reactivewebservice.data.Employee;
import com.example.reactivewebservice.data.EmployeeRepository;
import com.example.reactivewebservice.websocket.WebSocketBroadcastService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;
  @Autowired
  private WebSocketBroadcastService broadcastService;

  public Mono<Employee> findById(Long id) {
    return employeeRepository.findById(id);
  }

  public Flux<Employee> findByName(String name) {
    return employeeRepository.findByNameEqualsIgnoreCase(name);
  }

  public Mono<Employee> save(String name) {
    return employeeRepository.save(new Employee(name));
  }

  public Mono<Employee> update(Long id, String updatedName) {
    return
        employeeRepository.findById(id).flatMap(employee -> {
          employee.setName(updatedName);
          broadcastService.broadcast(new ApiEmployee(employee));
          return employeeRepository.save(employee);
        });
  }

  public Flux<Employee> findAll() {
    return employeeRepository.findAll();
  }
}
