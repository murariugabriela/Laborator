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
@Table(name = "friendships", schema = "public")
public class Friendship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "friendships_id_seq")
    private Integer id;

    @Column(name = "id_user_1")
    private Integer user1;

    @Column(name = "id_user_2")
    private Integer user2;
}
