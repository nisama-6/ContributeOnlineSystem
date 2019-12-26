package com.contribute.demo.repository;

import com.contribute.demo.pojo.Account;
import com.contribute.demo.pojo.Usermessage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName : UsermessageRepository
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/12/24
 **/

public interface UsermessageRepository extends JpaRepository<Usermessage, Long> {

    Usermessage save(Usermessage usermessage);

}
