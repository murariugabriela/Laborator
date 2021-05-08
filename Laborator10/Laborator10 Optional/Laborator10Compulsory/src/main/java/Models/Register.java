package Models;

import Repositories.UserRepository;
import org.json.JSONArray;

public class Register extends Commands{

    public String register(String client) {
        if (userRepository.findByName(client) == null) {
            User user = new User();
            user.setName(client);
            user.setFriends(new JSONArray().toString());
            userRepository.create(user);
            return "User " +
                    client +
                    " registered with success";
        } else
            return "User " +
                    client +
                    " already exists in the database. Please choose another username";
    }
}
