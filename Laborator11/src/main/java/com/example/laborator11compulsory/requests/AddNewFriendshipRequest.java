package com.example.laborator11compulsory.requests;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AddNewFriendshipRequest {
    private final String firstUsername;
    private final String secondUsername;
}
