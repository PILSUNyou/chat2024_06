package com.ll.chat_2024_06_03.domain.chat.chatRoom.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Builder
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor(access = PROTECTED) // 생성자 (접근제어자 : PROTECTED)
@NoArgsConstructor(access = PROTECTED) // 생성자x (접근제어자 : PROTECTED)

public class ChatRoom {
    @Id
    @Getter
    @GeneratedValue(strategy = IDENTITY) // PRIMARY_KEY
    private long id;

    @CreatedDate
    @Getter
    private LocalDateTime createDate;

    @LastModifiedDate
    @Getter
    private LocalDateTime modifyDate;

    @Getter
    private  String name;

    public ChatRoom(String name){
        this.name = name;
    }
}
