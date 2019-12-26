package com.contribute.demo.controller;

import com.contribute.demo.pojo.Account;
import com.contribute.demo.pojo.Contribution;
import com.contribute.demo.service.ContributionService;
import com.contribute.demo.service.LoginMessageService;
import com.contribute.demo.tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(value = "/contributions")
    public Result list(){
        Account account=loginMessageService.getLoginAccount();
        List<Contribution> contributions= contributionService.findByAccountID(account.getId());
        return new Result(true, "",contributions);
    }

    /**
     * 专家添加评论
     */
//    @PostMapping(value = "/addcomment")
//    public Result addComment(@RequestBody Contribution contribution){
//
//        contribution.setDiscussed(true); //设为已经评论过
//        contributionService.save(contribution);
//        return new Result();
//    }
}
