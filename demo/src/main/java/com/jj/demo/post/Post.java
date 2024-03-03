package com.jj.demo.post;


import com.jj.demo.member.Member;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "POSTS")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 50)
    private String title;
    
    @Column(name = "DISCRIPTION", nullable = false, length = 500)
    private String description;

    @CreatedDate
    @Column(name = "CREATE_DT", nullable = false)
    private LocalDateTime createDt;

    @LastModifiedDate
    @Column(name = "UPDATE_DT", nullable = false)
    private LocalDateTime updateDt;

    @ManyToOne
    @CreatedBy
    @JoinColumn(name = "CREATE_BY", referencedColumnName = "ID", nullable = false)
    private Member createdBy;

    @ManyToOne
    @LastModifiedBy
    @JoinColumn(name = "UPDATE_BY", referencedColumnName = "ID", nullable = false)
    private Member updatedBy;

    // Getters and Setters
}
