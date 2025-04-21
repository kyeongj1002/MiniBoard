package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    // 글 목록 보기
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "list"; // list.html로 이동
    }

    // 글 작성 폼
    @GetMapping("/new")
    public String showNewPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "form"; // form.html로 이동
    }

    // 글 저장 처리
    @PostMapping("/save")
    public String savePost(@ModelAttribute("post") Post post) {
        postService.savePost(post);
        return "redirect:/";
    }

    // 글 수정 폼
    @GetMapping("/edit/{id}")
    public String showEditPostForm(@PathVariable("id") Long id, Model model) {
        Post post = postService.getPostById(id).orElse(null);
        model.addAttribute("post", post);
        return "form"; // form.html 재사용
    }

    // 글 삭제
    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);
        return "redirect:/";
    }
}