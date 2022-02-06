package com.example.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @Author: kbs
 */

//모든 entity의 상위 클래스가 되어 Entity들의 createdDate, modifiedDate를 자동으로 관리해줌.
@Getter
@MappedSuperclass //JPA Entity class들이 BaseTimeEntity를 상속할경우 createdDate와 modifiedDate도 컬럼으로 인식.
@EntityListeners(AuditingEntityListener.class) //Auditing 기능 추가.
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
