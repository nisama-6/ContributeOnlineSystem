package com.contribute.demo.repository;

import com.contribute.demo.pojo.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Modifying
    @Query(value = "UPDATE tb_account SET password =?1 WHERE id =?2 ",nativeQuery=true)
    void changepassword(String newpassword,int id);

}
