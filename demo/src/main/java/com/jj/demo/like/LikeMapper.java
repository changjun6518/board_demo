package com.jj.demo.like;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LikeMapper {
    LikeMapper INSTANCE = Mappers.getMapper(LikeMapper.class);

    LikeDto likeToLikeDto(Like like);
    Like likeDtoToLike(LikeDto likeDto);

    void updateFromDto(@MappingTarget Like like, LikeDto likeDto);
}
