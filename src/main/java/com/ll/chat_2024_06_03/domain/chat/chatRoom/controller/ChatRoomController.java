package com.ll.chat_2024_06_03.domain.chat.chatRoom.controller;

import com.ll.chat_2024_06_03.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chat_2024_06_03.domain.chat.chatRoom.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/chat/room")
@RequiredArgsConstructor // 객체를 안만들어도 자동 객체 생성 (private final로 만들어야됌)
public class ChatRoomController {
    private final ChatRoomService chatRoomService;

    @GetMapping("/{roomId}")
    public String showRoom(
            @PathVariable("roomId") final long roomId,
            @RequestParam(value = "writerName", defaultValue = "NoName") final String writerName
    ){
        return "domain/chat/chatRoom/room";
    }

    @GetMapping("/make")
    public String showMake(){
        return "domain/chat/chatRoom/make";
    }

    @PostMapping("/make")
    public String make(
            @RequestParam(value="name") final String name
    ){
        chatRoomService.make(name);
        return "redirect:/chat/room/list";
    }

    @GetMapping("/list")
    public String showList(Model model){
        List<ChatRoom> chatRooms = chatRoomService.findAll();
        model.addAttribute("chatRooms", chatRooms);
        return "domain/chat/chatRoom/list";
    }
}
