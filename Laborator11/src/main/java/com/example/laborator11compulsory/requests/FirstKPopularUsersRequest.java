package com.example.laborator11compulsory.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class FirstKPopularUsersRequest {
    @JsonProperty("k")
    private final Integer k;

    @JsonCreator
    public FirstKPopularUsersRequest(Integer k) {
        this.k = k;
    }
}
