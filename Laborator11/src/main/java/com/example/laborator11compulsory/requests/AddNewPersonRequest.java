package com.example.laborator11compulsory.requests;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
//@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AddNewPersonRequest {
    @JsonProperty("username")
    private final String username;

    @JsonCreator
    public AddNewPersonRequest(String username) {
        this.username = username;
    }
}
