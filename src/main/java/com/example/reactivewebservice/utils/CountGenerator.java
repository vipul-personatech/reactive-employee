package com.example.reactivewebservice.utils;


import reactor.core.publisher.Flux;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicLong;

public class CountGenerator {

  public static Flux<String> generate(int c) {
    return generate().take(c);
  }

  public static Flux<String> generate() {
    return doGenerateCountAndStrings().map(CountAndString::message);
  }

  private static Flux<CountAndString> doGenerateCountAndStrings() {
    var counter = new AtomicLong();
    return Flux
        .interval(Duration.ofSeconds(1))
        .map(i -> new CountAndString(counter.incrementAndGet()));
  }
}

record CountAndString(String message, long count) {

  CountAndString(long count) {
    this("# " + count, count);
  }
}
