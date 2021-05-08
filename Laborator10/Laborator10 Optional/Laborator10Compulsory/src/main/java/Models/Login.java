package Models;

import Repositories.UserRepository;

public class Login extends Commands{

    public String login(String client) {
        if (userRepository.findByName(client) == null) {
            return "Username " +
                    client +
                    " does not exist in the database: login failed";
        } else
            return client + ": " + "successfully logged in";
    }
}
