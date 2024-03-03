package com.jj.demo.like;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LikeService {
    private final LikeRepository likeRepository;

    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    public LikeDto createLike(LikeDto likeDto) {
        Like like = LikeMapper.INSTANCE.likeDtoToLike(likeDto);
        like = likeRepository.save(like);
        return LikeMapper.INSTANCE.likeToLikeDto(like);
    }

    public LikeDto getLikeById(Long id) {
        Like like = likeRepository.findById(id).orElseThrow();
        return LikeMapper.INSTANCE.likeToLikeDto(like);
    }

    @Transactional
    public LikeDto updateLike(Long id, LikeDto likeDto) {
        Like like = likeRepository.findById(id).orElseThrow();
        LikeMapper.INSTANCE.updateFromDto(like, likeDto);
        return LikeMapper.INSTANCE.likeToLikeDto(like);
    }

    public void deleteLike(Long id) {
        likeRepository.deleteById(id);
    }
}
