package com.contribute.demo.security;

import com.alibaba.fastjson.JSON;
import com.contribute.demo.tools.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/*
自定义异地登陆处理
 */
@Component
public class AjaxSessionInformationExpiredStrategy implements SessionInformationExpiredStrategy {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        HttpServletResponse response = event.getResponse();
        logger.info("进入异地登陆处理");
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Expose-Headers","*");
        response.setHeader("Access-Control-Allow-Methods","GET，POST，OPTIONS，PUT，DELETE");
        response.setHeader("Access-Control-Allow-Credentials","true");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.getWriter().write( JSON.toJSONString(new Result(false,"异地登陆")));
//        response.getWriter().print(returnObj.toJSONString());
//        response.flushBuffer();
    }
}