package com.example.laborator11compulsory.requests;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SendMessageRequest {
    private final String username;
    private final String message;
}
