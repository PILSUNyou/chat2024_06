package com.ll.chat_2024_06_03.domain.chat.chatRoom.controller;

import com.ll.chat_2024_06_03.domain.chat.chatRoom.entity.ChatMessage;
import com.ll.chat_2024_06_03.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chat_2024_06_03.domain.chat.chatRoom.service.ChatRoomService;
import com.ll.chat_2024_06_03.global.rsData.RsData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.Writer;
import java.util.List;

@Controller
@RequestMapping("/chat/room")
@RequiredArgsConstructor // 객체를 안만들어도 자동 객체 생성 (private final로 만들어야됌)
public class ChatRoomController {
    private final ChatRoomService chatRoomService;

    @GetMapping("/{roomId}")
    public String showRoom(
            @PathVariable("roomId") final long roomId,
            @RequestParam(value = "writerName", defaultValue = "NoName") final String writerName,
            Model model
    ){
        ChatRoom room = chatRoomService.findById(roomId).get();
        model.addAttribute("room", room);

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

    @Getter
    @Setter
    public static class WriterRequestBody{
        private String writerName;
        private String content;
    }

    @Getter
    @AllArgsConstructor
    public static class WriterResponseBody{
        private long chatMessageId;
    }

    @PostMapping("/{roomId}/write")
    @ResponseBody
    public RsData<WriterResponseBody> write(
            @PathVariable("roomId") final long roomId,
            @RequestBody final WriterRequestBody requestBody
    ){
        ChatMessage chatMessage = chatRoomService.write(roomId, requestBody.getWriterName(), requestBody.getContent());

        return RsData.of("S-1", "%d번 메세지를 작성하였습니다.".formatted(chatMessage.getId()), new WriterResponseBody(chatMessage.getId()));
    }

    @Getter
    @AllArgsConstructor
    public static class GetMessagesAfterResponseBody{

    }

    @PostMapping("/{roomId}/MessagesAfter/{formChatMessageId}")
    @ResponseBody
    public RsData<GetMessagesAfterResponseBody> getMessagesAfter(
            @PathVariable("roomId") final long roomId,
            @PathVariable("formChatMessageId") final long formChatMessageId
    ){
        return null;
    }

}
