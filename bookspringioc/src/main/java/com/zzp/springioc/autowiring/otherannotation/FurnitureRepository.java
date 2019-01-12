package com.zzp.springioc.autowiring.otherannotation;

import org.springframework.stereotype.Repository;

@Repository("furnitureDao")
public class FurnitureRepository {

  public void saySomthing() {
    System.out.println("i am dao");
  }
}
