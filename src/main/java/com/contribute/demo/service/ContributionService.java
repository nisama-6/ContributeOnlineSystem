package com.contribute.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.contribute.demo.pojo.Account;
import com.contribute.demo.pojo.Contribution;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName : UploadService
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/12/24
 **/

public interface ContributionService {
    void upload(Contribution contribution);
    List<Contribution> findAll();
    List<Contribution> findIsDiscussed(boolean isDiscussed);
    void save(Contribution contribution) throws IOException, ServletException;
    List<Contribution> findByAccountID(Integer id);

    JSONObject findByUploadDateIn7Days() throws IOException, ServletException;

    Long countByDiscussed(boolean b, Account account);
    Long countByPassed(boolean b,Account account);



}
