package com.contribute.demo.controller;

import com.contribute.demo.pojo.Contribution;
import com.contribute.demo.service.ContributionService;
import com.contribute.demo.service.LoginMessageService;
import com.contribute.demo.service.WebSocketService;
import com.contribute.demo.tools.ResponseMessage;
import com.contribute.demo.tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expert")
public class CommentController {

    @Autowired
    ContributionService contributionService;
    @Autowired
    LoginMessageService loginMessageService;
    @Autowired
    WebSocketService webSocketService;

    /**
     * 查询所有的稿件
     */
    @GetMapping(value = "/contributions")
    public Result list(){
        List<Contribution> contributions= contributionService.findAll();
        return new Result(true, "",contributions);
    }

    /**
     * 按上传日期查询稿件（查7天以内的）
     */
    @GetMapping(value = "/contributionsin7days")
    public Result getbydate(){
        List<Contribution> contributions=contributionService.findByUploadDateIn7Days();
        return new Result(true,"ok",contributions);
    }


    /**
     * 专家添加评论
     */
    @PostMapping(value = "/addcomment")
    public Result addComment(@RequestBody Contribution contribution){
        contributionService.save(contribution);
        webSocketService.sendMessageByID(String.valueOf(contribution.getAuthor().getId()),
                new ResponseMessage("新的评论","您的投稿被专家评论了",ResponseMessage.SUCCESS));
        return new Result();
    }



}
