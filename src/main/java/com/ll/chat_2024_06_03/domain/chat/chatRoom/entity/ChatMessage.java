package com.ll.chat_2024_06_03.domain.chat.chatRoom.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
public class ChatMessage {

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

    @ManyToOne
    private ChatRoom chatRoom;

    @Getter
    private String writerName;

    @Getter
    private String content;
}
