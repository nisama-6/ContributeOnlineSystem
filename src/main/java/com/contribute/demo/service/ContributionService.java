package com.contribute.demo.service;

import com.contribute.demo.pojo.Account;
import com.contribute.demo.pojo.Contribution;

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
    void save(Contribution contribution);
    List<Contribution> findByAccountID(Integer id);

    List<Contribution> findByUploadDateIn7Days();

    Long countByDiscussed(boolean b, Account account);
    Long countByPassed(boolean b,Account account);



}
