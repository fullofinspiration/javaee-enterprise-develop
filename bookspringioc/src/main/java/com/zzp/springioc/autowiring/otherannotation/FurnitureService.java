package com.zzp.springioc.autowiring.otherannotation;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("furnitureServiceId")
public class FurnitureService {
  @Resource(name = "furnitureDao")
  private FurnitureRepository furnitureRepository;
  public void saySomething() {
    System.out.println("i am service");
    furnitureRepository.saySomthing();
  }

}
