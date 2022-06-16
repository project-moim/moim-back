package com.avocado.moin.post.service;


import com.avocado.moin.post.dto.PostAddDto;
import com.avocado.moin.post.dto.PostUpdateDto;
import com.avocado.moin.post.domain.Post;
import com.avocado.moin.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public void addPost(PostAddDto postAddDto) {
        log.info("add Post");
        try {
            postRepository.save(postAddDto.toEntity()).getId();
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
    }

    @Transactional
    public void editPost(Long id, PostUpdateDto postDto) {
        log.info("edit post {}.");
        Post post = postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("error"));
        post.update(postDto.getTitle(), postDto.getContent(), postDto.getLocation());
    }


    public void delPost(Long id) {
        log.info("delete Sns by Id {}.", id);
        try {
            postRepository.deleteById(id);
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
    }

    public List<Post> findAllPost() {
        return postRepository.findAll();
    }

}