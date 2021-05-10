package com.example.laborator11compulsory.services;

import com.example.laborator11compulsory.models.MyException;
import com.example.laborator11compulsory.models.Person;
import com.example.laborator11compulsory.repositories.UserRepository;
import com.example.laborator11compulsory.requests.AddNewPersonRequest;
import com.example.laborator11compulsory.requests.ModifyPersonsNameRequest;
import lombok.AllArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public String getAllUsers() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("users", userRepository.findAll());
        return jsonObject.toJSONString();
    }

    public String addNewUser(AddNewPersonRequest addNewPersonRequest) throws MyException {
        Person person = new Person();
        person.setUsername(addNewPersonRequest.getUsername());
        JSONObject jsonObject = new JSONObject();
        if (userRepository.findByUsername(addNewPersonRequest.getUsername()).isPresent()) {
            throw new MyException("A person with this username already exists, please choose another one.");
        } else {
            userRepository.save(person);
            jsonObject.put("message", "Person successfully saved.");
        }
        return jsonObject.toJSONString();
    }

    public String modifyUsersName(ModifyPersonsNameRequest modifyPersonsNameRequest) throws MyException {
        JSONObject jsonObject = new JSONObject();
        if (!userRepository.findByUsername(modifyPersonsNameRequest.getUsername()).isPresent()) {
            throw new MyException("A person with this username does not exist, please choose another one.");
        } else if (userRepository.findByUsername(modifyPersonsNameRequest.getNewUsername()).isPresent()) {
            jsonObject.put("message", "A person with this username already exists, please choose another one.");
        } else {
            userRepository.modifyName(modifyPersonsNameRequest.getUsername(), modifyPersonsNameRequest.getNewUsername());
            jsonObject.put("message", "Person's name successfully updated.");
        }
        return jsonObject.toJSONString();
    }

    public String deletePerson(AddNewPersonRequest addNewPersonRequest) throws MyException {
        JSONObject jsonObject = new JSONObject();
        if (!userRepository.findByUsername(addNewPersonRequest.getUsername()).isPresent()) {
            throw new MyException("No person with this username exists, please choose another one.");
        } else {
            userRepository.delete(userRepository.findByUsername(addNewPersonRequest.getUsername()).get());
            jsonObject.put("message", "Person successfully deleted.");
        }
        return jsonObject.toJSONString();
    }

    public String login(AddNewPersonRequest addNewPersonRequest) throws MyException {
        JSONObject jsonObject = new JSONObject();
        if (!userRepository.findByUsername(addNewPersonRequest.getUsername()).isPresent()) {
            throw new MyException("Username " + addNewPersonRequest.getUsername() + " not found.");
        } else
            jsonObject.put("message", "Successfully logged in.");
        return jsonObject.toJSONString();
    }
    //todo: Login
}
