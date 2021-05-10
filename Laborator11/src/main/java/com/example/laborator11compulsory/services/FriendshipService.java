package com.example.laborator11compulsory.services;

import com.example.laborator11compulsory.models.Friendship;
import com.example.laborator11compulsory.models.MyException;
import com.example.laborator11compulsory.models.Person;
import com.example.laborator11compulsory.repositories.FriendshipRepository;
import com.example.laborator11compulsory.repositories.UserRepository;
import com.example.laborator11compulsory.requests.AddNewFriendshipRequest;
import lombok.AllArgsConstructor;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

@Service
@AllArgsConstructor
public class FriendshipService {
    private final UserRepository userRepository;
    private final FriendshipRepository friendshipRepository;

    public String addFriendship(AddNewFriendshipRequest addNewFriendshipRequest) throws MyException {
        JSONObject jsonObject = new JSONObject();
        if (!userRepository.findByUsername(addNewFriendshipRequest.getFirstUsername()).isPresent())
            throw new MyException("Username " + addNewFriendshipRequest.getFirstUsername() + " is nonexistent, please choose another one.");
        else if (!userRepository.findByUsername(addNewFriendshipRequest.getSecondUsername()).isPresent())
            throw new MyException("Username " + addNewFriendshipRequest.getSecondUsername() + " is nonexistent, please choose another one.");
        else {
            Friendship friendship = new Friendship();
            friendship.setUser1(userRepository.findByUsername(addNewFriendshipRequest.getFirstUsername()).get().getId());
            friendship.setUser2(userRepository.findByUsername(addNewFriendshipRequest.getSecondUsername()).get().getId());
            if (friendship.getUser1() == friendship.getUser2()) {
                throw new MyException("Cannot make a friendship with yourself.");
            } else if (friendshipRepository.exists(Example.of(friendship))) {
                throw new MyException("Friendship already exists.");
            } else {
                Friendship friendship2 = new Friendship();
                friendship2.setUser1(friendship.getUser2());
                friendship2.setUser2(friendship.getUser1());
                friendshipRepository.save(friendship);
                friendshipRepository.save(friendship2);
                jsonObject.put("message", "Friendship successfully made.");
            }
        }
        return jsonObject.toJSONString();
    }

    public String getUsersFriends(String username) throws MyException {
        JSONObject jsonObject = new JSONObject();
        if (!userRepository.findByUsername(username).isPresent()) {
            throw new MyException("User is nonexistent.");
        } else {
            JSONArray jsonArray = new JSONArray();
            List<Friendship> friendshipList = friendshipRepository.findAllById(userRepository.findByUsername(username).get().getId());
            for (Friendship friendship : friendshipList) {

                jsonArray.add(userRepository.findById(friendship.getUser2()).get().getUsername());
            }
            jsonObject.put("user", username);
            jsonObject.put("friends", jsonArray);
        }
        return jsonObject.toJSONString();
    }

    public String firstKMostPopular(Integer k) {
        JSONObject jsonObject = new JSONObject();
        List<Integer> persons = friendshipRepository.findMostPopular();
        int i = 0;
        boolean stopped = false;
        JSONArray jsonArray = new JSONArray();
        for (Integer person : persons) {
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("Place", i + 1);
            jsonObject1.put("Person", userRepository.findById(person).get().getUsername());
            jsonArray.add(jsonObject1);
            if ((i + 1) == k) {
                stopped = true;
                break;
            }
            i++;
        }
        if (stopped) {
            i--;
            jsonObject.put("Top " + i, jsonArray);
        } else {
            jsonObject.put("Top " + i, jsonArray);
        }
        return jsonObject.toJSONString();
    }

    public String firstKLeastPopular(Integer k) {
        JSONObject jsonObject = new JSONObject();
        List<Integer> persons = friendshipRepository.findLeastPopular();
        int i = 1;
        JSONArray jsonArray = new JSONArray();
        for (Integer person : persons) {
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("Place", i);
            jsonObject1.put("Person", userRepository.findById(person).get().getUsername());
            jsonArray.add(jsonObject1);
            if (i == k)
                break;
            i++;
        }
        jsonObject.put("Top " + i, jsonArray);
        return jsonObject.toJSONString();
    }

    public String findMostImportantInTheNetwork() {
        JSONObject jsonObject = new JSONObject();
        Map<Integer, Boolean> visited = new HashMap<>();
        List<Person> users = userRepository.findAll();
        for (Person user : users) {
            visited.put(user.getId(), false);
        }
        Integer user = friendshipRepository.findMostPopular().get(0);
//        visited.replace(user, false, true);
        Stack<Integer> usersStack = new Stack<>();
        usersStack.push(user);
        JSONArray jsonArray = new JSONArray();
        while (!usersStack.isEmpty()) {
            List<Friendship> friends = friendshipRepository.findAllById(user);
            boolean friendsAreVisited = false;

            for (Friendship friend : friends) {
                if (!visited.get(friend.getUser2())) {
                    usersStack.push(friend.getUser2());
                }
                friendsAreVisited = friendsAreVisited || visited.get(friend.getUser2());
            }
            if(!friendsAreVisited)
                jsonArray.add(userRepository.findById(user).get().getUsername());
            visited.replace(user, false, true);
            user = usersStack.pop();
        }
        jsonObject.put("Most important users", jsonArray);
        return jsonObject.toJSONString();
    }
}
