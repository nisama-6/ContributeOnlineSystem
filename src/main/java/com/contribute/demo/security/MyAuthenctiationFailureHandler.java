package com.contribute.demo.security;
import com.alibaba.fastjson.JSON;
import com.contribute.demo.tools.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("myAuthenctiationFailureHandler")
public class MyAuthenctiationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        logger.info("进入认证失败处理类");
//        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setStatus(200);
        ResponseHandle.responseHandle(response);
        System.out.println(exception.getLocalizedMessage());
        response.getWriter().write( JSON.toJSONString(new Result(false,exception.getLocalizedMessage())));
        System.out.println(JSON.toJSONString(new Result(false,exception.getLocalizedMessage())));
//        response.getWriter().write(objectMapper.writeValueAsString(exception));
    }
}