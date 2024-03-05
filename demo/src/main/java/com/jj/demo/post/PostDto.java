package com.jj.demo.post;

import com.jj.demo.member.MemberDto;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class PostDto {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;
    private MemberDto createBy;
    private MemberDto updateBy;

    // Getters and Setters
}
