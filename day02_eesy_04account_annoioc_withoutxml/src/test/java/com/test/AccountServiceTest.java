package com.test;

import com.domain.Account;
import com.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试，测试我们的配置
 * Spring整合junit的配置：
 *      1、导入spring整合junit的jar(坐标)包
 *      2、使用Junit提供的一个注解把原有的main方法替换成spring提供的
 *          @RunWith
 *      3、告知spring的运行期，spring的ioc创建是基于xml还是注解的，并说明位置
 *          @ContextConfiguration
 *              locations：指定xml文件的位置。加上classpath关键字，表示在类路径下
 *              classes：指定注解类坐在位置
 *    当我们使用spring5.x版本的时候，要求junit的jar必须是4.12及以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private IAccountService as;
    //private ApplicationContext ac;
    /*@Before
    public void init(){
        //1.获取容器
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.得到业务层对象
        as = ac.getBean("accountService",IAccountService.class);
    }*/

    @Test
    public void testFindAll() {
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for(Account account : accounts){
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne() {
        //3.执行方法
        Account account = as.findAccountById(5);
        System.out.println(account);
    }
    @Test
    public void testSave() {

        Account account = new Account();
        account.setName("ddd");
        account.setMoney( 1500.0f);
        //3.执行方法
        as.saveAccount(account);
    }
    @Test
    public void testUpdate() {
        //3.执行方法
        Account account = as.findAccountById(5);
        account.setMoney(2000f);
        as.updateAccount(account);

    }
    @Test
    public void testDelete() {
        //3.执行方法
        as.deleteAccount(5);

    }
}
