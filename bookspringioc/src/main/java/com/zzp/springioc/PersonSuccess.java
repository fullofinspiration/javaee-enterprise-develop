package com.zzp.springioc;

import java.util.List;

public class PersonSuccess implements Success {

  private UserDao userDao;
  private List<String> skillList;

  public PersonSuccess() {
  }

  public PersonSuccess(UserDao userDao, List<String> skillList) {
    this.userDao = userDao;
    this.skillList = skillList;
  }

  //如果在xml中使用“property name=”会根据name自动寻找set#Name方法
  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }

  public void testWhetherHasUser() {
    userDao.say();
  }
}
