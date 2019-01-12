package com.zzp.springioc.xml;

import java.util.List;

public class PersonSuccess implements Success {

  private UserDao userDao;
  private List<String> skillList;

  public PersonSuccess() {
  }

  /**
   * 构造器方法需要这两个对象，这里我还不知道如果List是对象，
   * 而对象又需要引用的话，这种情况下怎么处理
   * @param userDao
   * @param skillList
   */
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
