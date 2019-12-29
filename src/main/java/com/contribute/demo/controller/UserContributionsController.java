package com.contribute.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.contribute.demo.pojo.Account;
import com.contribute.demo.pojo.Contribution;
import com.contribute.demo.service.ContributionService;
import com.contribute.demo.service.LoginMessageService;
import com.contribute.demo.tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName : UserContributionsController
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/12/25
 **/


@RestController
@RequestMapping(value = "/user")
public class UserContributionsController {


    @Autowired
    ContributionService contributionService;

    @Autowired
    LoginMessageService loginMessageService;

    /**
     * 查询所有的稿件
     */
    @PreAuthorize("hasAnyAuthority('user')")
    @GetMapping(value = "/contributions")
    public Result list() throws IOException, ServletException {
        Account account=loginMessageService.getLoginAccount();
        List<Contribution> contributions= contributionService.findByAccountID(account.getId());
        return new Result(true, "",contributions);
    }

    @PreAuthorize("hasAnyAuthority('user')")
    @GetMapping(value = "/contributionsin7days")
    public Result getbydate() throws IOException, ServletException {
        return new Result(true,"ok",contributionService.findByUploadDateIn7Days());
    }


}
