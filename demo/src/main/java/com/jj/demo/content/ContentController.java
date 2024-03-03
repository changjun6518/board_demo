package com.jj.demo.content;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contents")
public class ContentController {
    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @PostMapping
    public ResponseEntity<ContentDto> createContent(@RequestBody ContentDto contentDto) {
        ContentDto newContent = contentService.createContent(contentDto);
        return new ResponseEntity<>(newContent, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContentDto> getContent(@PathVariable Long id) {
        ContentDto contentDto = contentService.getContentById(id);
        return ResponseEntity.ok(contentDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContentDto> updateContent(@PathVariable Long id, @RequestBody ContentDto contentDto) {
        ContentDto updatedContent = contentService.updateContent(id, contentDto);
        return ResponseEntity.ok(updatedContent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContent(@PathVariable Long id) {
        contentService.deleteContent(id);
        return ResponseEntity.noContent().build();
    }
}
