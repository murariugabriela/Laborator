package com.example.laborator11compulsory.controllers;

import com.example.laborator11compulsory.models.Message;
import com.example.laborator11compulsory.models.MyException;
import com.example.laborator11compulsory.requests.AddNewPersonRequest;
import com.example.laborator11compulsory.requests.SendMessageRequest;
import com.example.laborator11compulsory.services.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping(path = "/", method = {RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE, RequestMethod.PUT}/*, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE*/)
@AllArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @PostMapping(path = "sendMessage")
    public String sendMessage(@RequestBody SendMessageRequest sendMessageRequest) throws MyException {
        return messageService.sendMessage(sendMessageRequest.getMessage(), sendMessageRequest.getUsername());
    }
    @PostMapping(path = "readMessages")
    public String readMessages(@RequestBody AddNewPersonRequest addNewPersonRequest) throws MyException {
        return messageService.readMessages(addNewPersonRequest.getUsername());
    }
}
