package com.example.laborator11compulsory.repositories;

import com.example.laborator11compulsory.models.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendshipRepository  extends JpaRepository<Friendship, Integer> {

    @Query("SELECT f from Friendship f where f.user1 = ?1")
    List<Friendship> findAllById(Integer id);

    @Query("SELECT f.user1 from Friendship f group by f.user1 order by count(f.user1) desc")
    List<Integer> findMostPopular();

    @Query("SELECT f.user1 from Friendship f group by f.user1 order by count(f.user1)")
    List<Integer> findLeastPopular();
}
