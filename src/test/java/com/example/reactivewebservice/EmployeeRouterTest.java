package com.example.reactivewebservice;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

public class EmployeeRouterTest extends BaseSpringbootTest {

  // Spring Boot will create a `WebTestClient` for you,
  // already configure and ready to issue requests against "localhost:RANDOM_PORT"
  @Autowired
  private WebTestClient webTestClient;

  @Test
  public void testHello() {
//    webTestClient
//        // Create a GET request to test an endpoint
//        .get().uri("/hello")
//        .accept(MediaType.APPLICATION_JSON)
//        .exchange()
//        // and use the dedicated DSL to test assertions against the response
//        .expectStatus().isOk()
//        .expectBody(Greeting.class).value(greeting -> {
//          assertThat(greeting.getMessage()).isEqualTo("Hello, Spring!");
//        });
  }
}
