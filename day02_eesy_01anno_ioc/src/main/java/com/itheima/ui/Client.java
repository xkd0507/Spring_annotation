package com.itheima.ui;

import com.itheima.service.IAccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @create 2019-12-05 23:18
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {

        //1.获取核心容器对象
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");//在这创建对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");//为了能调用close方法，测试注解PreDestroy的执行

        //2.根据id获取bean对象
        IAccountService as = (IAccountService)ac.getBean("accountService");
        //IAccountService as2 = (IAccountService)ac.getBean("accountService");

//        System.out.println(as);
//        IAccountDao aDao = ac.getBean("accountDao",IAccountDao.class);
//        System.out.println(aDao);
        //System.out.println(as == as2);
        as.saveAccount();
        ac.close();
    }


}
