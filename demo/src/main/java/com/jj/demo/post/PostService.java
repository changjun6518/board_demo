package com.jj.demo.post;

import com.jj.demo.common.model.CustomResponse;
import com.jj.demo.common.model.Pagination;
import jakarta.persistence.PreUpdate;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final PostRepositoryCustom postRepositoryCustom;


    @Transactional
    public PostDto createPost(PostDto postDto) {
        Post post = PostMapper.INSTANCE.postDtoToPost(postDto);
        post = postRepository.save(post);
        return PostMapper.INSTANCE.postToPostDto(post);
    }

    public PostDto getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow();
        return PostMapper.INSTANCE.postToPostDto(post);
    }

    public CustomResponse<List<PostDto>> getPostAll(Pageable pageable) {
        List<PostDto> dtos = new ArrayList<>();
        Page<Post> postList = postRepository.findAllByOrderByIdDesc(pageable);
        for (Post post : postList) {
            PostDto postDto = PostMapper.INSTANCE.postToPostDto(post);
            dtos.add(postDto);
        }
        Pagination pagination = new Pagination(
                (int) postList.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );
        return CustomResponse.ok(dtos, pagination);
    }

    public CustomResponse<List<PostDto>> getPostAll(Pageable pageable, SearchCondition searchCondition) {
        List<PostDto> dtos = new ArrayList<>();
        Page<Post> postList = postRepositoryCustom.findAllBySearchCondition(pageable, searchCondition);
        for (Post post : postList) {
            PostDto postDto = PostMapper.INSTANCE.postToPostDto(post);
            dtos.add(postDto);
        }
        Pagination pagination = new Pagination(
                (int) postList.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );
        return CustomResponse.ok(dtos, pagination);
    }

    @Transactional
    public PostDto updatePost(Long id, PostDto postDto) {
        Post post = postRepository.findById(id).orElseThrow();
        PostMapper.INSTANCE.updateFromDto(post, postDto);
        postRepository.save(post);
        return PostMapper.INSTANCE.postToPostDto(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
