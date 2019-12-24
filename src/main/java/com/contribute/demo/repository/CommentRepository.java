package com.contribute.demo.repository;

import com.contribute.demo.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

    List<Comment> findAll();
    Comment findCommentByAccount_Id(int id);
    Comment save(Comment comment);
    void delete(Comment comment);
    void deleteById(int id);

}
