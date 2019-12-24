package com.contribute.demo.controller;

import com.contribute.demo.pojo.Contribution;
import com.contribute.demo.service.ContributionService;
import com.contribute.demo.tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : UploadController
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/12/24
 **/


@RestController("/user")
public class UploadController {

    @Autowired
    private ContributionService uploadService;


    @RequestMapping(path = "/upload",method = RequestMethod.POST)
    Result uploadContribute(Contribution contribution){
        uploadService.upload(contribution);
        return new Result(true,"");
    }

                           



}
