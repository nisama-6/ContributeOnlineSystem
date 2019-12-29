package com.contribute.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.contribute.demo.pojo.Account;
import com.contribute.demo.pojo.Contribution;
import com.contribute.demo.repository.ContributionRepository;
import com.contribute.demo.service.ContributionService;
import com.contribute.demo.service.LoginMessageService;
import com.contribute.demo.service.WebSocketService;
import com.contribute.demo.tools.ResponseMessage;
import com.contribute.demo.tools.pushmessage.MessageSuccess;
import com.contribute.demo.tools.pushmessage.PushMethod;
import com.contribute.demo.tools.pushmessage.PushToUser;
import com.contribute.demo.tools.pushmessage.ResMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
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
    WebSocketService webSocketService;
    @Autowired
    public SimpMessagingTemplate template;
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
            PushMethod pushMethod =new PushToUser(template);
            ResMessage resMessage=new MessageSuccess(pushMethod,"恭喜","您的投稿通过成功了");
            resMessage.pushToOne(String.valueOf(contribution.getAuthor().getId()));
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
        Account account=loginMessageService.getLoginAccount();
        Long undiscussed=contributionRepository.countByDiscussedAndAuthor(false,account);
        Long passed=contributionRepository.countByComment_PassAndAuthor(true,account);
        long unpassed=contributionRepository.countByComment_PassAndAuthor(false,account);
        List<Long> countlist=new ArrayList<>();
        List<String> weekdaylist=new ArrayList<>();

        JSONObject jsonObject=new JSONObject();
        for(int i=6;i>=0;i--){
            Calendar calendarpast = Calendar.getInstance();
            calendarpast.set(Calendar.DAY_OF_YEAR, calendarpast.get(Calendar.DAY_OF_YEAR) - i);
            Date past = calendarpast.getTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat format2 = new SimpleDateFormat("MM-dd");
            String result = format.format(past);
            String result2 = format2.format(past);
            Long count=contributionRepository.countByUploaddate(result);
            countlist.add(count);
            weekdaylist.add(result2);
        }
        jsonObject.put("countlist",countlist);
        jsonObject.put("weekdaylist",weekdaylist);

        JSONObject passCount=new JSONObject();
        passCount.put("total",undiscussed+passed+unpassed);
        passCount.put("passed",passed);
        passCount.put("unpassed",unpassed);
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
