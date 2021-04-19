package Repositories;

import Management.EntityManagement;
import Models.Movie;

import javax.persistence.EntityManager;
import java.util.List;

public class MoviesRepository {

    public Object findById(int movie_id) {
        EntityManagement management = EntityManagement.getManagement();
        EntityManager entityManager = management.getEntityManager();
        return entityManager.find(Movie.class, movie_id);
    }

    public Object findByName(String name) {
        EntityManagement management = EntityManagement.getManagement();
        EntityManager entityManager = management.getEntityManager();
        List<Object> query = entityManager.createNamedQuery("Movie.findByName").setParameter("title", name).getResultList();
        return query.isEmpty() ? null : query.get(0);
    }

    public void create(Movie movie) {
        EntityManagement management = EntityManagement.getManagement();
        EntityManager entityManager = management.getEntityManager();
        entityManager.persist(movie);
    }
}
