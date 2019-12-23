package com.contribute.demo.controller;


import com.qiniu.util.Auth;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;

@RestController
@RequestMapping(value = "/token")
public class QiniuController {


    @RequestMapping(value = "",method= RequestMethod.GET)
    public String getToken() throws ServletException {
        String accessKey = "6F41PkcSjijohUiR9JkH2B52Be9sc5zqTEfmXCJ_";
        String secretKey = "YpMKsS4_QZgjdbCuEDzzFREAh0VNVyK4T_TEck3-";
        String bucket = "res";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        if(upToken != null){
            return  upToken;
        }
        throw new ServletException("获取token失败");
    }
}
