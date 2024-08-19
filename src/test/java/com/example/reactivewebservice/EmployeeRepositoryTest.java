package com.example.reactivewebservice;

import com.example.reactivewebservice.data.Employee;
import com.example.reactivewebservice.data.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class EmployeeRepositoryTest extends BaseSpringbootTest {

  @Autowired
  private WebTestClient client;

  @Autowired
  private EmployeeRepository employeeRepository;

  @Test
  @Ignore
  // create some test data
  public void saveMany() {

    List<Employee> employees = new ArrayList<>();
    for (int i = 0; i < 50; i++) {
      employees.add(new Employee(FAKER.funnyName().name()));
    }
    Flux<Employee> employeeFlux = employeeRepository.saveAll(employees);
    StepVerifier.create(employeeFlux).expectNextCount(50).verifyComplete();
  }
}
