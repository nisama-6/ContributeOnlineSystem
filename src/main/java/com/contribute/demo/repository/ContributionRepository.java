package com.contribute.demo.repository;

import com.contribute.demo.pojo.Account;
import com.contribute.demo.pojo.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContributionRepository extends JpaRepository<Contribution,Integer> {
    List<Contribution> findAll();
    Contribution findContributionById(int id);
    void deleteById(int id);
    List<Contribution> findContributionsByDiscussed(boolean discussed);
    List<Contribution> findContributionsByAuthor_Id(Integer id);

    List<Contribution> findByUploaddateBetweenOrderByUploaddate(String s1,String s2);

    Long countByDiscussedAndAuthor(boolean b, Account account);
    Long countByComment_PassAndAuthor(boolean b, Account account);
    Long countByUploaddateAndAuthor(String uploaddate,Account account);

    List<Contribution> findByAuthor_Usermessage_NicknameLikeOrNameLike(String nickname, String name);
    List<Contribution> findByNameLike(String name);


}
