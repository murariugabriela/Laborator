package com.example.laborator11compulsory.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "messages", schema = "public")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "messages_id_seq")
    private Integer id;

    @Column(name = "id_user")
    private Integer user;

    @Column(name = "message")
    private String message;
}
