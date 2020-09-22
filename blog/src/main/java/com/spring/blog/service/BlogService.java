package com.spring.blog.service;

import com.spring.blog.model.Post;

import java.util.List;

public interface BlogService {

    List<Post> findAll();
    Post findById(Long Id);
    Post save(Post post);
}
