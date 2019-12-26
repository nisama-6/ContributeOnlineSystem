package com.contribute.demo.service.impl;

import com.contribute.demo.pojo.Account;
import com.contribute.demo.pojo.Contribution;
import com.contribute.demo.repository.ContributionRepository;
import com.contribute.demo.service.ContributionService;
import com.contribute.demo.service.LoginMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ContributionServiceImpl implements ContributionService {

    @Autowired
    ContributionRepository contributionRepository;
    @Autowired
    LoginMessageService loginMessageService;

    @Override
    public List<Contribution> findIsDiscussed(boolean isDiscussed) {
        return contributionRepository.findContributionsByDiscussed(isDiscussed);
    }

    @Override
    public List<Contribution> findAll() {
        return contributionRepository.findAll();
    }

    @Override
    public void upload(Contribution contribution) {
        contributionRepository.save(contribution);
    }

    @Override
    public void save(Contribution contribution) {

        contribution.setDiscussed(true);
        contribution.getComment().setContribution(contribution);
        contribution.getComment().setExpert(loginMessageService.getLoginAccount());
        contributionRepository.save(contribution);
    }

    @Override
    public List<Contribution> findByAccountID(Integer id) {
        return contributionRepository.findContributionsByAuthor_Id(id);
    }

    @Override
    public List<Contribution> findByUploadDateIn7Days() {
        Calendar calendarpast = Calendar.getInstance();
        calendarpast.set(Calendar.DAY_OF_YEAR, calendarpast.get(Calendar.DAY_OF_YEAR) - 7);
        Date past = calendarpast.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(past);
        SimpleDateFormat myFmt2=new SimpleDateFormat("yyyy-MM-dd");
        Date now=new Date();
        String nowtime=myFmt2.format(now);
        System.out.println("七天前="+result+"now="+nowtime);
        return contributionRepository.findByUploaddateBetweenOrderByUploaddate(result,nowtime);
    }

    @Override
    public Long countByDiscussed(boolean b, Account account) {
        return contributionRepository.countByDiscussedAndAuthor(b,account);
    }

    @Override
    public Long countByPassed(boolean b, Account account) {
        return contributionRepository.countByComment_PassAndAuthor(b,account);
    }
}
