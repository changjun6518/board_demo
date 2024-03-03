package com.jj.demo.content;

import com.jj.demo.member.Member;
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
@Table(name = "CONTENTS")
@Getter
@Setter
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "CREATE_DT")
    private LocalDateTime createDt;
    
    @Column(name = "UPDATE_DT")
    private LocalDateTime updateDt;

    @ManyToOne
    @JoinColumn(name = "CREATE_BY")
    private Member createdBy;

    @ManyToOne
    @JoinColumn(name = "UPDATE_BY")
    private Member updatedBy;
    
    @Column(name = "DELETE_YN", length = 1)
    private String deleteYn;
    
    @Column(name = "URL", length = 500)
    private String url;

    // Getters and Setters
}
