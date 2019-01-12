package com.zzp.springioc.xml;

public class UserDaoImpl implements UserDao {

  @Override
  public void say() {
    System.out.println("userDao say Hello world");
  }
}
