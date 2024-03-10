package com.jj.demo.post;


import com.jj.demo.config.auditing.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "POSTS")
@Getter
@Setter
public class Post extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 50)
    private String title;
    
    @Column(name = "DISCRIPTION", nullable = false, length = 500)
    private String description;

    // Getters and Setters
}
