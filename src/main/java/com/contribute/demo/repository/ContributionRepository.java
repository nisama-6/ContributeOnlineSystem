package com.contribute.demo.repository;

import com.contribute.demo.pojo.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContributionRepository extends JpaRepository<Contribution,Integer> {
    List<Contribution> findAll();
    Contribution findContributionById(int id);
    Contribution save(Contribution contribution);
    void delete(Contribution contribution);
    void deleteById(int id);
}
