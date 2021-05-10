package com.example.laborator11compulsory.repositories;

import com.example.laborator11compulsory.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    @Query("SELECT f from Message f where f.user = ?1")
    List<Message> findAllById(Integer id);
}
