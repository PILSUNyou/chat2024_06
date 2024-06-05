package com.ll.chat_2024_06_03.global.jpa.baseEntity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor(access = PROTECTED) // 생성자 (접근제어자 : PROTECTED)
@NoArgsConstructor(access = PROTECTED) // 생성자x (접근제어자 : PROTECTED)
@MappedSuperclass
@SuperBuilder
@Getter
@ToString
@EqualsAndHashCode
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY) // PRIMARY_KEY
    @EqualsAndHashCode.Include
    private long id;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifyDate;
}
