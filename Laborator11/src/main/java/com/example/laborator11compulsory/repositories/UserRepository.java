package com.example.laborator11compulsory.repositories;


import com.example.laborator11compulsory.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByUsername(String username);

    @Override
    List<Person> findAll();

    @Transactional
    @Modifying
    @Query("UPDATE Person a" + " set a.username=?2 where a.username=?1")
    int modifyName(String username, String newUsername);
}
