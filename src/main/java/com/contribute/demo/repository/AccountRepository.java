package com.contribute.demo.repository;

import com.contribute.demo.pojo.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName : AccountRepository
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/12/24
 **/


public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findAccountById(Integer id);
    Account findAccountByUsername(String username);
    Account findAccountByUsermessage_Name(String name);
    Long countByUsername(String username);

}
