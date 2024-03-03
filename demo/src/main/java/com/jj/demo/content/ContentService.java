package com.jj.demo.content;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContentService {
    private final ContentRepository contentRepository;

    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public ContentDto createContent(ContentDto contentDto) {
        Content content = ContentMapper.INSTANCE.contentDtoToContent(contentDto);
        content = contentRepository.save(content);
        return ContentMapper.INSTANCE.contentToContentDto(content);
    }

    public ContentDto getContentById(Long id) {
        Content content = contentRepository.findById(id).orElseThrow();
        return ContentMapper.INSTANCE.contentToContentDto(content);
    }

    @Transactional
    public ContentDto updateContent(Long id, ContentDto contentDto) {
        Content content = contentRepository.findById(id).orElseThrow();
        ContentMapper.INSTANCE.updateFromDto(content, contentDto);
        return ContentMapper.INSTANCE.contentToContentDto(content);
    }

    public void deleteContent(Long id) {
        contentRepository.deleteById(id);
    }
}
