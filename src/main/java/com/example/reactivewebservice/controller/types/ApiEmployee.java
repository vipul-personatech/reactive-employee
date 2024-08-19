package com.example.reactivewebservice.controller.types;

import com.example.reactivewebservice.data.Employee;

public class ApiEmployee {

  private Long id;

  private String name;

  public ApiEmployee(Employee employee) {
    this.id = employee.getId();
    this.name = employee.getName().toUpperCase();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
