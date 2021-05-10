package com.example.laborator11compulsory.requests;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ModifyPersonsNameRequest {

    private final String username;
    private final String newUsername;

}
