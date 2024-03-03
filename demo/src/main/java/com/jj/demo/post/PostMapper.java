package com.jj.demo.post;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    PostDto postToPostDto(Post post);
    Post postDtoToPost(PostDto postDto);

    void updateFromDto(@MappingTarget Post post, PostDto postDto);
}
