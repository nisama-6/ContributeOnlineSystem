package com.contribute.demo.controller;

import com.contribute.demo.pojo.Contribution;
import com.contribute.demo.service.ContributionService;
import com.contribute.demo.service.LoginMessageService;
import com.contribute.demo.tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @ClassName : UploadController
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/12/24
 **/


@RestController
@RequestMapping(value = "/user")
public class UploadController {

    @Autowired
    private ContributionService uploadService;

    @Autowired
    private LoginMessageService loginMessageService;
    @PreAuthorize("hasAnyAuthority('user')")
    @PostMapping(value = "/upload")
    Result uploadContribute(Contribution contribution) throws IOException, ServletException {
        contribution.setAuthor(loginMessageService.getLoginAccount());
        uploadService.upload(contribution);
        return new Result(true,"");
    }

                           



}
