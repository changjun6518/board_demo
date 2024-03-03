
package com.jj.demo.comment;

import com.jj.demo.member.Member;
import com.jj.demo.post.Post;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "COMMENTS")
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "DISCRIPTION", nullable = false, length = 500)
    private String description;
    
    @Column(name = "PARENT_ID")
    private Long parentId;
    
    @Column(name = "CREATE_DT", nullable = false)
    private LocalDateTime createDt;
    
    @Column(name = "UPDATE_DT", nullable = false)
    private LocalDateTime updateDt;
    
    @ManyToOne
    @JoinColumn(name = "POST_ID", nullable = false)
    private Post post;
    
    @ManyToOne
    @JoinColumn(name = "CREATE_BY", nullable = false)
    private Member createdBy;
    
    @ManyToOne
    @JoinColumn(name = "UPDATE_BY", nullable = false)
    private Member updatedBy;

    // Getters and Setters
}
