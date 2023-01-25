package com.faboda.query.service;

import com.faboda.query.model.Post;
import com.faboda.query.repository.PostRepository;
import com.faboda.query.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {


    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;

    public Post publishPost(Integer id, Post post){
        return userRepository.findById(id).map(
                user->{
                    post.setUser(user);
                    return postRepository.save(post);
                }
        ).orElseThrow(()-> new RuntimeException());
    }

}
