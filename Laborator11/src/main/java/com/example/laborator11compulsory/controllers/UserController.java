package com.example.laborator11compulsory.controllers;

import com.example.laborator11compulsory.models.MyException;
import com.example.laborator11compulsory.requests.AddNewPersonRequest;
import com.example.laborator11compulsory.requests.ModifyPersonsNameRequest;
import com.example.laborator11compulsory.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "https://localhost:8443")
@RestController
@RequestMapping(path = "/", method = {RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE, RequestMethod.PUT}/*, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE*/)
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(path = "personsList")
    public String getUsersList() {
        return userService.getAllUsers();
    }

    @PostMapping(path = "addPerson")
    public String addPerson(@RequestBody AddNewPersonRequest addNewPersonRequest) throws MyException {
        return userService.addNewUser(addNewPersonRequest);
    }

    @PostMapping(path = "login")
    public String login(@RequestBody AddNewPersonRequest addNewPersonRequest) throws MyException {
        return userService.login(addNewPersonRequest);
    }

    @PutMapping(path = "modifyName")
    public String modifyPersonsName(@RequestBody ModifyPersonsNameRequest modifyPersonsNameRequest) throws MyException {
        return userService.modifyUsersName(modifyPersonsNameRequest);
    }

    @DeleteMapping(path = "deletePerson")
    public String deletePerson(@RequestBody AddNewPersonRequest addNewPersonRequest) throws MyException {
        return userService.deletePerson(addNewPersonRequest);
    }
}
