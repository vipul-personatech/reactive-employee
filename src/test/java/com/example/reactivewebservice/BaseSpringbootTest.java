package com.example.reactivewebservice;

import com.github.javafaker.Faker;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseSpringbootTest {

  public static final Faker FAKER = Faker.instance();
}
