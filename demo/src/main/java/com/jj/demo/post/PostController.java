package com.jj.demo.post;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto newPost = postService.createPost(postDto);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getPostAll() {
        List<PostDto> postDtoList = postService.getPostAll();
        return ResponseEntity.ok(postDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPost(@PathVariable Long id) {
        PostDto postDto = postService.getPostById(id);
        return ResponseEntity.ok(postDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable Long id, @RequestBody PostDto postDto) {
        PostDto updatedPost = postService.updatePost(id, postDto);
        return ResponseEntity.ok(updatedPost);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
