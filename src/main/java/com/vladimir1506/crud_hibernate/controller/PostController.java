package com.vladimir1506.crud_hibernate.controller;

import com.vladimir1506.crud_hibernate.model.Post;
import com.vladimir1506.crud_hibernate.model.User;
import com.vladimir1506.crud_hibernate.repository.PostRepository;
import com.vladimir1506.crud_hibernate.repository.implementation.DBPostRepositoryImpl;

import java.util.List;

public class PostController {
    private final PostRepository postRepository;

    public PostController() {
        this.postRepository = new DBPostRepositoryImpl();
    }

    public Post createPost(String content, User user) {
        Post post = new Post(content);
        post.setUser(user);
        return postRepository.save(post);
    }

    public List<Post> getAll() {
        return postRepository.getAll();
    }

    public void deletePost(Long id) {
        postRepository.delete(id);
    }

    public Post getPostById(Long id) {
        return postRepository.getById(id);
    }

    public void updatePost(Long id, String content) {
        Post updatedPost = new Post(content);
        updatedPost.setId(id);
        postRepository.update(updatedPost);
    }
}
