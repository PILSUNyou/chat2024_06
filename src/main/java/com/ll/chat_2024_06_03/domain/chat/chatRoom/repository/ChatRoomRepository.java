package com.ll.chat_2024_06_03.domain.chat.chatRoom.repository;

import com.ll.chat_2024_06_03.domain.chat.chatRoom.entity.ChatRoom;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> { // 인터페이스가 다른 인터페이스를 확장하는 경우에도 사용한다.

}