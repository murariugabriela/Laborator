package com.example.laborator11compulsory.controllers;

import com.example.laborator11compulsory.models.MyException;
import com.example.laborator11compulsory.requests.AddNewFriendshipRequest;
import com.example.laborator11compulsory.services.FriendshipService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping(path = "/", method = {RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE, RequestMethod.PUT}/*, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE*/)
@AllArgsConstructor
public class FriendshipController {
    private final FriendshipService friendshipService;

    @GetMapping(path = "friendshipList/{username}")
    public String getUsersList(@PathVariable("username") String username) throws MyException {
        return friendshipService.getUsersFriends(username);
    }

    @PostMapping(path = "addFriendship")
    public String addFriendship(@RequestBody AddNewFriendshipRequest addNewFriendshipRequest) throws MyException {
        return friendshipService.addFriendship(addNewFriendshipRequest);
    }

    @GetMapping(path = "mostKPopular/{k}")
//    public String getMostKPopular(@RequestBody FirstKPopularUsersRequest firstKPopularUsersRequest) {
    public String getMostKPopular(@PathVariable("k") Integer k) {
//        return friendshipService.firstKMostPopular(firstKPopularUsersRequest.getK());
        return friendshipService.firstKMostPopular(k);
    }

    @GetMapping(path = "leastKPopular/{k}")
    public String getLeastKPopular(@PathVariable("k") Integer k) {
        return friendshipService.firstKLeastPopular(k);
    }

    @GetMapping(path = "mostImportantInTheNetwork")
    public String getMostImportant() {
        return friendshipService.findMostImportantInTheNetwork();
    }
}
