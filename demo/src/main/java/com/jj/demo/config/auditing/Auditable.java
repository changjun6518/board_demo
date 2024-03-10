package com.jj.demo.config.auditing;

import com.jj.demo.member.Member;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class Auditable {

    @CreatedDate
    @Column(name = "create_dt")
    private LocalDateTime createDt;

    @ManyToOne
    @CreatedBy
    @JoinColumn(name = "create_by")
    private Member createBy;

    @LastModifiedDate
    @Column(name = "update_dt")
    private LocalDateTime updateDt;

    @ManyToOne
    @LastModifiedBy
    @JoinColumn(name = "update_by")
    private Member updateBy;

    // Getters and Setters
}
