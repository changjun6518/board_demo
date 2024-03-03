package com.jj.demo.member;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class MemberDto {
    private Long id;
    private String email;
    private String password;
    private String nickname;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;

    // Getters and Setters
}
