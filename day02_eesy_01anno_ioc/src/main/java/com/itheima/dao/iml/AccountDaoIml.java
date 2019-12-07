package com.itheima.dao.iml;

import com.itheima.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author xkd
 * @create 2019-12-05 23:14
 * 账户的持久层实现类
 *
 * 曾经的XML配置
 *    <bean id="accountDao" class="com.itheima.dao.iml.AccountDaoIml"></bean>
 */

@Repository(value = "accountDao1")
public class AccountDaoIml implements IAccountDao {

    public void saveAccount(){
        System.out.println("保存了账户11111");
    }
}
