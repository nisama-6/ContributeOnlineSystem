package com.contribute.demo.service;

import com.contribute.demo.pojo.Account;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @ClassName : LoginMessageService
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/12/25
 **/

public interface LoginMessageService {

    Account getLoginAccount() throws IOException, ServletException;
}
