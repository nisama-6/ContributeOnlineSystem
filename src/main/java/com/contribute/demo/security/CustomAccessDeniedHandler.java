package com.contribute.demo.security;

import com.alibaba.fastjson.JSON;
import com.contribute.demo.tools.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName : CustomAccessDeniedHandler
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/12/29
 **/
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        logger.info("进入过期处理");
        httpServletResponse.setContentType("application/json;charset=UTF-8");
//        response.setStatus(601);
        ResponseHandle.responseHandle(httpServletResponse);
        httpServletResponse.getWriter().write( JSON.toJSONString(new Result(false,"权限不足")));
    }
}
