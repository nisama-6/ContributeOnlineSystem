package com.contribute.demo.repository;

import com.contribute.demo.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

    List<Comment> findAll();
    Comment findCommentByExpert_Id(int id);
    void deleteById(int id);


}
