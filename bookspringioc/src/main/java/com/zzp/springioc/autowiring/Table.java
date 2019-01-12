package com.zzp.springioc.autowiring;

import org.springframework.stereotype.Component;

@Component
public class Table implements Furniture {
  private String name = "204";

  @Override
  public void saySomething() {
    System.out.println(name);
  }
}
