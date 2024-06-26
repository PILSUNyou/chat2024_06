package com.ll.chat_2024_06_03.domain.chat.chatRoom.entity;


import com.ll.chat_2024_06_03.global.jpa.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@AllArgsConstructor(access = PROTECTED) // 생성자 (접근제어자 : PROTECTED)
@NoArgsConstructor(access = PROTECTED) // 생성자x (접근제어자 : PROTECTED)
@SuperBuilder
@Getter
@Setter
@ToString(callSuper = true)
public class ChatMessage extends BaseEntity {

    @ManyToOne
    private ChatRoom chatRoom;


    private String writerName;


    private String content;
}
