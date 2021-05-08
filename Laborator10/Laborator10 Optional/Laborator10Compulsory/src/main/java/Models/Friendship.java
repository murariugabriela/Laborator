package Models;

import java.util.List;

public class Friendship extends Commands{
    public String addFriends(List<String> users, String username){
        String answer = "";
        for (String user : users) {
            if(userRepository.findByName(user) == null) {
                answer += "User " + user + " doesn't exist, so the friendship cannot be made. ";
                answer.concat("\t");
            }
            else {
                friendshipRepository.addFriend(user, username);
                friendshipRepository.addFriend(username, user);
                answer += "User " + user + " successfully added to your friend list. ";
                answer.concat("\t");
            }
        }
        return answer;
    }
}
