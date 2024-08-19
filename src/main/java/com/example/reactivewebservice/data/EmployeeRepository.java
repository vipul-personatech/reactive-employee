package com.example.reactivewebservice.data;

import java.util.UUID;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {

  Flux<Employee> findByNameEqualsIgnoreCase(String name);
}
