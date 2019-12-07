package com.itheima.service.imp;

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author xkd
 * @create 2019-12-05 23:04
 * 账户的业务层实现类
 *
 * 曾经的XML配置
 *      <bean id="accountService" class="com.itheima.service.imp.AccountServiceIml"
 *              scope="" init-method="" destroy-method="">
 *           <property name="" value="" ref=""></property>
 *      </bean>
 *
 * 注解：
 *      1.用于创建对象的
 *          作用和在XML配置文件中编写一个<bean>标签实现的功能是一样的
 *          @Component：
 *              作用：用于把当前类对象存入spring容器中
 *              属性：
 *                  value：用于指定bean的id。当我们不写时，他的默认值是当前类名，且首字母改小写
 *          @Controller:   一般都用在表现层
 *          @Service:      一般用在业务层
 *          @Repository:   一般用于持久层
 *             以上三个注解他们的作用和属性与Component是一模一样，
 *             他们三个是spring框架为我们提供明确的三层使用的注解，是我们的三层对象更加清晰
 *
 *      2.用于注入数据的
 *          作用和在XML配置文件中的bean标签中写一个<property>标签的作用是一样的
 *          @Autowired:
 *              作用：自动按照类型注入，只要容器中有位移的一个bean对象类型和要注入的变量类型匹配，就可以注入成功
 *                    如果ioc容器中没有任何bean的类型和要注入的变量类型匹配，则报错。
 *                    如果ioc容器中有多个匹配时，就会根据变量名称匹配，有相同的则创建该类型对象，没有则报错（这就需要@Qualifier注解了）
 *              出现位置：
 *                  可以是成员变量上，也可以是方法上
 *              细节：
 *                  在使用注解注入时set方法就不是必须的了
 *          @Qualifier：
 *              作用：在按照类中注入的基础之上再按照名称注入。它在给类成员变量注入时不能单独使用，但是在给方法参数注入时可以
 *              属性：
 *                  value：用于指定注入bean的id
 *          @Resource:(一个顶俩)
 *              作用：直接按照bean的id注入，他可以独立使用
 *              属性：
 *                  name：用来指定bean的id
 *            以上三个注解都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现。
 *            另外，集合类型的注入只能通过XML来实现。
 *          @value：
 *              作用：用于注入基本类型和String类型的数据
 *              属性：
 *                  value：用于指定数据的值，它可以使用spring中的SpEL（也就是spring中的EL表达式）
 *                          SpEL的写法：${表达式}
 *
 *      3.用于改变作用范围的
 *          作用和bean标签中使用scope属性实现的功能是一样的
 *          @Scope：
 *              作用：用于指定bean的作用范围
 *              属性：
 *                  value：指定范围的取值。常用取值：singleton（单例，默认），prototype（多例）
 *
 *      4.和生命周期相关的     了解即可
 *          作用和在bean标签中使用init-method和destroy-method的作用是一样的
 *          @PreDestroy：
 *              作用：用于指定销毁方法
 *          @PostConstructor:
 *              作用：用于指定初始化方法
 */

@Component(value = "accountService")
@Scope(value = "singleton")
public class AccountServiceIml implements IAccountService {

//    @Autowired
//    @Qualifier(value = "accountDao1")
    @Resource(name = "accountDao2")
    private IAccountDao accountDao;

    @PostConstruct
    public void inti(){
        System.out.println("初始化方法执行了");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("销毁方法执行了");
    }

    public void saveAccount(){
        accountDao.saveAccount();
    }
}
