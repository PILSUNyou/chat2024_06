package com.ll.chat_2024_06_03.domain.chat.chatRoom.service;

import com.ll.chat_2024_06_03.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chat_2024_06_03.domain.chat.chatRoom.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    public void make(String name){
        ChatRoom chatRoom = ChatRoom.builder()  // application에서 EnableJpaAuditing 에너테이션을 사용해서 createdate를 쓰지 않아도 된다.
                .name(name)
                .build();

        chatRoomRepository.save(chatRoom);
    }


    public List<ChatRoom> findAll() {
        return chatRoomRepository.findAll();
    }
}
