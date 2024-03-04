package com.jj.demo.post;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class PostDto {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;
    private Long createdById;
    private Long updatedById;

    // Getters and Setters
}
