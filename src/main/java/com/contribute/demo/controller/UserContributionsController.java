package com.contribute.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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

//    /**
//     * 查询被评论/没被评论 通过/没通过的数量
//     * @param account
//     * @return
//     */
//    @PostMapping(value = "/passedcount")
//    public Result getMyDiscussedCount(@RequestBody Account account){
//        Long discussed=contributionService.countByDiscussed(true,account);
//        Long undiscussed=contributionService.countByDiscussed(false,account);
//        Long passed=contributionService.countByPassed(true,account);
//        long unpassed=contributionService.countByPassed(false,account);
//
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("total",discussed+undiscussed );
//        jsonObject.put("discussed", discussed);
//        jsonObject.put("undiscussed", undiscussed);
//        jsonObject.put("passed", passed);
//        jsonObject.put("unpassed", unpassed);
//
//
//        System.out.println("评论过"+discussed+" ，没评论过"+undiscussed);
//        return new Result(true,"",jsonObject);
//
//    }
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

    @GetMapping(value = "/contributionsin7days")
    public Result getbydate(){
        return new Result(true,"ok",contributionService.findByUploadDateIn7Days());
    }


}
