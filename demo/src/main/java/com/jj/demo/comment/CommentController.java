package com.jj.demo.comment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto) {
        CommentDto newComment = commentService.createComment(commentDto);
        return new ResponseEntity<>(newComment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDto> getComment(@PathVariable Long id) {
        CommentDto commentDto = commentService.getCommentById(id);
        return ResponseEntity.ok(commentDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable Long id, @RequestBody CommentDto commentDto) {
        CommentDto updatedComment = commentService.updateComment(id, commentDto);
        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}
