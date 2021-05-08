package Models;

import Repositories.FriendshipRepository;
import Repositories.MessageRepository;
import Repositories.UserRepository;

public class Commands {
    public final UserRepository userRepository = new UserRepository();
    public final FriendshipRepository friendshipRepository = new FriendshipRepository();
    public final MessageRepository messageRepository = new MessageRepository();
}
