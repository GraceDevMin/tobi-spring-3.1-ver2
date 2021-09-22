package com.tobi.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UseDaoTest {
    public static void main(String[] args) {
        ApplicationContext context =
                new GenericXmlApplicationContext("applicationContext.xml");

//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("daoContext.xml", UserDao.class);

//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(DaoFactory.class);

        // 동일! (com.tobi.dao.UserDao@65987993)
        UserDao dao3 = context.getBean("userDao", UserDao.class);
        UserDao dao4 = context.getBean("userDao", UserDao.class);

        // @Configuration 어노테이션을 추가하지 않고 Dacfactory를 직접 사용할 때 -> 동일성 X
//        DaoFactory factory = new DaoFactory();
//        UserDao dao1 = factory.userDao();
//        UserDao dao2 = factory.userDao();

        System.out.println(dao3);
        System.out.println(dao4);
        System.out.println(dao3==dao4); //true
    }
}
