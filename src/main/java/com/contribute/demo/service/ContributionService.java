package com.contribute.demo.service;

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
    public List<Contribution> findAll();
    public List<Contribution> findIsCommited(boolean isCommited);
    public void save(Contribution contribution);

    }
