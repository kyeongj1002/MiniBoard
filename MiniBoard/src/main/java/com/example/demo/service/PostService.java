package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    // 글 전체 조회
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // 글 저장
    public void savePost(Post post) {
        postRepository.save(post);
    }

    // 글 상세 조회
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    // 글 삭제
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}