package com.zzp.springioc.autowiring.otherannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FurnitureController {

  @Autowired
  private FurnitureService furnitureService;
  public void saySomething() {
    System.out.println("i am controller");
    furnitureService.saySomething();
  }
}
