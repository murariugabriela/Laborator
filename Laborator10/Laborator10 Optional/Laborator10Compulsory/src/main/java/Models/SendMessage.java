package Models;

import java.util.List;

public class SendMessage extends Commands{
    public String sendMessage(String username, String message){

        User sender = (User) userRepository.findByName(username);
        List<Object> users = friendshipRepository.findByUserId(sender.getId());
        String friends = "";
        for (Object friendship : users) {
            friends += ((User)userRepository.findById(((Friendships) friendship).getUser2())).getName()+ ", ";
        }
        friends = friends.substring(0,friends.lastIndexOf(','));
        System.out.println(friends);

//        System.out.println(users);
        int namePosition = 0;
        while(friends.substring(namePosition).contains(",")){
            String friend = friends.substring(namePosition, friends.substring(namePosition).indexOf(","));
            System.out.println(friend);
            namePosition = friends.indexOf(",") + 2;
            messageRepository.sendMessage(friend, message, username);
        }
        String friend = friends.substring(namePosition);
        System.out.println(friend);
        messageRepository.sendMessage(friend, message, username);
        return "Message sent to all your friends";
    }
}
