package com.zzp.springioc;

import com.zzp.springioc.autowiring.FurnitureConfig;
import com.zzp.springioc.autowiring.Table;
import com.zzp.springioc.autowiring.otherannotation.FurnitureController;
import com.zzp.springioc.xml.PersonSuccess;
import com.zzp.springioc.xml.Success;
import com.zzp.springioc.xml.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//ById其实就是name字段，但是我不了解的是如果id和name同时声明且值不同，那结果会发生什么
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

  /**
   * 测试controller，service，repository，resource，autowired注解，注意的是，这里如果声明了name，可以按照name引入，
   * 否则的话就是按照类型引入
   */
  @Test
  public void testAnnotation() {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
        FurnitureConfig.class);
    FurnitureController furnitureController = (FurnitureController) applicationContext.getBean("furnitureController");
    furnitureController.saySomething();
  }
}
