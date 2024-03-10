package com.jj.demo.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jj.demo.member.MemberDto;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
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
