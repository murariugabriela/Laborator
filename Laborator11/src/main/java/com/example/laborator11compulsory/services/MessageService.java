package com.example.laborator11compulsory.services;

import com.example.laborator11compulsory.controllers.ExceptionController;
import com.example.laborator11compulsory.models.ErrorMessage;
import com.example.laborator11compulsory.models.Friendship;
import com.example.laborator11compulsory.models.Message;
import com.example.laborator11compulsory.models.MyException;
import com.example.laborator11compulsory.repositories.FriendshipRepository;
import com.example.laborator11compulsory.repositories.MessageRepository;
import com.example.laborator11compulsory.repositories.UserRepository;
import lombok.AllArgsConstructor;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;
    private final FriendshipRepository friendshipRepository;
    private final UserRepository userRepository;

    public String sendMessage(String message, String username) throws MyException {
        JSONObject jsonObject = new JSONObject();
        if (userRepository.findByUsername(username).isPresent()) {
            Integer user = userRepository.findByUsername(username).get().getId();
            List<Friendship> friends = friendshipRepository.findAllById(user);
            for (Friendship friend : friends) {
                Message message1 = new Message();
                message1.setMessage(username + ": " + message);
                message1.setUser(friend.getUser2());
                messageRepository.save(message1);
            }
            jsonObject.put("message", "Message sent to all friends.");
        } else {
            throw new MyException("Username " + username + " is nonexistent");
        }
        return jsonObject.toJSONString();
    }

    public String readMessages(String username) throws MyException {
        JSONObject jsonObject = new JSONObject();
        if (userRepository.findByUsername(username).isPresent()) {
            Integer user = userRepository.findByUsername(username).get().getId();
            List<Message> messages = messageRepository.findAllById(user);
            JSONArray jsonArray = new JSONArray();
            for (Message message : messages) {
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("from", message.getMessage().substring(0, message.getMessage().indexOf(':')));
                jsonObject1.put("content", message.getMessage().substring(message.getMessage().indexOf(':') + 2));
                jsonArray.add(jsonObject1);
            }
            jsonObject.put("messages", jsonArray);
            return jsonObject.toJSONString();
        }
            throw new MyException("Username " + username + " is nonexistent");

    }
    //todo: Send, Read
}
