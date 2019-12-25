package com.contribute.demo.tools;

import com.contribute.demo.pojo.Account;

/**
 * @ClassName : LoginHolder
 * @Description : TODO 保存登录信息
 * @Author : niran
 * @Date : 2019/12/24
 **/

public class LoginHolder {
    private static final ThreadLocal<Account> accountThreadLocal = new ThreadLocal<Account>();

    public static void add(Account account){
        accountThreadLocal.set(account);
    }


    public static Account getAccount(){
        return accountThreadLocal.get();
    }

    public static void remove(){
        accountThreadLocal.remove();
    }

}
