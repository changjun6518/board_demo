package com.jj.demo.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "MEMBERS")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 50)
    private String email;
    
    @Column(nullable = false, length = 500)
    private String password;
    
    @Column(nullable = false, length = 50)
    private String nickname;

    @CreatedDate
    @Column(name = "CREATE_DT", nullable = false)
    private LocalDateTime createDt;

    @LastModifiedDate
    @Column(name = "UPDATE_DT", nullable = false)
    private LocalDateTime updateDt;

}
