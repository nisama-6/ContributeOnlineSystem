package com.contribute.demo.repository;

import com.contribute.demo.pojo.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContributionRepository extends JpaRepository<Contribution,Integer> {
    List<Contribution> findAll();
    Contribution findContributionById(int id);
    void deleteById(int id);
    List<Contribution> findContributionsByIscommented(boolean iscommented);
}
