package com.faboda.query.service;

import com.faboda.query.model.Comment;
import com.faboda.query.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public String postComment(Comment comment){
       commentRepository.save(comment);
       return comment.toString();
    }


}
