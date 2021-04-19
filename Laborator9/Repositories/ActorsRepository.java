package Repositories;

import Models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface ActorsRepository extends JpaRepository<Actor,Integer> {
    @Query("Select a from Actor a where a.name=?1")
    Actor findByName(String name);
    @Query("Select a from Actor a where a.id=?1")
    Actor findById(String name);

    @Modifying
    @Transactional
    default void create(Actor actor) {
        this.save(actor);
    }
}
