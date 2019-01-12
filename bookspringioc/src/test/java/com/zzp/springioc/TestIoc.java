package com.zzp.springioc;

import com.zzp.springioc.autowiring.Furniture;
import com.zzp.springioc.autowiring.FurnitureConfig;
import com.zzp.springioc.autowiring.Table;
import com.zzp.springioc.autowiring.otherannotation.FurnitureController;
import javafx.scene.control.Tab;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoc {
  //测试带id的通过xml注入的bean
  @Test
  public void testXmlDIById() {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
        "ApplicationContext.xml");
    UserDao userDao = (UserDao) applicationContext.getBean("userDaoImpl");
    userDao.say();
  }

  @Test
  public void testDIObjToAnotherObjBySetMethod() {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
        "ApplicationContext.xml");
    Success success = (Success) applicationContext.getBean("personSuccess");
    success.testWhetherHasUser();
  }
  //测试是否会返回不同的对象
  @Test
  public void testDIPrototype() {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
        "ApplicationContext.xml");
    UserDao userDao = (UserDao) applicationContext.getBean("userDaoImplPrototype");
    System.out.println(userDao);
    UserDao userDao1 = (UserDao) applicationContext.getBean("userDaoImplPrototype");
    System.out.println(userDao1);
  }

  @Test
  public void testDIXmlList() {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
        "ApplicationContext.xml");
    PersonSuccess personSuccess = (PersonSuccess) applicationContext.getBean("personWithSkill");
    personSuccess.testWhetherHasUser();
  }
  @Test
  public void testAutoWiring() {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
        FurnitureConfig.class);
    Table table = (Table) applicationContext.getBean("table");
    System.out.println(table);
  }

  @Test
  public void testAnnotation() {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
        FurnitureConfig.class);
    FurnitureController furnitureController = (FurnitureController) applicationContext.getBean("furnitureController");
    furnitureController.saySomething();
  }
}
