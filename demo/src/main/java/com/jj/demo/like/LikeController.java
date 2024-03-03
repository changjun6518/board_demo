package com.jj.demo.like;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping
    public ResponseEntity<LikeDto> createLike(@RequestBody LikeDto likeDto) {
        LikeDto newLike = likeService.createLike(likeDto);
        return new ResponseEntity<>(newLike, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LikeDto> getLike(@PathVariable Long id) {
        LikeDto likeDto = likeService.getLikeById(id);
        return ResponseEntity.ok(likeDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LikeDto> updateLike(@PathVariable Long id, @RequestBody LikeDto likeDto) {
        LikeDto updatedLike = likeService.updateLike(id, likeDto);
        return ResponseEntity.ok(updatedLike);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLike(@PathVariable Long id) {
        likeService.deleteLike(id);
        return ResponseEntity.noContent().build();
    }
}
