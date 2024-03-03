package com.jj.demo.comment;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentDto commentToCommentDto(Comment comment);
    Comment commentDtoToComment(CommentDto commentDto);

    void update(@MappingTarget Comment comment, CommentDto commentDto);
}
