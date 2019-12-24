package com.contribute.demo.service;

import com.contribute.demo.pojo.Account;

/**
 * @ClassName : AccountService
 * @Description : TODO 对用户账户和信息的各种处理
 * @Author : niran
 * @Date : 2019/12/24
 **/

public interface AccountService {

    Account findByUsername(String username);
}
