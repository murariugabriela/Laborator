package Models;

import java.util.List;

public class ReadMessage extends Commands{
    public String readMessage(String username){
        User receiver = (User) userRepository.findByName(username);
        List<Object> userMessages = messageRepository.findByUserId(receiver.getId());
        String messages = "";
        for (Object userMessage : userMessages) {
            messages += ((Message) userMessage).getMessage();
        }
        return messages;
    }
}
