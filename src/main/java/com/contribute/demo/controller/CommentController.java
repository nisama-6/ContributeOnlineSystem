package com.contribute.demo.controller;

import com.contribute.demo.pojo.Contribution;
import com.contribute.demo.repository.CommentRepository;
import com.contribute.demo.service.ContributionService;
import com.contribute.demo.tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    ContributionService contributionService;

    /**
     * 查询所有的稿件
     */
    @GetMapping(value = "/contributions")
    public Result list(){
        List<Contribution> contributions= contributionService.findAll();
        return new Result(true, "",contributions);
    }

    /**
     * 专家添加评论
     */
    @PostMapping(value = "/addcomment")
    public Result addComment(@RequestBody Contribution contribution){
        //contribution.setCommented(true); //设为已经评论过
        contributionService.save(contribution);
        return new Result();
    }

}
