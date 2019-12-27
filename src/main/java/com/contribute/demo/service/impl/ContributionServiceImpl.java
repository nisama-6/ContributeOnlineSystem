package com.contribute.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.contribute.demo.pojo.Account;
import com.contribute.demo.pojo.Contribution;
import com.contribute.demo.repository.ContributionRepository;
import com.contribute.demo.service.ContributionService;
import com.contribute.demo.service.LoginMessageService;
import com.contribute.demo.service.WebSocketService;
import com.contribute.demo.tools.ResponseMessage;
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
    @Autowired
    WebSocketService webSocketService;

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
    public synchronized void save(Contribution contribution) {
        contribution.setDiscussed(true);
        contribution.getComment().setContribution(contribution);
        contribution.getComment().setExpert(loginMessageService.getLoginAccount());
        if(contribution.getComment().isPass()){
            webSocketService.sendMessageByID(String.valueOf(contribution.getAuthor().getId()),
                    new ResponseMessage("新的评论","您的投稿被专家评论通过成功了",ResponseMessage.SUCCESS));
        }
        else {
            webSocketService.sendMessageByID(String.valueOf(contribution.getAuthor().getId()),
                    new ResponseMessage("新的评论","您的投稿未通过",ResponseMessage.DANGER));
        }
        contributionRepository.save(contribution);
    }

    @Override
    public List<Contribution> findByAccountID(Integer id) {
        return contributionRepository.findContributionsByAuthor_Id(id);
    }

    @Override
    public JSONObject findByUploadDateIn7Days() {
        Calendar calendarpast = Calendar.getInstance();
        JSONObject jsonObject=new JSONObject();
        for(int i=0;i<7;i++){
            calendarpast.set(Calendar.DAY_OF_YEAR, calendarpast.get(Calendar.DAY_OF_YEAR) - i);
            Date past = calendarpast.getTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String result = format.format(past);
            Long count=contributionRepository.countByUploaddate(result);
            jsonObject.put(String.valueOf(7-i),count);
        }
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
