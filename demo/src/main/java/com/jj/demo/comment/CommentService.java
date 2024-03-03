package com.jj.demo.comment;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CommentDto createComment(CommentDto commentDto) {
        Comment comment = CommentMapper.INSTANCE.commentDtoToComment(commentDto);
        comment = commentRepository.save(comment);
        return CommentMapper.INSTANCE.commentToCommentDto(comment);
    }

    public CommentDto getCommentById(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow();
        return CommentMapper.INSTANCE.commentToCommentDto(comment);
    }

    @Transactional
    public CommentDto updateComment(Long id, CommentDto commentDto) {
        Comment comment = commentRepository.findById(id).orElseThrow();
        CommentMapper.INSTANCE.update(comment, commentDto);
        return CommentMapper.INSTANCE.commentToCommentDto(comment);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
