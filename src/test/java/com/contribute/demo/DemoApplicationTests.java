package com.contribute.demo;

import com.contribute.demo.pojo.Contribution;
import com.contribute.demo.repository.ContributionRepository;
import com.contribute.demo.service.ContributionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    ContributionRepository contributionRepository;
    @Autowired
    ContributionService contributionService;

    @Test
    void test1() {

        String name = "";
        List<Contribution> list=contributionService.findByAuthor_Usermessage_NicknameLikeOrNameLike("%"+name+"%","%"+name+"%");
//        =contributionRepository.
//                findByAuthor_Usermessage_NicknameLikeOrNameLike("%"+name+"%","%"+name+"%");

        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println(list.size());
    }

    @Test
    void test2(){
        Calendar calendarpast = Calendar.getInstance();
        Date now = calendarpast.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(now);
        System.out.println(result);
    }


}
