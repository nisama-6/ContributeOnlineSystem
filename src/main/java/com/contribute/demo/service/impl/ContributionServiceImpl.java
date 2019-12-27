package com.contribute.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.contribute.demo.pojo.Account;
import com.contribute.demo.pojo.Contribution;
import com.contribute.demo.repository.ContributionRepository;
import com.contribute.demo.service.ContributionService;
import com.contribute.demo.service.LoginMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ContributionServiceImpl implements ContributionService {

    @Autowired
    ContributionRepository contributionRepository;
    @Autowired
    LoginMessageService loginMessageService;

    @Autowired
    ContributionService contributionService;

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
    public JSONObject findByUploadDateIn7Days() {

        Account account=loginMessageService.getLoginAccount();
        Long discussed=contributionService.countByDiscussed(true,account);
        Long undiscussed=contributionService.countByDiscussed(false,account);
        Long passed=contributionService.countByPassed(true,account);
        Long unpassed=discussed-passed;




        JSONObject jsonObject=new JSONObject();
        List<Long> countList=new ArrayList<>();
        List<String> weekdayList=new ArrayList<>();
        for(int i=6;i>=0;i--){
            Calendar calendarpast = Calendar.getInstance();
            calendarpast.set(Calendar.DAY_OF_YEAR, calendarpast.get(Calendar.DAY_OF_YEAR) - i);
            Date past = calendarpast.getTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat format2 = new SimpleDateFormat("MM-dd");
            String result = format.format(past);
            String weekday=format2.format(past);
            Long count=contributionRepository.countByUploaddate(result);
            countList.add(count);
            weekdayList.add(weekday);
        }
        jsonObject.put("countlist",countList);
        jsonObject.put("weekdaylist",weekdayList);
        JSONObject passCount = new JSONObject();
        passCount.put("total",discussed+undiscussed);
        passCount.put("discussed", discussed);
        passCount.put("undiscussed", undiscussed);
        passCount.put("passed", passed);
        passCount.put("unpassed", unpassed);
        jsonObject.put("passCount",passCount);
        return jsonObject;
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
