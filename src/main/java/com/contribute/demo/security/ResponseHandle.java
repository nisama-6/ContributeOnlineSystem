package com.contribute.demo.security;

import javax.servlet.http.HttpServletResponse;

public class ResponseHandle {
    public static HttpServletResponse responseHandle(HttpServletResponse response ){
        response.setStatus(200);
        response.setContentType("application/json;charset=UTF-8");
//        response.setHeader("Access-Control-Allow-Origin","http://www.niran.vip");
        response.setHeader("Access-Control-Allow-Origin","http://localhost:8080");
        response.setHeader("Access-Control-Expose-Headers","*");
        response.setHeader("Access-Control-Allow-Credentials","true");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Allow-Methods","GET,POST,OPTIONS,PUT,DELETE");
        return response;
    }
}
