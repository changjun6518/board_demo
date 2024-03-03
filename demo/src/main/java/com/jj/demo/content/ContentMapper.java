package com.jj.demo.content;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ContentMapper {
    ContentMapper INSTANCE = Mappers.getMapper(ContentMapper.class);

    ContentDto contentToContentDto(Content content);
    Content contentDtoToContent(ContentDto contentDto);

    void updateFromDto(@MappingTarget Content content, ContentDto contentDto);
}
