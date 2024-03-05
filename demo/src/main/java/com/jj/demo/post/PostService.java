package com.jj.demo.post;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostDto createPost(PostDto postDto) {
        Post post = PostMapper.INSTANCE.postDtoToPost(postDto);
        post = postRepository.save(post);
        return PostMapper.INSTANCE.postToPostDto(post);
    }

    public PostDto getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow();
        return PostMapper.INSTANCE.postToPostDto(post);
    }

    public List<PostDto> getPostAll() {
        List<Post> postList = postRepository.findAll();
        return PostMapper.INSTANCE.postListToPostDtoList(postList);
    }

    @Transactional
    public PostDto updatePost(Long id, PostDto postDto) {
        Post post = postRepository.findById(id).orElseThrow();
        PostMapper.INSTANCE.updateFromDto(post, postDto);
        return PostMapper.INSTANCE.postToPostDto(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
