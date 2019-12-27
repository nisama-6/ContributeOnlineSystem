package com.contribute.demo.service;

import com.contribute.demo.pojo.Account;
import com.contribute.demo.pojo.Usermessage;

/**
 * @ClassName : AccountService
 * @Description : TODO 对用户账户和信息的各种处理
 * @Author : niran
 * @Date : 2019/12/24
 **/

public interface AccountService {

    Account findByUsername(String username);


    Account editUserMessage(Usermessage msg);//编辑用户的个人资料


    Account regist(String username,String password1,String password2);//注册

    Boolean checkUsername(String username);//检查用户名是否可用
    String changePassword(String oldpassword,String password1,String password2);//修改密码1
}
