package com.contribute.demo.controller;

import com.contribute.demo.pojo.Contribution;
import com.contribute.demo.service.ContributionService;
import com.contribute.demo.service.LoginMessageService;
import com.contribute.demo.service.WebSocketService;
import com.contribute.demo.tools.ResponseMessage;
import com.contribute.demo.tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.io.IOException;
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
     * 可根据nickname或name查询
     * 只返回被discussed的内容
     */
    @GetMapping(value = "/contributions")
    @PreAuthorize("hasAnyAuthority('expert')")
    public Result list(String name){
        List<Contribution> contributions= contributionService.
                findByAuthor_Usermessage_NicknameLikeOrNameLike(name,name);
        return new Result(true, "",contributions);
    }

    /**
     * 按照是否审核 查询稿件
     * @param discussed
     * @return
     */
    @GetMapping(value = "/contributionsbydiscussed")
    @PreAuthorize("hasAnyAuthority('expert')")
    public Result listbydiscussed(boolean discussed){
        List<Contribution> contributions=contributionService.findByDiscussed(discussed);
        return new Result(true,"按照是否审核 查询",contributions);

    }


    /**
     * 专家添加评论
     */
    @PreAuthorize("hasAnyAuthority('expert')")
    @PostMapping(value = "/addcomment")
    public Result addComment(@RequestBody Contribution contribution) throws IOException, ServletException {
        contributionService.save(contribution);
        return new Result();
    }







}
